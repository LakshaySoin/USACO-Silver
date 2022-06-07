import sys

# sys.stdin = open('haybales.in','r')
# sys.stdout = open('haybales.out','w')

N, Q = map(int, input().split())

nums = list(map(int, input().split()))

nums.sort()

queries = []

for _ in range(Q):
    queries.append(list(map(int, input().split())))

for i in range(Q):
    lower = N
    upper = 0

    L, R = 0, N - 1
    while L < R:
        mid = L + (R - L) // 2
        if nums[mid] == queries[i][0]:
            lower = mid
            break
        if nums[mid] > queries[i][0]:
            lower = min(lower, mid)
            R = mid - 1
        if nums[mid] < queries[i][0]:
            L = queries[i][0] + 1

    L, R = 0, N - 1
    while L < R:
        if nums[mid] == queries[i][1]:
            upper = mid
            break
        if nums[mid] > queries[i][1]:
            R = queries[i][1] - 1
        if nums[mid] < queries[i][1]:
            upper = max(upper, mid)
            L = mid + 1

    print(upper - lower)