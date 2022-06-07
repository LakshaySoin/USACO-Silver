import sys

sys.stdin = open('pairup.in','r')
sys.stdout = open('pairup.out','w')

N = int(input())

data = []

for _ in range(N):
    x, y = map(int, input().split())
    data.append([y, x])

data.sort()

ans = 0

left = 0
right = N - 1

while left <= right:
    sub = min(data[left][1], data[right][1])
    ans = max(data[left][0] + data[right][0], ans)
    if left == right:
        sub /= 2
    data[left][1] -= sub
    data[right][1] -= sub
    if data[left][1] == 0:
        left += 1
    if data[right][1] == 0:
        right -= 1

print(ans)

# 1 1 1 2 3 3 9 9 9 9 9

