N = int(input())

heights = list(map(int, input().split()))

heights.sort()
heights.reverse()

limits = list(map(int, input().split()))

limits.sort()
limits.reverse()

ans = [0 for _ in range(N)]

for i in range(N):
    for x in range(N):
        if heights[i] <= limits[x]:
            ans[i] += 1

final = ans[0]

for i in range(1, N):
    ans[i] -= i
    final *= ans[i]

print(final)