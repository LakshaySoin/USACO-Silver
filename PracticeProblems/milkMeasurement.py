import sys

sys.stdin = open('measurement.in','r')
sys.stdout = open('measurement.out','w')

N, G = map(int, input().split())

log = []
names = []
display = []

for _ in range(N):
    day, name, cnt = input().split()
    if name not in names:
        names.append(int(name))
    if name not in display:
        display.append(int(name))
    log.append([int(day), int(name), int(cnt)])

log.sort()

initial = [G for _ in range(len(names))]

ans = 0

for i in range(N):
    curr = []
    initial[names.index(log[i][1])] += log[i][2]
    maxnum = max(initial)
    for x in range(len(initial)):
        if initial[x] == maxnum:
            curr.append(names[x])
    if sorted(curr) != sorted(display):
        ans += 1
    display = curr.copy()

print(ans)
