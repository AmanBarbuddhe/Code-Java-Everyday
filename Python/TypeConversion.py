'''
Type Conversion --> implicit --> it is done by python interpreter itself
ex : a = 10
     b = 5
     print(a/b) --> 2.0
     print(type(a/b)) --> <class 'float'>

ex : ans = 5 + 10.0
we get answer in float

Type Casting --> Explicit --> it is done by developers , forceful conversion , but valid only for compatible type
compatible type --> int to float , float to int , int to bool

ex: ans = int(5 + 10.0) #casting
     
'''
val = int("123")
print(val,type(val)) # o/p --> 123 <class 'int'>

#note : when value inside bool is non-zero it returns true and when value inside bool is zero it returns false 
val = bool(10)
print(val,type(val))
