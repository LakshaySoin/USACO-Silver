from operator import itemgetter

N = int(input())

north = []
east = []

for i in range(N):
    direction, x, y = input().split()
    if direction == "N":
        north.append([int(x), int(y), i])
    elif direction == "E":
        east.append([int(x), int(y), i])

north.sort()
east.sort(key=itemgetter(1))

stop = [None for _ in range(N)]

for i in range(len(north)):
    for x in range(len(east)):
        if north[i][0] > east[x][0] and north[i][1] < east[x][1]:
            ndist = east[x][1] - north[i][1]
            edist = north[i][0] - east[x][0]
            if ndist < edist and stop[east[x][2]] == None:
                stop[east[x][2]] = north[i][0]
            if edist < ndist and stop[east[x][2]] == None:
                stop[north[i][2]] = east[x][1]
                break

ans = [-1 for _ in range(N)]

for i in range(len(north)):
    if stop[north[i][-1]] != None:
        ans[north[i][-1]] = stop[north[i][-1]] - north[i][1]

for x in range(len(east)):
    if stop[east[x][-1]] != None:
        ans[east[x][-1]] = stop[east[x][-1]] - east[x][0]

for i in ans:
    if i == -1:
        print("Infinity")
    else:
        print(i)    