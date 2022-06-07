import sys

sys.stdin = open('stacking.in','r')
sys.stdout = open('stacking.out','w')

N, K = map(int, input().split())

instructions = []

for i in range(K):
    a, b = map(int, input().split())
    instructions.append([a, b])

prefix = [0 for _ in range(N)]

for i in range(K):
    for x in range(instructions[i][0], instructions[i][1] + 1):
        prefix[x - 1] += 1

prefix.sort()

print(prefix[int(len(prefix)/2)])