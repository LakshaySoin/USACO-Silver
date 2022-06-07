import sys

sys.stdin = open('helpcross.in','r')
sys.stdout = open('helpcross.out','w')

C, N = map(int, input().split())

chickens = []

for _ in range(C):
    chickens.append(int(input()))

cows = []

for _ in range(N):
    cows.append(list(map(int, input().split())))

chickens.sort()
cows.sort()

ans = 0

start = 0

taken = [False for _ in range(C)]

for x in range(N):
    for i in range(C):
        if taken[i]:
            continue
        elif chickens[i] < cows[x][0]:
            continue
        elif chickens[i] > cows[x][1]:
            break
        elif chickens[i] >= cows[x][0] and chickens[i] <= cows[x][1]:
            ans += 1
            taken[i] = True
            break

print(ans)