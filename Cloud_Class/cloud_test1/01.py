import matplotlib
import matplotlib.pyplot as plt
import numpy as np

#from scipy.stats import pearsonr

#user-based
"""
matplotlib.style.use('ggplot')

alice = np.array([3, 2, 5, 2])
user1 = np.array([4, 5, 5, 2, 3])
user2 = np.array([3, 5, 1, 5, 5])
user3 = np.array([3, 4, 5, 2, 2])
user4 = np.array([5, 4, 1, 3, 2])
user5 = np.array([4, 5, 2, 4, 5])
"""
"""
from scipy.stats import pearsonr

matrix = np.array([[3, 2, 5, 2],
                            [4, 5, 5, 2],
                            [3, 5, 1, 5],
                            [3, 4, 5, 2],
                            [5, 4, 1, 3],
                            [4, 5, 2, 4]
                           ])

corr = np.corrcoef(matrix)

print(corr)

"""
