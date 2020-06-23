import numpy as np
from scipy.stats import pearsonr
import sys

me = open('구경민.txt')
user1=open('정예원.txt')
user2=open('김소민.txt')
user3=open('박소연.txt')
user4=open('고석빈.txt')
user5=open('권아영.txt')


me1=[]
u1=[]
u2=[]
u3=[]
u4=[]
u5=[]
s1=[]
s2=[]
s3=[]
s4=[]
s5=[]
for line in me.readlines():
    me = line.strip().split(',')

for line in u1.readlines():
    u1 = line.strip().split(',')
for line in u2.readlines():
    u2 = line.strip().split(',')
for line in u3.readlines():
    u3 = line.strip().split(',')
for line in u4.readlines():
    u4 = line.strip().split(',')
for line in u5.readlines():
    u5 = line.strip().split(',')

for i in range(0,6):
    me1.append(int(me[i]))
    s1.append(int(u1[i]))
    s2.append(int(u2[i]))
    s3.append(int(u3[i]))
    s4.append(int(u4[i]))
    s5.append(int(u5[i]))


matrix = np.array([me1,s1,s2,s3,s4])
print(matrix)
corr = np.corrcoef(matrix)
print(corr)
