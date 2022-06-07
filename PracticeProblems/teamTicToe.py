import sys

sys.stdin = open('tttt.in','r')
sys.stdout = open('tttt.out','w')

data = []

for i in range(3):
    data.append(input())

names = []

for i in range(3):
    for x in data[i]:
        if x not in names:
            names.append(x)

single = 0
double = 0

for i in range(len(names)):
    dtemp1 = 0
    dtemp2 = 0
    won = False
    for x in range(3):
        htemp = 0
        vtemp = 0
        for y in range(3):
            if x == 0:
                if y == 0 and data[x][y] == names[i]:
                    dtemp1 += 1
                if y == 2 and data[x][y] == names[i]:
                    dtemp2 += 1
            if x == 1:
                if y == 1 and data[x][y] == names[i]:
                    dtemp1 += 1
                    dtemp2 += 1
            if x == 2:
                if y == 0 and data[x][y] == names[i]:
                    dtemp2 += 1
                if y == 2 and data[x][y] == names[i]:
                    dtemp1 += 1

            if data[x][y] == names[i]:
                htemp += 1
            if data[y][x] == names[i]:
                vtemp += 1

        if htemp == 3 or vtemp == 3:
            won = True

    if dtemp1 == 3 or dtemp2 == 3:
        won = True

    if won:
        single += 1

for i in range(len(names)):
    for n in range(i, len(names)):
        if i != n:
            dtemp1 = 0
            dtemp2 = 0
            won = False
            for x in range(3):
                htemp = 0
                vtemp = 0
                for y in range(3):
                    if x == 0:
                        if y == 0 and (data[x][y] == names[i] or data[x][y] == names[n]):
                            dtemp1 += 1
                        if y == 2 and (data[x][y] == names[i] or data[x][y] == names[n]):
                            dtemp2 += 1
                    if x == 1:
                        if y == 1 and (data[x][y] == names[i] or data[x][y] == names[n]):
                            dtemp1 += 1
                            dtemp2 += 1
                    if x == 2:
                        if y == 0 and (data[x][y] == names[i] or data[x][y] == names[n]):
                            dtemp2 += 1
                        if y == 2 and (data[x][y] == names[i] or data[x][y] == names[n]):
                            dtemp1 += 1

                    if data[x][y] == names[i] or data[x][y] == names[n]:
                        htemp += 1
                    if data[y][x] == names[i] or data[y][x] == names[n]:
                        vtemp += 1

                if htemp == 3 or vtemp == 3:
                    won = True

            if dtemp1 == 3 or dtemp2 == 3:
                won = True

            if won:
                double += 1

print(single)
print(double)
