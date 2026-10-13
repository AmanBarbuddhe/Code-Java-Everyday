a = int(input("Enter no. who's table you want to print :"))
n = int(input("Enter till what value you want to print the table :"))

i = 1

while(i<=n):
    print(a ,"*" , i,"=",a*i)
    i+=1