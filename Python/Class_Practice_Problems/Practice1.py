# Given a list of tuples with info(name,subject):

info = [
    ("Alice","Math"),
    ("Bob","Science"),
    ("Alice","Science"),
    ("Charlie","Math"),
    ("Bob","Math"),
    ("Alice","English"),
    ("Charlie","English")
]

#Q.list all unique course

#1st retrieve all the courses and then , store those courses into a "set" to get unique courses 

unique_courses = set() # to create an empty set
for tup in info:                    # tup goes to each entry of info 
    unique_courses.add(tup[1])   # to access courses(tup[1])    #     0       1
                                                                # ("Alice","Math")         
    
# or we can also do like --> for name , course in info:  
#                                print(name,course)     ---> unpacking the tuple
print(unique_courses)


#Q.list students enrolled in "English"

for name , course in info:
    if course == "English":
        print(name)



