def fact(n):

    pdt = 1

    for i in range(1,n+1):
        pdt = pdt*i
    return pdt

print(fact(5))