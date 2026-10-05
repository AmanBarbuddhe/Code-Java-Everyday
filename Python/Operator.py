# Arithmetic 
# + , - , * , / , % , **

a = 10
b = 5

# a , b are called operands

print("Arithmetic Operators :")
print("Sum :" ,(a+b))
print("Substraction :" ,(a-b))
print("Multiplication :" ,(a*b))
print("Division :" ,(a/b))
print("Remainder :" ,(a%b))
print("a to the power b :" , (a**b)) # a to the power b 

# Relational/Comparison operators
# > , >= , < , <= , == , !=

c = 10 
d = 5

print("\n")
print("Relational Operators :")

print(c<d)
print(c>d)
print(c>=d)
print(c<=d)
print(c==d)
print(c!=d)
print(5<8)

#Assignment operator
# a=b , storing the value of b in a i.e.assigning 
# a+=1 --> a = a + 1
# a-=1 --> a = a - 1
# similarly a*=5 , a/=5 , a%=5 , a**=5

print("\n")
print("Assignment Operator : ")

e = 10 
f = 11
print("e :" , e)
e = f

print("e :" , e)

g = 20
print("g :",g)
g+=1
print("g :",g)

print("\n")

#Logical Operator
#not --> converts false to true and true to false
#and --> when both true then only we get true
#or --> when both are false then only we get false
print("Logical Operator :")
print("not operator : ")
var = False
print(not var)
print(not (5>8)) # as 5>8 should return false but because of not it reverse it and returns true

print("and operator : ")
print((5>3) and (3>2))

print("or operator : ")
print((5>13) or (3>8))

# other operators in python are --> bitwise , membership operators

#Operator Precedance

'''
High --> ()
     --> **
     --> *,/,%     
     --> +,-
     --> ==,!=,>,>=,<,<=
     --> not
     --> and
Low  --> or

same precedance --> solve left to right

'''