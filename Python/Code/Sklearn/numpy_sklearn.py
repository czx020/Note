# 1. 安装scipy，numpy，sklearn包

'''
花萼长度（sepal length）为5.1 cm

花萼宽度（sepal width ）为3.5 cm

花瓣长度（petal length ）为1.4 cm

花瓣宽度（petal width）为 0.2 cm
'''
# 2. 从sklearn包自带的数据集中读出鸢尾花数据集data
from sklearn.datasets import load_iris
import numpy as np
import matplotlib as plt
data = load_iris()
print(data)

# 3.查看data类型，包含哪些数据
print(type(data))
print(data.keys())

# 4.取出鸢尾花特征和鸢尾花类别数据，查看其形状及数据类型
iris_feature = data['feature_names'],data['data']
iris_target = data.target_names,data.target
print('鸢尾花数据：',iris_feature)
print('鸢尾花形状类别：',iris_target)
sepal_len = np.array(list(len[0] for len in data['data']))
print('所有花萼长度：',sepal_len)

# 5.取出所有花的花萼长度(cm)的数据
petal_len = np.array(list(len[2] for len in data['data']))
petal_len.resize(5,30)  #重新分配花瓣长度petal_len的内存
petal_wid = np.array(list(len[3] for len in data['data']))
petal_wid.resize(5,30)  #重新分配花瓣宽度petal_wid的内存
iris_lens = (petal_len,petal_wid)
print('所有花瓣长宽：',iris_lens)

# 6.取出所有花的花瓣长度(cm)+花瓣宽度(cm)的数据
petal_len = np.array(list(len[2] for len in data['data']))
petal_len.resize(5,30)  #重新分配花瓣长度petal_len的内存
petal_wid = np.array(list(len[3] for len in data['data']))
petal_wid.resize(5,30)  #重新分配花瓣宽度petal_wid的内存
iris_lens = (petal_len,petal_wid)

# 7.取出某朵花的四个特征及其类别。
print(data['data'][1],data['target'][1])

# 8.将所有花的特征和类别分成三组，每组50个
iris_set = []  #0表示山鸢尾花
iris_ver = []  #1表示杂色鸢尾花
iris_vir = []  #3表示维吉尼亚鸢尾花
for i in range(0,150):  #for循环遍历所有的数据
    if data['target'][i] == 0:  # 类别为0的为setosa花，生成一条setosa类的鸢尾花数据
        db = data['data'][i].tolist()
        db.append('setosa')
        iris_set.append(db)
    elif data['target'][i]==1:  # 类别为1的即为versicolor，生成一条versicolor类的鸢尾花数据
        db = data['data'][i].tolist()
        db.append('versicolor')
        iris_ver.append(db)
    else:                          #剩下类别为virginica鸢尾花数据
        db = data['data'][i].tolist()
        db.append('virginica')
        iris_vir.append(db)

# 9.生成新的数组，每个元素包含四个特征+类别
iris_result = np.array([iris_set, iris_ver, iris_vir])
print("分组:", iris_result)

# 10.计算鸢尾花花瓣长度的最大值，平均值，中值，均方差。

# 11.显示鸢尾花某一特征的曲线图，散点图。

# 用np.random.normal()产生一个正态分布的随机数组，并显示出来。
a = np.random.normal(3,3)
x = np.linspace(0,10,num=10)
plt.plot(x,a)
plt.show()
plt.scatter(x,a)
plt.show()

# np.random.randn()产生一个正态分布的随机数组，并显示出来。
b = np.random.random()
print(b)
# 显示鸢尾花花瓣长度的正态分布图，曲线图，散点图。
