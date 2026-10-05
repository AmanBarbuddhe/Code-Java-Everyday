a = input("Enter value of a : ")
print(a)

b = input("Enter value of b : ")  # b = 10
c = input("Enter value of c : ")  # c = 5

sum = b + c
print(sum) # it gives o/p --> 105 , because input function takes value as string(therefore concatenation of string is occuring) , we will need to convert it to integer

d = int(input("Enter value of d : "))  # b = 10
e = int(input("Enter value of e : "))  # c = 5

sum = d + e
print(sum)