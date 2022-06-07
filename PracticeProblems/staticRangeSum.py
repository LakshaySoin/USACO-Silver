def psum(a):
    psum = [0]
    for i in a:
        psum.append(psum[-1] + i)
    return psum

N, Q = map(int, input().split())

A = list(map(int, input().split()))
prefix = psum(A)

for _ in range(Q):
    l, r = map(int, input().split())
    print(prefix[r] - prefix[l])


