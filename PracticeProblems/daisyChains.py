N = int(input())

flowers = list(map(int, input().split()))

ans = N

for i in range(N):
    for x in range(N):
        if i != x and x > i:
            temp = 0
            cnt = 0
            for y in range(i, x + 1):
                cnt += 1
                temp += flowers[y]
            ave = temp / cnt
            temp_ans = 0
            for z in range(i, x + 1):
                if flowers[z] == ave:
                    temp_ans += 1
            if temp_ans > 0:
                ans += 1
print(ans)