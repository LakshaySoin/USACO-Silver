import sys

sys.stdin = open('planting.in','r')
sys.stdout = open('planting.out','w')

N = int(input())

pathways = []

for _ in range(N - 1):
    pathways.append(list(map(int, input().split())))

ans = [0 for _ in range(N)]

for x in pathways:
    for y in x:
        ans[y - 1] += 1

print(max(ans) + 1)