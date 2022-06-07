import sys

sys.stdin = open('cardgame.in','r')
sys.stdout = open('cardgame.out','w')

N = int(input())

elsie1 = []
elsie2 = []

first = True

for i in range(N):
    if i == N / 2:
        first = False
    if first:
        elsie1.append(int(input()))
    else:
        elsie2.append(int(input()))

elsie1.sort()
elsie2.sort()

bessie = []

first = True

for i in range(1, N * 2 + 1):
    if i not in elsie1 and i not in elsie2:
        bessie.append(i)

ans = 0

x = N - 1

for i in range(int((N / 2) - 1), -1, -1):
    if elsie1[i] < bessie[x]:
        x -= 1
        ans += 1

y = 0

for i in range(int(N / 2)):
    if bessie[y] < elsie2[i]:
        y += 1
        ans += 1

print(ans)

# 1 8 3 4
# 2 5 6 7