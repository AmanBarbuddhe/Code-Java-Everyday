def even_odd(n):

    cnt_even = 0
    cnt_odd = 0

    while(n>0):
       
        a = n % 10

        if( a % 2 == 0):
            cnt_even+=1
        else:
            cnt_odd+=1

        n = n // 10

    return cnt_even , cnt_odd
    

n = int(input("Enter your digit :"))

even , odd = even_odd(n)

print(f"No. of even digit = {even} ,  No. of odd digit = {odd}")