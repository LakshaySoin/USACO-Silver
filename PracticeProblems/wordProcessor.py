import sys

sys.stdin = open('word.in','r')
sys.stdout = open('word.out','w')

N, K = map(int, input().split())

words = input().split()

curr = 0
temp = []

for i in range(N):
    if len(words[i]) + curr <= K:
        temp.append(words[i])
        curr += len(words[i])
    else:
        print(" ".join(temp))
        curr = len(words[i])
        temp = [words[i]]

if len(temp) != 0:
    print(" ".join(temp))