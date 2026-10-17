def even_odd(tup):

    even1 = []
    odd1 = []

    for num in tup:

        if num%2 == 0:
            even1.append(num)
        else:
            odd1.append(num)

    even = tuple(even1)
    odd = tuple(odd1)

    return even , odd
    

n = int(input("Enter the size of tuple :"))

numbers = []

for i in range(n):

    b = int(input("Enter element in tuple :"))
    numbers.append(b)

tup = tuple(numbers)

even , odd = even_odd(tup)

print(f"Even Tuple :{even} ,  Odd Tuple :{odd}")