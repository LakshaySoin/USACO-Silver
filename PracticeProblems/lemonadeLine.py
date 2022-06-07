import sys

sys.stdin = open('lemonade.in','r')
sys.stdout = open('lemonade.out','w')

N = int(input())

cows = list(map(int, input().split()))

cows.sort(reverse=True)

ans = 1

for i in range(N - 1):
    if cows[i + 1] >= ans:
        ans += 1
    else:
        break

print(ans)