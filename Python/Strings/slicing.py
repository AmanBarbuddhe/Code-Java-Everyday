# we can slice our string and can make substrings out of it
# str[starting_index , ending_index] ---> where ending index not include

str = "Python"
print(str[2:4])

word = "I study at ApnaCollege"
print(word[11:]) # if not mentioned ending index --> it by-default goes to the end
print(word[11:len(word)])
print(word[:len(word)])
print(word[:])

# negative index values 

word1 = "Python"  # n --> -1 , o --> -2 , h --> -3 , t --> -4 , y --> -5 , P --> -6
print(word1[-4:-2])