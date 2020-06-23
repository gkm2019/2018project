from sklearn.metrics.pairwise import cosine_similarity
#item-based
print(cosine_similarity([[5, 5, 4, 2, 4]], [[5, 4, 4, 5, 5]]))

print(cosine_similarity([[2, 4, 4, 3, 3]], [[5, 4, 4, 5, 5]]))

print(cosine_similarity([[1, 2, 5, 1, 1]], [[5, 4, 4, 5, 5]]))

print(cosine_similarity([[2, 1, 2, 4, 1]], [[5, 4, 4, 5, 5]]))

