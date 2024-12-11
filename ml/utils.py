import csv


def get_train_data(input_path, output_path):
    x = []
    y = []
    with open(input_path, mode='r') as file:
        csv_reader = csv.reader(file)
        skip_col = False

        for row in csv_reader:
            if skip_col is False:
                skip_col = True
                continue

            float_row = [float(value) for value in row]
            #
            # if len(float_row) > len(min_x):
            #     min_x = [100_000_000] * len(float_row)
            #     max_x = [0] * len(float_row)
            #
            # for idx in range(len(float_row)):
            #     min_x[idx] = min(min_x[idx], float_row[idx])
            #     max_x[idx] = max(max_x[idx], float_row[idx])
            #
            x.append(float_row)

    with open(output_path, mode='r') as file:
        csv_reader = csv.reader(file)
        skip_col = False

        for row in csv_reader:
            if skip_col is False:
                skip_col = True
                continue
            #
            # if len(float_row) > len(min_y):
            #     min_y = [100_000_000] * len(float_row)
            #     max_y = [0] * len(float_row)
            #
            # for idx in range(len(float_row)):
            #     min_y[idx] = min(min_y[idx], float_row[idx])
            #     max_y[idx] = max(max_y[idx], float_row[idx])
            #
            float_row = [float(value) for value in row]
            y.append(float_row)

    return (x, y)


def normalize(data, min_values, max_values):
    for row in data:
        for idx in range(len(row)):
            row[idx] = (row[idx] - min_values[idx]) / max(max_values[idx] - min_values[idx], 1)


def restore(data, min_values, max_values):
    for row in data:
        for idx in range(len(row)):
            row[idx] = row[idx] * max(max_values[idx] - min_values[idx], 1) + min_values[idx]

