'''

#if

age = 21 

if(age>=18):
    print("Eligible to Vote....")

# else

marks = 25

if(marks>=35):
    print("Pass")
else:
    print("Fail")

#elif

number = -20

if(number > 0):
    print("Number is positive...")
elif(number == 0):
    print("Neither positive nor negative...")
else:
    print("Number is Negative")

'''

'''
age = int(input("Enter the age of individual :"))

if(age < 13):
    print("Individual is a child")
elif(age >= 13 and age <=19):
    print("Individual is a teenager")
else:
    print("Individual is a adult")
'''

'''
#Login system 

# The correct username is Aman and correct password is Aman@1234

username = input("Enter the username :")
password = input("Enter the password :")

if(username == "Aman" and password == "Aman@1234"):
    print("Logged in Successfully.....")
elif(username!="Aman"):
    print("Incorrect username!!!")
else:
    print("Incorrect Password!!!")
'''
'''
# check if n is a multiple of 5 or not

a = int(input("Enter the no. :"))

if(a%5 == 0):
    print(a , "is a multiple of 5")
else:
    print("Not multiple of 5")
'''

'''
#print if no. is even or odd

a = int(input("Enter the no. :"))

if(a%2 == 0):
    print(a , "is even")
else:
    print(a , "is odd")
'''

#Nesting

# The correct username is Aman and correct password is Aman@1234

username = input("Enter the username :")
password = input("Enter the password :")

if(username == "Aman"):
    if(password == "Aman@1234"):
        print("Logged in")
    else:
        print("Wrong Password")
else:
    print("Wrong Username")

# if can be use individually i.e. alone but else and elif cannot be used alone  

