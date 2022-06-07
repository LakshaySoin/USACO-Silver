from operator import itemgetter

N = int(input())

east = []
north = []

for i in range(N):
    direction, x, y = input().split()
    if direction == "E":
        east.append(list(map(int, [x, y, i])))
    elif direction == "N":
        north.append(list(map(int, [x, y, i])))

east.sort(key=itemgetter(1))
north.sort()

good = [None for _ in range(N)]
blame = [0 for _ in range(N)]

for x in range(len(east)):
    for i in range(len(north)):
        if north[i][0] > east[x][0] and north[i][1] < east[x][1]:
            edist = north[i][0] - east[x][0]
            ndist = east[x][1] - north[i][1]
            if ndist < edist and good[north[i][2]] == None and good[east[x][2]] == None:
                good[east[x][2]] = north[i][0]
                blame[north[i][2]] += blame[east[x][2]] + 1
            if edist < ndist and good[east[x][2]] == None and good[north[i][2]] == None:
                good[north[i][2]] = east[x][1]
                blame[east[x][2]] += blame[north[i][2]] + 1

for i in blame:
    print(i)