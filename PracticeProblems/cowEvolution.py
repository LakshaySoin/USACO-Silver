import sys

sys.stdin = open('evolution.in','r')
sys.stdout = open('evolution.out','w')

N = int(input())

chars = []
cnt = []

for _ in range(N):
    temp = input().split()
    cnt.append(temp[0])
    chars.append(temp[1:])

for i in chars:
    i.sort()

tree = []

ans = True

for i in range(N):
    min_chars = min(cnt)
    min_chars = int(min_chars)
    for x in range(min_chars):
        try:
            if chars[cnt.index(min_chars)[x]] not in tree:
                tree.append(chars[cnt.index(min_chars)][x])
            else:
                ans = False
        except:
            ans = False

if ans:
    print("yes")
else:
    print("no")
