# Variables are container to store our data(value) in memory

# Computer memory has compartments in which we can store our values , this compartments are called individual bits
# smallest compartment size is 8 bit which is 1 byte

# if we do age = 30

#+--------------------------------+
#|  age     PI                    |                in memory "age" and "PI" named variables gets created         
#| +----+ +-----+ +----+ +----+   |                in which values are stored , the name of the memory location is
#| | 30 | | 3.14| |    | |    |   |                the name of the variables
#| +----+ +-----+ +----+ +----+   |
#|                                |
#+--------------------------------+       

name = "Shraddha"
age = 35
PI1 = 3.14

print(name , age , PI1)
print("My name is :" , name)
print("My age is :" , age - 5)

#Indentation is important 
# this name , age , PI are called identifiers i.e. it identifies the variable , so the name given to variable --> age , is an identifier
# and this are case-sensitive , Python is a case sensitive language i.e. Uppercase and Lowercase are different
# rules of identifiers : 1)all english letters allowed , 2)digits between 0 to 9 allowed , but it should not be used in starting (ex: 1PI --> not allowed)
# 3) _ (underscore is allowed)






