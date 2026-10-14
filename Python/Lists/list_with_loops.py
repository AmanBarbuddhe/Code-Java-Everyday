nums = [1,2,3,10,4]
'''
for val in nums:
    print(val)
'''

# linear search

x = 10
index = 0
for val in nums:
    if(val == x):
        print(index)
        break
    index += 1