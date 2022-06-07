import sys
from operator import itemgetter

sys.stdin = open('convention2.in','r')
sys.stdout = open('convention2.out','w')

N = int(input())

cows = []

for i in range(N):
    arrival, time = map(int, input().split())
    cows.append([i, [arrival, time]])

cows.append([0, [float("inf"), 0]])

cows.sort(key=itemgetter(1))

ans = 0

time = 0

waiting = []

i = 0

while i < N:
    if cows[i][1][0] > time and len(waiting) == 0:
        time = cows[i][1][0] + cows[i][1][1]
        i += 1
    elif cows[i][1][0] > time:
        waiting.sort()
        ans = max(ans, time - cows[waiting[0][1]][1][0])
        time += cows[waiting[0][1]][1][1]
        waiting.pop(0)
    else:
        waiting.append([cows[i][0], i])
        i += 1

print(ans)