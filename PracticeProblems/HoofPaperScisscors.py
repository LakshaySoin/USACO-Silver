import sys

sys.stdin = open('hps.in','r')
sys.stdout = open('hps.out','w')

N = int(input())

moves = []

for _ in range(N):
    moves.append(input())

prefix = [[0, 0, 0]]
for i in moves:
    temp = prefix[-1].copy()
    if i == "H":
        temp[0] += 1
    elif i == "P":
        temp[1] += 1
    elif i == "S":
        temp[2] += 1
    prefix.append(temp)

ans = 0

for i in range(N):
    temp1 = max(prefix[i])
    temp2 = max([prefix[-1][0] - prefix[i][0], prefix[-1][1] - prefix[i][1], prefix[-1][2] - prefix[i][2]])
    ans = max(ans, temp1 + temp2)

print(ans)