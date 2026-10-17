'''
Q6. Given a list of words:
words = ["apple", "banana", "kiwi", "cherry", "mango"]
Create a dictionary that maps each word to its length.
Example:{"apple": 5, "banana": 6, "kiwi": 4, ...}
'''

words = ["apple", "banana", "kiwi", "cherry", "mango"]

dict = {}

for ch in words:

    
    if(dict.get(ch) == None):
        dict.update({ch:len(ch)})

print(dict)


#or

'''
words = ["apple", "banana", "kiwi", "cherry", "mango"]

word_lengths = {}

for ch in words:
    word_lengths[ch] = len(ch)

print(word_lengths)
'''


