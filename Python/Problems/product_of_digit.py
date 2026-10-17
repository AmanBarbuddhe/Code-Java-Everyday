def product(n):

    n = abs(n) 
    pdt = 1

    while(n>0):
        pdt *= n % 10
        n = n // 10

    return pdt

print(product(-234))

#returns 1 if n = abs(n) is not used and n is negative , returns 1 , because we have set initial value as 1