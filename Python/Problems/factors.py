def factor_no(n):

    count = 0

    if n <= 0 :
        print("Enter a valid number")
        return

    
    for i in range(1,n+1):
        if(n%i==0):
            count+=1
            print(f"Factors of {n} are {i}")

    print(f"Total factors of {n} are {count}")

n = int(input("Enter the no. whoes factors you want to find :"))

factor_no(n)
            

