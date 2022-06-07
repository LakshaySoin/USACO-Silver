n = int(input())

years = ["Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox"]

dict1 = {"Bessie": 0}
dict2 = {"Bessie": "Ox"}

for i in range(n):
    line = input().split()
    if (i == 0):
        diff = 0
        index = -1
    else:
        diff = dict1[line[7]]
        index = years.index(dict2[line[7]])
    if line[3] == "previous":
        if index < -12:
            index = -1
        while years[index] != line[4]:
            index -= 1
            diff -= 1
            if index < -12:
                index = -1
    else:
        if index > 11:
            index = 0
        while years[index] != line[4]:
            index += 1
            diff += 1
            if index > 11:
                index = 0
    dict1[line[0]] = diff
    dict2[line[0]] = line[4]

print(abs(dict1["Elsie"]))