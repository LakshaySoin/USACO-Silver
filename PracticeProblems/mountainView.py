from operator import itemgetter
import sys

sys.stdin = open('mountains.in','r')
sys.stdout = open('mountains.out','w')

N = int(input())

peaks = []

for _ in range(N):
    peaks.append(list(map(int, input().split())))

peaks.sort(key=itemgetter(1))

ans = 0

for i in range(N):
    for x in range(N - 1, i, -1):
        sub = abs(peaks[x][0] - peaks[i][0])
        if peaks[x][1] - sub >= peaks[i][1]:
            ans += 1
            break

print(N - ans)
