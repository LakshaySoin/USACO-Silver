import sys

sys.stdin = open('hoofball.in','r')
sys.stdout = open('hoofball.out','w')

N = int(input())

cows = list(map(int, input().split()))
cows.sort()

passes = [0 for _ in range(N)]

def passto(i, nums):
    if i == 0:
        i += 1
    elif i == N - 1:
        i -= 1
    elif nums[i + 1] - nums[i] < nums[i] - nums[i - 1]:
        i += 1
    else:
        i -= 1
    return i

if N == 1:
    print(1)
else:
    for i in range(N):
      passes[passto(i, cows)] += 1
    ans = 0
    for i in range(N - 1):
        if passes[i] == 1 and passes[i + 1] == 1 and passto(i, cows) == i + 1 and passto(i + 1, cows) == i:
            ans += 1

print(ans + passes.count(0))
    
