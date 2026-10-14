a = 5
b = 10
sum = a + b

#normal formatting
print("Language is {}".format("python"))
print("Sum is {}".format(sum))
print("Sum of {} and {} is {}".format(a,b,sum)) #{} --> placeholder

#index based formatting
                                       # 0 1  2
print("Sum of {1} and {0} is {2}".format(a,b,sum))

#value based formatting
print("{a} Values of variables {a} and {b}".format(a=5,b=10))

#f-strings --> literal string interpolation --> we can embed any variable of expression inside the string

c = 5
d = 3

print(f"sum of {c} and {d} is {c+d}")

