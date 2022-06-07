import sys

sys.stdin = open('maxcross.in','r')
sys.stdout = open('maxcross.out','w')

N, K, B = map(int, input().split())

broken = [0 for _ in range(N)]

for i in range(B):
    id = int(input())
    broken[id - 1] += 1

psum = [0]

for i in range(N):
    psum.append(psum[-1] + broken[i])

ans = N

for i in range(N - K + 1):
    ans = min(ans, psum[i + K] - psum[i])

print(ans)

# broken - 1 2 5 9 10
# psum - 0 1 3 8 17 27