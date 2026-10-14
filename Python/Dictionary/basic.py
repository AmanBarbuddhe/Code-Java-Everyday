#Dictionary: key:value pairs

# keys can be string , integer , float also

info = {
    "name" : "Aman",
    "cgpa" : 9.2,
    "subjects" : ["maths" , "science"]
}

print(info)
print(info["name"]) # can access any values from its key

info["cgpa"] = 9.6        # this implies dictionaries are mutable
print(info["cgpa"])

# dictionaries are unordered as there is no indexing in it