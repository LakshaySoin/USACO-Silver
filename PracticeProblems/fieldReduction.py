import sys

sys.stdin = open('reduce.in','r')
sys.stdout = open('reduce.out','w')

N = int(input())

points = []

for i in range(N):
    x, y = map(int, input().split())
    points.append([x, y])

points.sort()

while i < len(points):
    if points[i][0] < points[2][0] or points[i][0] > points[-3][0]:
        points.pop(points.index(points[i]))
    elif points[i][1] < points[2][1] or points[i][1] > points[-3][0]:
        points.pop(points.index(points[i]))
    else:
        i += 1

print(points)

temp = [points[0], points[-1]]

ans = float("inf")

for i in temp:
    points1 = points.copy()
    points1.pop(points1.index(i))
    x1, y1, x2, y2 = float("inf"), float("inf"), -float("inf"), -float("inf")
    for x in range(len(points1)):
        x1 = min(points1[x][0], x1)
        y1 = min(points1[x][1], y1)
        x2 = max(points1[x][0], x2)
        y2 = max(points1[x][1], y2)
    ans = min((x2 - x1) * (y2 - y1), ans)

print(ans)