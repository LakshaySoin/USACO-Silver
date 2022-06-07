import sys

sys.stdin = open('diamond.in','r')
sys.stdout = open('diamond.out','w')

N, K = map(int, input().split())

diamonds = []

for _ in range(N):
    diamonds.append(int(input()))

diamonds.sort()

x = 0

nums = [0 for _ in range(N + 1)]

for i in range(N):
    while x < N and diamonds[x] - diamonds[i] <= K:
        x += 1
    x -= 1
    nums[i] = x - i + 1

arr = [0 for _ in range(N + 1)]
arr[N - 1] = nums[N - 1]
for i in range(N - 2, - 1, -1):
    arr[i] = max(nums[i], arr[i + 1])

ans = 0

for i in range(N):
    ans = max(ans, nums[i] + arr[i + nums[i]])

print(ans)