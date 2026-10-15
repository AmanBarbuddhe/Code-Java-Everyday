def palindrome(string):

    i = 0
    j = len(string) - 1

    while(i<j):
        if(string[i] != string[j]):
            return "Not a Palindrome"
        else:
            i+=1
            j-=1
    return "String is a palindrome"

print(palindrome("madam"))