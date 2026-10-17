'''
Q10. Ask the user for a string and print:
• All unique characters
• The count of unique characters
'''

word = input("Enter your string :").lower()

di = {}

for ch in word:
    if ch not in di:
        di[ch] = 1

print(f"Unique element :{list(di)}")
print(f"Count :{len(di)}")        


