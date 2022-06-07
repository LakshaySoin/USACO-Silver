import sys

sys.stdin = open('bcount.in','r')
sys.stdout = open('bcount.out','w')

N, Q = map(int, input().split())

order = []

for _ in range(N):
    order.append(int(input()))

queries = []

for _ in range(Q):
    start, end = map(int, input().split())
    queries.append([start, end])

prefix = [[0, 0, 0]]

for i in order:
    temp = prefix[-1].copy()
    temp[i - 1] += 1
    prefix.append(temp)

for i in queries:
    temp = [0, 0, 0]
    index = 0
    for x in zip(prefix[i[1]], prefix[i[0] - 1]):
       temp[index] = x[0] - x[1]
       index += 1
    print(" ".join(map(str, temp)))