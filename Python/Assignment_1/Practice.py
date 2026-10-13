# Write a program that asks the user for their name and age, then prints a sentence like:

'''
a = input("Enter your name :")
b = int(input("Enter your age :"))

print("Hello", a ,", you are",b,"years old!")

'''

# Take two numbers as input from the user and print their sum, difference, product, and quotient

'''

a = float(input("Enter the value of a :"))
b = float(input("Enter the value of b :"))

print("Sum :" , (a+b))
print("Difference :" , (a-b))
print("Product :" , (a*b))
print("Quotient :" , (a/b))

'''

# Ask the user to enter two integers and one float. Convert them all to floats and print their average.

'''

a = int(input("Enter the 1st no. :"))
b = int(input("Enter the 2nd no. :"))
c = float(input("Enter the 3rd no. :"))

print("Average : " , (float(a)+float(b)+c)/3)

'''
#Q4. The user enters a string containing a number (e.g., "45" ). Convert it to:
#• an integer
#• a float
#• a string again
#Print all three values with their types.

'''

a = input("Enter the no. -> 45 :")

val1 = int(a)
print(val1,type(val1))

val2 = float(a)
print(val2,type(val2))

print(a,type(a))

'''

# Evaluate and print the result of the following expression:

'''
x = 10 + 3 * 2 ** 2

print(x)
'''

# Write a program to swap values of two numbers entered by the user

'''
a = int(input("Enter the 1st no. :"))
b = int(input("Enter the 2nd no. :"))

print("Number before swap --> a :",a,"and b :" ,b)

temp = a
a = b
b = temp

print("Number after swap --> a :",a,"and b :" ,b)
'''

#Method 2

'''
a, b = b, a

print(a)
print(b)
'''

#Ask the user for a temperature in Celsius (string input). Convert it to float , then calculate and print temperature in Fahrenheit.

'''
a = input("Enter the temperature : ")
print("Temperature in Degree Celcius : ",a)

afloat = float(a)

print("Temperature in Fahrenheit :",((afloat*(9/5))+32))
'''

#Take a decimal number as input (like 45.78 ) and output its:
#• integer part - 45
#• fractional part - .78

a = float(input("Enter the no. :"))

Integer_Part = int(a)
Fractional_Part = a - Integer_Part

print("Integer Part :" ,Integer_Part)
print("Fractional Part :" ,round(Fractional_Part,2))