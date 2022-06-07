import sys

sys.stdin = open('blocks.in','r')
sys.stdout = open('blocks.out','w')

N = int(input())

blocks = []

for _ in range(N):
    blocks.append(input().split())

ans = [0 for _ in range(26)]

for i in blocks:
    temp1 = [0 for _ in range(26)]
    temp2 = [0 for _ in range(26)]
    for n in i:
        for m in n:
            if n == i[0]:
                temp1[ord(m) - 97] += 1
            elif n == i[1]:
                temp2[ord(m) - 97] += 1
    for l in range(26):
        ans[l] += max(temp1[l], temp2[l])
        
for i in ans:
    print(i)