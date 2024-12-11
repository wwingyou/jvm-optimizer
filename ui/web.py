import streamlit as st
import pickle
import pyperclip

opt_prefix = [
    '-Xms',
    '-Xmx',
    '-XX:MinHeapFreeRatio=',
    '-XX:MaxHeapFreeRatio=',
    '-XX:NewRatio=',
    '-XX:SurvivorRatio=',
]
opt_suffix = ['m', 'm', '', '', '', '']

with open('models/param_model.pkl', 'rb') as file:
    param_model = pickle.load(file)

with open('models/range_model.pkl', 'rb') as file:
    range_model = pickle.load(file)

st.title('⚡️JVM Parameter Optimizer')
st.header('Environment')
env_col = st.columns(4)
core = env_col[0].number_input('Core', 1, 32, value=4)
bogomips = env_col[1].number_input('BogoMips', 0.0, 500.0, step=0.1, format="%0.1f", value=108.0)
memory = env_col[2].number_input('Memory (GB)', 1, 64, value=8)
rps = env_col[3].number_input('RPS(Request Per Second)', 1, 100, value=15)

env = [core, bogomips, memory, rps]
perf_range = range_model.predict([env])[0]

st.header('Performance')
perf_col = st.columns(2)
p95 = perf_col[0].slider('p95', perf_range[0], perf_range[1])
p99 = perf_col[1].slider('p99', perf_range[2], perf_range[3])


clicked = st.button('Predict')

params = [0] * 6
x = [*env, p95, p99]

if clicked:
    params = param_model.predict([x])[0]
    params = [round(num) for num in params]


st.header('Parameters')
param_col = st.columns(3)
with param_col[0]:
    st.text_input('Min Heap (MB)', str(params[0]), disabled=True)
    st.text_input('Max Heap (MB)', str(params[1]), disabled=True)

with param_col[1]:
    st.text_input('Min Heap Free Ratio', str(params[2]), disabled=True)
    st.text_input('Max Heap Free Ratio', str(params[3]), disabled=True)

with param_col[2]:
    st.text_input('New Ratio', str(params[4]), disabled=True)
    st.text_input('Survivor Ratio', str(params[5]), disabled=True)

opts = [opt_prefix[idx] + str(params[idx]) + opt_suffix[idx] for idx in range(6)]
opts_line = ' '.join(opts)
st.text_input('Option', opts_line)


if st.button('Copy'):
    pyperclip.copy(opts_line)
