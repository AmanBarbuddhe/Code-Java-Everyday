#Functions --> blocks of statement that perform a specific task 

'''
def hello(): #function call
    print("hello")

hello() #function definition

def sum(a,b):  # a,b are parameters and 5,4 i.e. actual values are called arguments 
    print(a+b)

sum(5,4)

def mul(a,b):
    return a*b
print(mul(5,4))
'''
'''
# Function to print average of 3 no.s

def avg(a,b,c):
    return (a+b+c)/3
print(avg(1,1,1))

# default parameters

def sum(a,b=1):  #(non-default parameter,default parameter) , always 1st --> non-default , 2nd --> can be default 
    return a+b
print(sum(5))
'''

# types of function --> built-in i.e. print(),input(),type(),range() and user-defined functions

#lambda functions --> higher order function i.e. either the parameters are function or the value we are returning is a function

sum = lambda a,b: a+b
print(sum(4,5))

avg = lambda a,b: (a+b)/2
print(avg(4,5))
