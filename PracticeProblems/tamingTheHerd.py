import sys

sys.stdin = open('taming.in','r')
sys.stdout = open('taming.out','w')

N = int(input())

logs = list(map(int, input().split()))

ans = [-1 for _ in range(N)]

case = False

for i in range(N):
    if logs[i] != ans[i]:
        cnt = 0
        for x in range(i - logs[i], i + 1):
            if logs[x] != cnt and logs[x] != -1:
                case = True
            ans[x] = cnt
            cnt += 1

ans[0] = 0

mi = 0
ma = 0

for i in range(N):
    if ans[i] == 0:
        mi += 1
        ma += 1
    if ans[i] == -1:
        ma += 1
    
if case:
    print(-1)
else:
    print(mi, end =" ")
    print(ma)