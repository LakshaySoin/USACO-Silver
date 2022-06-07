import sys

sys.stdin = open('factory.in','r')
sys.stdout = open('factory.out','w')

N = int(input())

incoming = [0 for _ in range(N)]
outgoing = [0 for _ in range(N)]

for _ in range(N - 1):
    x, y = map(int, input().split())
    incoming[x - 1] += 1
    outgoing[y - 1] += 1

if incoming.count(0) > 1:
    print(-1)
else:
    print(incoming.index(0) + 1)
    



