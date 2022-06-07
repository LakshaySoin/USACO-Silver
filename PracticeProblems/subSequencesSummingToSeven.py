import sys

sys.stdin = open('div7.in','r')
sys.stdout = open('div7.out','w')

N = int(input())

cows = []

for _ in range(N):
    cows.append(int(input()))

prefix = [0]
for i in cows:
    prefix.append((prefix[-1] + i) % 7)

temp = prefix.copy()
temp.reverse()

ans = 0

for i in range(7):
    try:
        ans = max(ans, (len(prefix) - temp.index(i)) - prefix.index(i) - 1)
    except ValueError:
        pass

print(ans)