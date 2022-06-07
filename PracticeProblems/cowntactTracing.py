import sys

sys.stdin = open('tracing.in','r')
sys.stdout = open('tracing.out','w')

N, T = map(int, input().split())

curr = input()

log = []

for _ in range(T):
    t, x, y = map(int, input().split())
    log.append([t, x, y])

log.sort()

pzero = 0
klower = float("inf")
kupper = -float("inf")
lst = []

for i in range(1, N + 1):
    temp = True
    first = True
    for x in range(T):
        if curr[i - 1] == '0':
            temp = False
        elif i == log[x][1]:
            if (curr[log[x][2] - 1] == '0' and first) or curr[log[x][1] - 1] == '0':
                temp = False
            first = False
        elif i == log[x][2]:
            if (curr[log[x][2] - 1] == '0' and first) or curr[log[x][1] - 1] == '0':
                temp = False
            first = False
    if temp:
        pzero += 1
        lst.append(i)
    
already = []

done = False

for i in lst:
    for x in range(T):
        if not done:
            if i == log[x][1]:
                if curr[log[x][2] - 1] == '1' and log[x][2] not in already:
                    klower += 1
                    kupper += 1
                    already.append(log[x][2])
                elif curr[log[x][2]] and log[x][2] in already:
                    kupper += 1
                else:
                    done = True
            if i == log[x][2]:
                if curr[log[x][1] - 1] == '1' and log[x][1] not in already:
                    klower += 1
                    kupper += 1
                    already.append(log[x][1])
                elif curr[log[x][1]] and log[x][1] in already:
                    kupper += 1
                else:
                    done = True

print(pzero, end=" ")
print(klower, end=" ")
if kupper == 0 or done == False:
    print("Infinity")
else:
    print(kupper)