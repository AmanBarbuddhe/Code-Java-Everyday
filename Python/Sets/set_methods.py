s = {1,2,2,2,3}

#1
s.add(5)
print(s)

#2
s.remove(1)
print(s)

'''
#3
s.clear() # to empty the set
print(s)
'''

#4
print(s)
s.pop()  # removes a random values
print(s)

#5
s1 = {1,2,3,4,5,6}
s2 = {3,4,7,8,9,10}

print(s1.union(s2))
print(s1.intersection(s2))
