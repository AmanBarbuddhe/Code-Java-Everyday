def palindrome(s):

    s = s.lower()

    check = ""

    for ch in s:

        if ch.isalnum() == True :

            check += ch


    i = 0
    j = len(check) - 1

    while(i<j):

        if(check[i] != check[j]):
            return False
        else:
            i+=1
            j-=1
        
    return True

s = input("Enter a string to check if it is palindrome or not :")
print(palindrome(s))

