# infinite loop --> keep condition in while always true

'''
while True:
    print("Hello World")
'''
'''
count = 1

while(count <= 5):
    print("Hello World")
    count+=1
'''
'''
count = 1

while(count<=5):
    print(count)
    count+=1
'''
'''
count = 5

while(count>=1):
    print(count)
    count-=1
'''

#break --> to break the loop

'''
i = 1

while(i<=10):
    if(i%6==0):
        break
    print(i)
    i+=1
print("outside the loop.....")
'''

#continue --> skips the current iteration

'''
i = 1

while(i<=10):
    if(i%6==0):
        i+=1
        continue
    print(i)
    i+=1
print("outside the loop.....")
'''
'''
#print all the odd no.s 1 to 10

i = 0

while(i<10):
    i+=1
    if(i%2==0):
        continue
    print(i)
'''

#for loop --> used for sequential traversing

string = "hello"

#in ==> membership operator i.e. it tracks the member and check presence of value

#in can be used in conditional statements also
'''
if 'o' in string:
    print("o exists in string")
else:
    print("o does not exist in string")
'''

'''
for var in string:  # var stores members of string 
    print(var)
'''
# to print sequence using for
 
''' 
for i in range(5):    # 5 is the max value , loop runs from 0 to 4 i.e. 5-1 , range() is a function in python
    print(i+1)
'''
#count no. of i's in the given word

word = "artificial intelligence"

count = 0

'''
for var in word:
    if 'i' in var:
        count+=1
print(count)
'''
'''
#or

for var in word:
    if(var=='i'):
        count+=1
print(count)
'''












