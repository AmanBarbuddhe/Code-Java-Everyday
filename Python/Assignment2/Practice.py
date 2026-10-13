#Question 1
'''
salary = int(input("Enter your salary :"))

if(salary < 30000):
    print("Final tax rate = 5%")
elif(salary >=30000 and salary <=70000):
    print("Final tax rate = 15%")
else:
    print("Final tax rate = 25%")
'''

#Question 2

'''
def even(a,b):
    for i in range(a,b+1):
        if(i%2==0):
            print(i)
        
even(1,10) 
'''
'''
#Question 3

def digit(n):

    while(n>0):
        print(n%10)
        n = n // 10
digit(312)
'''
'''
#Question 4

def digit(n):
    count = 0
    for var in n:
        count+=1
    print(count)

n = input("Enter your no. :")

digit(n)

#OR

def digit(n):

    if(n==0):
        return 1
    count = 0

    while n > 0:
        count += 1
        n = n // 10

    return count

while(1):
    n = int(input("Enter the no. :"))
    print(digit(n))

    a = int(input("Do you want to continue , if Yes enter 1 and if No enter 0 : "))

    if(a==0):
        break
print("Thank You !!!!!!!")
'''
'''
#Question 5

def digit_sum(n):
    sum = 0
    n = abs(n)
    while(n>0):
        sum = sum + (n%10)
        n = n // 10
    return sum
print(digit_sum(-123))
'''
'''
#Question 6

for i in range(1,101):
    if(i%3==0 and i%5==0):
        print(i)
'''
'''
#Question 7

while(1):
    n = input("Enter the no. , or Quit to stop:")

    if(n.lower()=="quit"):
        break

    n = int(n)


    if(n>0):
        print("No. is positive")
    elif(n<0):
        print("No. is negative")

    
print("Thank You !!!!")
'''
'''
#Question 8

def calculator(a,b,operation):

    if(operation == '+'):
        ans = a+b
    elif(operation == '-'):
        ans = a-b
    elif(operation == '*'):
        ans = a*b
    elif(operation == '/'):
        
        if(b==0):
            return "Cannot divide by 0"
        
        ans = a/b

    else:
        print("Invalid operation")

    return ans

print(calculator(2,0,'/'))
'''
'''
#Question 9

def is_prime(n):

    if n<=1  :
        return False
    
    for i in range(2,n):
        if(n%i==0):
            return False
        
    return True

print(is_prime(10))
'''
'''
#Question 10

n = 11

guess = int(input("Enter Your Guess :"))

while(guess!=n):
    if(guess > n):
        print("Too high")
    elif(guess < n):
        print("Too low")

    guess = int(input("Try again: "))

print("Congragulations!!!!")
'''





