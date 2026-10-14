# reverse a no. 312 --> 213

def reverse_number(n):

    reverse = 0

    while(n>0):

        

        a = n % 10
    
        reverse = a + reverse*10

        n = n // 10

    return reverse

n = int(input("Enter the no. :"))

print(f"Reverse of {n} is {reverse_number(n)}")
