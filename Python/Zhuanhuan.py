# -*- coding: UTF-8 -*-
# -*- auth: vitan -*-
# 摄氏度转华氏度
clesius = float(input('请输入摄氏温度：'))
fahrenheit = (clesius * 1.8 )+32
print("转换后的温度是{:.1f}F".format(fahrenheit))
# 华氏转度摄氏度
fahrenheit = float(input('输入华氏温度:'))
celsius = (fahrenheit - 32)/1.8
print("转换后的温度是{:.1f}C".format(celsius))
