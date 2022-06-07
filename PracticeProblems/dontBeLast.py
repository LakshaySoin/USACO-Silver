import sys
from operator import itemgetter

sys.stdin = open('notlast.in','r')
sys.stdout = open('notlast.out','w')

N = int(input())

names = []
nums = []

for i in range(N):
    name, cnt = input().split()
    if name in names:
        nums[names.index(name)] += int(cnt)
    if name not in names:
        names.append(name)
        nums.append(int(cnt))

ans = ""
alt = ""
temp = float("inf")
cnt1 = 0
cnt2 = 0
mi = min(nums)

for i in range(len(names)):
    if nums[i] == mi:
        alt = names[i]
        cnt1 += 1
    else:
        temp = min(nums[i], temp)
        ans = names[nums.index(temp)]

for x in range(len(names)):
    if nums[x] == temp:
        cnt2 += 1

if len(names) != 7:
    if cnt1 > 1:
        print("Tie")
    else:
        print(alt)
elif cnt1 == 7:
    print("Tie")
else:
    if cnt2 > 1:
        print("Tie")
    else:
        print(ans)