import sys

sys.stdin = open('lifeguards.in','r')
sys.stdout = open('lifeguards.out','w')

N = int(input())

data = []

for _ in range(N):
    data.append(list(map(int, input().split())))

ans = 0

for x in range(N):
    curr = 0
    for i in range(1, 10001):
        for y in range(N):
            if y != x:
                if i >= data[y][0] and i < data[y][1]:
                    curr += 1
                    break
    ans = max(curr, ans)

print(ans)