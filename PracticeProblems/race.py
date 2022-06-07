import sys
import math

sys.stdin = open('race.in','r')
sys.stdout = open('race.out','w')

K, N = map(int, input().split())

data = []

for _ in range(N):
    data.append(int(input()))

reached = False
p = 1

while (p * (p + 1) / 2 < K):
    p += 1
p -= 1
if 2 * K == (p - 1) * p:
    reached = True

for x in data:
    y = int(math.sqrt((2 * K + x * x - x) / 2))
    attempt = (2 * y * y - x * x + x) / 2
    if x > p:
        if reached:
            print(p)
        else:
            print(p + 1)
        continue
    if K - attempt == 0:
        print(2 * y - x )
    elif K - attempt <= y:
        print(2 * y - x + 1)
    else:
        print(2 * y - x + 2)
