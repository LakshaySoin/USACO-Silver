import sys

sys.stdin = open('blist.in','r')
sys.stdout = open('blist.out','w')

N = int(input())

data = []

for _ in range(N):
    data.append(list(map(int, input().split())))

data.sort()

ans = 0
curr = 0

for i in range(1000):
    for x in range(N):
        if i == data[x][0]:
            curr += data[x][2]
        elif i == data[x][1]:
            curr -= data[x][2]
    ans = max(ans, curr)

print(ans)