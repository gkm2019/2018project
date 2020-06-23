import mysql.connector
import csv
import pandas as pd
import matplotlib.pyplot as plt
import statsmodels.api as sm
from statsmodels.tsa.arima_model import ARIMA

# mydb = mysql.connector.connect(
#     #host="cbnuclouddb.cn25twnqpp2k.ap-northeast-2.rds.amazonaws.com",
#     #user="cbnuclouddb",
#     #passwd="aziz1234",
#     #database="kkm2015",
#
#     host = "172.20.10.8",
#     port = "3306",
#     user = "root",
#     password = "0000",
#     database = "seoullo7017"
# )


# mycursor = mydb.cursor()
#
# sql = "select substring(first_time_seen,12,2) from seoullo;"
# mycursor.execute(sql)
# myresult = mycursor.fetchall()
#
# posts = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
# for row in myresult:
#     hour = int(row[0])
#     posts[hour] = posts[hour] + 1

# f = open('output.csv','w', encoding='utf-8')
# wr = csv.writer(f)
# for i in range(0, 23):
#     wr.writerow([i+1, posts[i]])
#
# f.close()

# series = pd.read_csv('Sheet1.csv',header=0, index_col=0, squeeze=True)
# series.plot()


x = []
y = []

with open('Sheet1.csv', 'r') as csvfile:
    plots= csv.reader(csvfile, delimiter=',')
    for row in plots:
        x.append(row[0])
        y.append(int(row[1]))

plt.plot(x,y, marker='o')

x2=[]
y2=[]

with open('Sheet2.csv', 'r') as csvfile2:
    plots= csv.reader(csvfile2, delimiter=',')
    for row in plots:
        x2.append(row[0])
        y2.append(int(row[1]))

plt.plot(x2,y2, marker='o')

plt.title('Data from the CSV File: People and Expenses')

plt.xlabel('date')
plt.ylabel('Number of People')

plt.show()

#
# sm.tsa.graphics.plot_acf(series)
# sm.tsa.graphics.plot_pacf(series)
# plt.show()

# diff_1 = series.diff(periods=1).iloc[1:]
# diff_1.plot()
# sm.tsa.graphics.plot_acf(diff_1)
# sm.tsa.graphics.plot_pacf(diff_1)
# plt.show()
#
#
"""
model = ARIMA(series, order=(0,0,1))
model_fit = model.fit(trend='c', full_output=True, disp=1)
print(model_fit.summary())

model_fit.plot_predict()
fore = model_fit.forecast(steps=7)
print(fore)
"""