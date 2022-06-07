import sys

sys.stdin = open('angry.in','r')
sys.stdout = open('angry.out','w')

N = int(input())

haybales = []

for _ in range(N):
    haybales.append(int(input()))

haybales.sort()

# print(haybales)

ans = 0

for i in range(N):
    temp = 0
    temp1 = i
    radius1 = 1
    temp2 = i
    radius2 = 1
    while temp1 >= 1:
        if haybales[temp1] - haybales[temp1 - 1] > radius1:
            break
        while haybales[temp1] - haybales[temp1 - 1] <= radius1:
            temp1 -= 1
            temp += 1
            if temp1 < 1:
                break
        radius1 += 1
    while temp2 <= N - 2:
        if haybales[temp2 + 1] - haybales[temp2] > radius2:
            break
        while haybales[temp2 + 1] - haybales[temp2] <= radius2 and temp2 <= N-2:
            temp2 += 1
            temp += 1
            if temp2 > N - 2:
                break
        radius2 += 1
    ans = max(ans, temp + 1)

print(ans)