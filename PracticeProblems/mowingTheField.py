import sys

sys.stdin = open('mowing.in','r')
sys.stdout = open('mowing.out','w')

N = int(input())

arr = [[0 for _ in range(1000)] for _ in range(1000)]

ans = float("inf")
cnt = 0

i = 50
x = 50

points = []

for _ in range(N):
    direction, time = input().split()
    time = int(time)
    a = 0
    if direction == "N":
        while a < time:
            arr[i][x] += 1
            if arr[i][x] > 1:
                arr[i][x] = 1
                for y in points:
                    if i == y[0] and x == y[1]:
                        ans = min(ans, cnt - y[2])
            points.append([i, x, cnt])
            i -= 1
            a += 1
            cnt += 1
    elif direction == "E":
        while a < time:
            arr[i][x] += 1
            if arr[i][x] > 1:
                arr[i][x] = 1
                for y in points:
                    if i == y[0] and x == y[1]:
                        ans = min(ans, cnt - y[2])
            points.append([i, x, cnt])
            x += 1
            a += 1
            cnt += 1
    elif direction == "S":
        while a < time:
            arr[i][x] += 1
            if arr[i][x] > 1:
                arr[i][x] = 1
                for y in points:
                    if i == y[0] and x == y[1]:
                        ans = min(ans, cnt - y[2])
            points.append([i, x, cnt])
            i += 1
            a += 1
            cnt += 1
    elif direction == "W":
        while a < time:
            arr[i][x] += 1
            if arr[i][x] > 1:
                arr[i][x] = 1
                for y in points:
                    if i == y[0] and x == y[1]:
                        ans = min(ans, cnt - y[2])
            points.append([i, x, cnt])
            x -= 1
            a += 1
            cnt += 1

if ans == float("inf"):
    print(-1)
else:
    print(ans)