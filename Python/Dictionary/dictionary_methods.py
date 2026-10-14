info = {

    "Name" : "Aman",
    "cgpa" : 8.61,
    "subjects" : ["maths","science"]

}

dict_keys = list(info.keys()) # converted dictionary to list  , info.keys() --> returns all keys of the dictionary
dict_values = list(info.values()) # info.values() --> returns all keys of the dictionary

print(dict_keys)
print(dict_values) 
print(info.items()) # returns key value pairs


# to access dictionary values
# 1) dict[key]    -->  if we insert wrong key , then it gives error
# 2) dict.get(key) --> if we insert wrong key , then it returns "none"

print(info.get("subjects"))

# to add a new item i.e. a new key value pair in the dictionary

info.update({
    "company":"tcs"
    })

print(info)