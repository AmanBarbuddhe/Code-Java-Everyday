# Given a list of integers compute the average of all numbers in the list.

def avg_list(numbers):

    element_sum = 0

    for num in numbers:

        element_sum += num

    avg = (element_sum) / len(numbers)

    return avg


n = int(input("Enter size of list :"))

numbers = []

for i in range(n):

    b = int(input("Enter element in list :"))
    numbers.append(b)

print(f"Entered list is :{numbers}")

print(f"Average of list element : {avg_list(numbers)}")
