import sys

sys.stdin = open('herding.in','r')
sys.stdout = open('herding.out','w')

N = int(input())

locations = []

for _ in range(N):
    locations.append(int(input()))

locations.sort()

minans = 0

if locations[N - 2] - locations[0] == N - 2 and locations[N - 1] - locations[N - 2] > 2:
    minans = 2
elif locations[N - 1] - locations[1] == N - 2 and locations[1] - locations[0] > 2:
    minans = 2
else:
    p2 = 0
    maxrange = 0
    for p1 in range(N):
        while p2 < N - 1 and locations[p2 + 1] - locations[p1] <= N - 1:
            p2 += 1
        temp = p2 - p1 + 1
        maxrange = max(maxrange, temp)
    minans = N - maxrange

maxans = max(locations[N - 2] - locations[0], locations[N - 1] - locations[1]) - (N - 2)

print(minans)
print(maxans)