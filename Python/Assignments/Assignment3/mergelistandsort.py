def merge_list_and_sort(list1,list2):


    '''
    result = list1+list2
    result.sort()
    return result
    '''

        #OR

    for num in list2:
        list1.append(num)

    list1.sort()
    return list1


n = int(input("Enter size of List1 :"))
list1 = []

for i in range(n):
    b = int(input("Enter element in the list :"))
    list1.append(b)

x = int(input("Enter size of List2 :"))
list2 = []

for i in range(x):
    b = int(input("Enter element in the list :"))
    list2.append(b)

print(f"List1 :{list1}")
print(f"List2 :{list2}")

print(f"Result : {merge_list_and_sort(list1,list2)}")



