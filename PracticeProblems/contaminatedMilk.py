import sys

sys.stdin = open('badmilk.in','r')
sys.stdout = open('badmilk.out','w')

N, M, D, S = map(int, input().split())

log = []

for _ in range(D):
    p, m, t = map(int, input().split())
    log.append([p, m, t])

sick = []

for _ in range(S):
    p, t = map(int, input().split())
    sick.append([p, t])

ans = 0

for i in range(1, M + 1):
    temp = 0
    vals = []
    for x in range(D):
        if log[x][1] == i:
            for y in range(S):
                if log[x][0] == sick[y][0]:
                    if log[x][2] < sick[y][1] and log[x][0] not in vals:
                        temp += 1
                        vals.append(log[x][0])
                elif log[x][0] not in vals:
                    temp += 1
                    vals.append(log[x][0])
    for n in sick:
        if n[0] not in vals:
            temp = 0
    ans = max(ans, temp)

print(ans)