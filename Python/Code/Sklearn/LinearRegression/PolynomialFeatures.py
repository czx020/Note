import numpy as np
from sklearn.datasets import load_boston
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

boston = load_boston()

x = boston.data[:,12].reshape(-1,1)
y = boston.target

LineR = LinearRegression()
LineR.fit(x,y)
w = LineR.coef_
b = LineR.intercept_
plt.scatter(x,y)
plt.plot(x,w*x+b,'r')
plt.show()

p = PolynomialFeatures(degree=2)
x_poly = p.fit_transform(x)
lp = LinearRegression()
lp.fit(x_poly,y)
y_poly = lp.predict(x_poly)

lrp = LinearRegression()
lrp.fit(x_poly,y)
plt.scatter(x,y)
plt.scatter(x,w*x+b,'r')
plt.scatter(x,y_poly)
plt.show()