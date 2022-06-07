import sys

sys.stdin = open('paintbarn.in','r')
sys.stdout = open('paintbarn.out','w')

N, K = map(int, input().split())

prefix = [[0 for _ in range(1001)] for _ in range(1001)]

for _ in range(N):
    x1, y1, x2, y2 = map(int, input().split())
    prefix[x1][y1] += 1
    prefix[x2][y2] += 1
    prefix[x1][y2] -= 1
    prefix[x2][y1] -= 1

ans = 0

for i in range(1001):
    for x in range(1001):
        if i > 0:
            prefix[i][x] += prefix[i - 1][x]
        if x > 0:
            prefix[i][x] += prefix[i][x - 1]
        if i > 0 and x > 0:
            prefix[i][x] -= prefix[i - 1][x - 1]
        if prefix[i][x] == K:
            ans += 1

print(ans)