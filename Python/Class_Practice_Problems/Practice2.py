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

#Q.create dictionary (student,set of courses)

#means name of student and set of courses they are studying


dict = {}

for name , course in info:
    if(dict.get(name) == None):
        dict.update({name : set()})
        dict.get(name).add(course)
    else:
        dict.get(name).add(course)
print(dict)