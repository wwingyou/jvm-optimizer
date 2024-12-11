import pandas as pd
import matplotlib.pyplot as plt

input_path = 'input.csv'
output_path = 'output.csv'

input_df = pd.read_csv(input_path)
output_df = pd.read_csv(output_path)

df = pd.concat([input_df, output_df], axis=1)

df['Heap-min-max-ratio'] = df['Max-heap'] / df['Min-heap']
print("ratios = ", df['Heap-min-max-ratio'].unique())
# df = df[df['Heap-min-max-ratio'] == 4]
print(df.groupby('Heap-min-max-ratio').count())

df_low = df[df['RPS'] < 20]
df_low.name = "Low RPS"
df_mid = df[(df['RPS'] >= 20) & (df['RPS'] < 30)]
df_mid.name = "Medium RPS"
df_high = df[df['RPS'] >= 30]
df_high.name = "High RPS"

for df in [df_low, df_mid, df_high]:
    columns = [
        'Min-heap',
        'Max-heap',
        'Min-heap-free-ratio',
        'Max-heap-free-ratio',
        'New-ratio',
        'Survivor-ratio',
        'Heap-min-max-ratio'
    ]

    fig, axes = plt.subplots(2, 4, figsize=(4, 6))

    for idx, column in enumerate(columns):
        grouped_df = df.groupby(column)[[column, 'p95', 'p99']].mean()

        # print(grouped_df)

        grouped_df.plot(
            x=column,
            y=['p95', 'p99'],
            ax=axes[idx // 4, idx % 4],
            kind='line',
        )
        plt.ylabel('Performance')

    fig.suptitle(df.name)
    plt.show()
