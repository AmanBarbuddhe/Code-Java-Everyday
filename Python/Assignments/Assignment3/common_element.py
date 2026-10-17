def common(list1,list2):

    s1 = set(list1)
    s2 = set(list2)

    if(s1.intersection(s2)):
        return "Common element present!!!"
    else:
        return "Common element not present!!!"


list1 = []
list2 = []

n = int(input("Enter size of list1 :"))

for i in range(n):
    a = int(input("Enter elements of list1 :"))
    list1.append(a)

d = int(input("Enter size of list2 :"))

for i in range(d):
    a = int(input("Enter elements of list1 :"))
    list2.append(a)    

print(common(list1,list2))