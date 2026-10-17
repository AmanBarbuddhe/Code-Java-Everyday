l1 = [1,2,2,2,3,4,4,7,8,9,9,11,11,11,11]

seen = set()
duplicate = set()

for element in l1:
    if element in seen:
        duplicate.add(element)
    else:
        seen.add(element)

print(duplicate)
