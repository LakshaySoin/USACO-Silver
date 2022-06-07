import sys

sys.stdin = open('traffic.in','r')
sys.stdout = open('traffic.out','w')

N = int(input())

data = []

for _ in range(N):
    ramp, lower, upper = input().split()
    data.append([ramp, int(lower), int(upper)])

ans2 = [-float("inf"), float("inf")]

for i in range(N - 1, -1, -1):
    if data[i][0] == "on":
        ans2[0] -= data[i][2]
        ans2[1] -= data[i][1]
    elif data[i][0] == "none":
        ans2[0] = max(ans2[0], data[i][1])
        ans2[1] = min(ans2[1], data[i][2])
    elif data[i][0] == "off":
        ans2[0] += data[i][1]
        ans2[1] += data[i][2]

ans2[0] = max(0, ans2[0])
ans2[1] = max(0, ans2[1])

ans1 = [-float("inf"), float("inf")]

for i in range(N):
    if data[i][0] == "on":
        ans1[0] += data[i][1]
        ans1[1] += data[i][2]
    elif data[i][0] == "none":
        ans1[0] = max(ans1[0], data[i][1])
        ans1[1] = min(ans1[1], data[i][2])
    elif data[i][0] == "off":
        ans1[0] -= data[i][2]
        ans1[1] -= data[i][1]

ans1[0] = max(0, ans1[0])
ans1[1] = max(0, ans1[1])

print(" ".join(map(str, ans2)))
print(" ".join(map(str, ans1)))
