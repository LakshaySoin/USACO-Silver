import sys

sys.stdin = open('revegetate.in','r')
sys.stdout = open('revegetate.out','w')

N, M = map(int, input().split())

data = []

for _ in range(M):
    data.append(list(map(int, input().split())))

for i in data:
    i.sort()

data.sort()

ans = [1 for _ in range(N)]

for i in range(M):
    if ans[data[i][0] - 1] == ans[data[i][1] - 1]:
        ans[data[i][1] - 1] += 1 
        for x in range(i):
            if ans[data[x][0] - 1] == ans[data[x][1] - 1]:
                ans[data[i][1] - 1] += 1 

print("".join(map(str, ans)))
    
        