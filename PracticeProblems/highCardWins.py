import sys

sys.stdin = open('highcard.in','r')
sys.stdout = open('highcard.out','w')

N = int(input())

data = []

for _ in range(N):
    data.append(int(input()))

elsie = []
bessie = []

for i in range(1, N * 2 + 1):
    if i not in data:
        bessie.append(i)
    else:
        elsie.append(i)

i = 0
x = 0

ans = 0

while i < N and x < N:
    if bessie[i] < elsie[x]:
        i += 1
    else:
        ans += 1
        x += 1
        i += 1

print(ans)