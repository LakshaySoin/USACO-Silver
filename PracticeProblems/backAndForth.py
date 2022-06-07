import sys

sys.stdin = open('backforth.in','r')
sys.stdout = open('backforth.out','w')

temp1 = list(map(int, input().split()))
temp2 = list(map(int, input().split()))

ans = []

cnt = 1000

for i in range(len(temp1)): # tuesday
    first = temp1.copy()
    second = temp2.copy()
    cnt -= first[i]
    reset3 = first[i]
    second.append(first[i])
    first.pop(i)
    for x in range(len(second)): # wednesday
        temp3 = first.copy()
        temp4 = second.copy()
        cnt += temp4[x]
        reset1 = temp4[x]
        temp3.append(temp4[x])
        temp4.pop(x)
        for y in range(len(temp3)): # thursday
            temp5 = temp3.copy()
            temp6 = temp4.copy()
            cnt -= temp5[y]
            reset2 = temp5[y]
            temp6.append(temp5[y])
            temp5.pop(y)
            for n in range(len(temp6)): # friday
                cnt += temp6[n]
                if cnt not in ans:
                    ans.append(cnt)
                cnt -= temp6[n]
            cnt += reset2
            temp5.append(reset2)
            temp6.pop(-1)
        cnt -= reset1
        temp4.append(reset1)
        temp3.pop(-1)
    cnt += reset3
    first.append(reset3)
    second.pop(-1)
            
print(len(ans))