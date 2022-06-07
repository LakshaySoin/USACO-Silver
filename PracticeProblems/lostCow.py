import sys

sys.stdin = open('lostcow.in','r')
sys.stdout = open('lostcow.out','w')

x, y = map(int, input().split())

dist = 0

temp = x
temp1 = x

if y > x:
    turn = 0  
    num = 1
    while (x < y):
        x = temp
        if turn % 2 == 0:
            x += num
        else:
            x -= num
        if x < y:
            dist += abs(temp1 - x)
        else:
            dist += abs(temp1 - y)
        temp1 = x
        num *= 2
        turn += 1
else:
    turn = 0
    num = 1
    while (x > y):
        x = temp
        if turn % 2 == 0:
            x += num
        else:
            x -= num
        if x > y:
            dist += abs(temp1 - x)
        else:
            dist += abs(temp1 - y)
        temp1 = x
        num *= 2
        turn += 1

print(dist)