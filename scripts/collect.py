import os
import time
import json

os.system("source .env")
os.system("pwd")

# WARN: These system measurements are hardcoded.
# Should be replaced later.
num_of_cpu = 4
bogomips = 108.0
memory = 8

host = os.getenv("REMOTE_HOST")
user = os.getenv("REMOTE_USER")
heap_min_ratio = [25, 50, 75, 100]
heap_max = [600, 800, 1000, 1200, 1400, 1600, 1800, 2000]
heap_min_free_ratio = [30, 40, 50]
heap_max_free_ratio = [60, 70, 80]
new_ratio = [2, 3, 4]
survivor_ratio = [7, 8, 9]
parameters = [
    heap_min_ratio,
    heap_max,
    heap_min_free_ratio,
    heap_max_free_ratio,
    new_ratio,
    survivor_ratio
]
prefix = [
    '-Xms',
    '-Xmx',
    '-XX:MinHeapFreeRatio=',
    '-XX:MaxHeapFreeRatio=',
    '-XX:NewRatio=',
    '-XX:SurvivorRatio=',
]
suffix = [
    'm',
    'm',
    '',
    '',
    '',
    '',
]


def get_next_index_list(prev_list):
    new_list = prev_list[:]
    new_list[0] += 1

    for i in range(len(parameters) - 1):
        if new_list[i] >= len(parameters[i]):
            new_list[i] = 0
            new_list[i + 1] += 1

    return new_list


def is_index_at_the_end(index_list):
    for i in range(len(parameters)):
        if index_list[i] != len(parameters[i]) - 1:
            return False

    return True


def get_parameter_values(index_list):
    values = [0, 0, 0, 0, 0, 0]
    for i in range(2, len(parameters)):
        values[i] = parameters[i][index_list[i]]

    values[1] = heap_max[index_list[1]]
    values[0] = round(values[1] * heap_min_ratio[index_list[0]] / 100)

    return values


def run_test(req_amount, option_string):
    os.system(f"ssh {user}@{host} './run_tester.sh {option_string}'")
    print("Service is now running on remote. wait for 10 seconds to startup...")
    time.sleep(10)
    os.system(f"scripts/warm-up.sh {host}")
    os.system(f"ARTILLERY_REQUEST_COUNT={req_amount} scripts/run-test.sh")


def collect_result(infile, outfile, params):
    with open("report.json", "r") as file:
        report = json.load(file)
        req_rate = report['aggregate']['rates']['http.request_rate']
        p95 = report['aggregate']['summaries']['http.response_time']['p95']
        p99 = report['aggregate']['summaries']['http.response_time']['p99']
        print(f"[RESULT] req_rate={req_rate}, p95={p95}, p99={p99}")
        inputs = [num_of_cpu, bogomips, memory, req_rate, p95, p99]
        outputs = params
        infile.write(",".join(list(map(str, inputs))) + "\n")
        outfile.write(",".join(list(map(str, outputs))) + "\n")


infile = open('input.csv', 'a')
outfile = open('output.csv', 'a')

for req_amount in range(1, 4):
    index_list = [0, 0, 0, 0, 0, 0]
    while (True):
        params = get_parameter_values(index_list)
        strings = []
        for i in range(len(params)):
            strings.append(prefix[i] + str(params[i]) + suffix[i])
        option_string = " ".join(strings)
        print(f"[OPTION] {option_string}")

        run_test(req_amount, option_string)
        collect_result(infile, outfile, params)

        if (is_index_at_the_end(index_list)):
            break
        index_list = get_next_index_list(index_list)

infile.close()
outfile.close()
