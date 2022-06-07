import sys

sys.stdin = open('photo.in','r')
sys.stdout = open('photo.out','w')

N = int(input())

integers = list(map(int, input().split()))

for i in range(1, integers[0] + 1):
    arr = [i]
    for x in integers:
        if x - arr[-1] > 0:
            arr.append(x - arr[-1])
    if len(set(arr)) == N:
        for i in range(len(arr)):
            arr[i] = str(arr[i])
        print(" ".join(arr))
        break