import sys

sys.stdin = open('lifeguards.in','r')
sys.stdout = open('lifeguards.out','w')

N = int(input())

data = []

data.append([0,0])

for _ in range(N):
    start, stop = map(int, input().split())
    data.append([start, stop])

data.append([10e9, 10e9])
data.sort()
total = 0
sub = 10e9
left = -1
right = -1
temp = -1

for i in range(1, N + 1):
    temp = max(data[i][0], data[i - 1][1])
    left = max(left, temp)
    right = min(data[i][1], data[i + 1][0])
    sub = min(sub, max(0, right - left))
    total += max(0, data[i][1] - left)

print(total - sub)

# 0 0 | 1 4 | 3 7 | 5 9 | 10e9 10e9