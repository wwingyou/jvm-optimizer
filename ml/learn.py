from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error

from utils import get_train_data
from itertools import groupby
import pickle

param_model = LinearRegression()
range_model = LinearRegression()
input_path = 'input.csv'
output_path = 'output.csv'

(x, y) = get_train_data(input_path, output_path)

# Split data into training, validation, and test sets
x_train, x_temp, y_train, y_temp = train_test_split(x, y, test_size=0.4, random_state=42)
x_val, x_test, y_val, y_test = train_test_split(x_temp, y_temp, test_size=0.5, random_state=42)

copy_x = x_train[:]

copy_x.sort(key=lambda r: (r[0:4]))
grouped = groupby(copy_x, key=lambda r: (r[0:4]))

w = []
v = []
idx = 0
for key, group in grouped:
    w.append(key)
    v.append([0] * 4)
    v[idx][0] = 1_000_000
    v[idx][1] = 0
    v[idx][2] = 1_000_000
    v[idx][3] = 0
    for row in group:
        v[idx][0] = min(v[idx][0], row[4])
        v[idx][1] = max(v[idx][1], row[4])
        v[idx][2] = min(v[idx][2], row[5])
        v[idx][3] = max(v[idx][3], row[5])
    idx += 1

test = [[4, 108.0, 8, 10, 105, 180],
        [4, 108.0, 8, 20, 210, 300],
        [4, 108.0, 8, 30, 310, 400],
        [4, 108.0, 8, 40, 410, 500]]

test_range = [[4, 108.0, 8, 10],
              [4, 108.0, 8, 20],
              [4, 108.0, 8, 30],
              [4, 108.0, 8, 40]]

param_model.fit(x, y)
range_model.fit(w, v)

# Validation
print("Validation Results:")
y_val_pred = param_model.predict(x_val)
val_mse = mean_squared_error(y_val, y_val_pred)
print(f"Param Model Validation MSE: {val_mse}")

# Test
print("Test Results:")
y_test_pred = param_model.predict(x_test)
test_mse = mean_squared_error(y_test, y_test_pred)
print(f"Param Model Test MSE: {test_mse}")

print("predict param")
print(param_model.predict(test))
print("predict range")
print(range_model.predict(test_range))

# NOTE: Normalization has no effect
# print("after normalize: ")
# normalize(x, min_x, max_x)
# normalize(y, min_y, max_y)
#
# normalized_reg.fit(x, y)
#
# result = normalized_reg.predict(test)
# restore(result, min_y, max_y)
#
# print(result)

with open('param_model.pkl', 'wb') as file:
    pickle.dump(param_model, file)

with open('range_model.pkl', 'wb') as file:
    pickle.dump(range_model, file)
