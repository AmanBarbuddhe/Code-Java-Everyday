#sets --> collection of unique elements , sets are mutable but elements has to be immutable(string,tuple) , sets are unordered

s = {1,2,2,2,3} # set will store --> {1,2,3}

print(s)
print(len(s))

s.add(5)  // to add new element
print(s)

# to create empty set --> dont do like s = {} it returns an empty dictionary

st = set() # constructor function
