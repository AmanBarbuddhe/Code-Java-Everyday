color = input("Enter Color :")

match color:
    case "Green":
        print("Go")
    case "Yellow":
        print("Be Ready")
    case "Red":
        print("Stop")
    case _: #default case
        print("Wrong Color!!!")