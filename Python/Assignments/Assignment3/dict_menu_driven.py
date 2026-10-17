''''
Q5. Create a dictionary where:
• Keys = student names
• Values = marks (integer)
Write a menu-based program where user presses a key (A, B, C, D)
depending on the operation they want to perform on the dictionary:
1. A - Add a student
2. B - Update marks
3. C - Search for a student
4. D - Display all students and marks
'''

student = {}

while(True):

    choice = input("A-->Add a student\nB-->Update marks\nC-->Search for a student\nD-->Display all students and marks\nEnter your choice :").upper()


    match choice :

        case "A":

            name = input("Enter name of student :")
            marks = int(input("Enter marks of the student :"))
            student[name] = marks
            print("Student added successfully!!!!")

        case "B":

            x = input("Enter name who's marks you want to enter :")
            if x not in student:
                print("Student does not exist")
            else:
                m = int(input("Enter updated marks :"))
                student[x] = m
                print("Marks Updated!!!")

        case "C":

            y = input("Enter name you want to search :")
            if y not in student :
                print("Student does not exist")
            else:
                print(f"Marks :{student[y]}")


        case "D":

            if not student:
                print("No entry in the dictionary.....")
            else:
                print(student)

        case _:
            print("Wrong Choice!!!!")

    resume = input("Do you want to continue :")

    if(resume.upper()=="NO"):
        break


