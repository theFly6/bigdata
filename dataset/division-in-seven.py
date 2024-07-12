# 请读取51job.csv文件
# 将51job.csv文件中的数据随机抽取20000-40000条数据
# 存放到名为51job-[1-7]的七个文件中

import pandas as pd
import random
import os

# CSV 文件路径
csv_file_path = '51job.csv'

# 目标数据条数范围
min_rows = 20000
max_rows = 40000

# 读取 CSV 文件
df = pd.read_csv(csv_file_path, encoding='utf8')

# 检查 CSV 文件是否有足够的行
if len(df) < min_rows:
    print("CSV 文件中的行数小于最小要求，无法抽取所需数据。")
else:

    # 定义文件名列表
    files = ['51job-split/51job-{}.csv'.format(i) for i in range(1, 8)]
    for i in range(0, 7):
      # 随机抽取数据
      N = n=random.randint(min_rows, max_rows)
      sampled_data = df.sample(N, replace=False)
    #   print(sampled_data.columns)
      sampled_data.to_csv(files[i],  mode='w', encoding="utf8", index=False)
      print(f"数据已写入 {files[i]}, len {N}")

print("数据抽取和分文件完成。")
