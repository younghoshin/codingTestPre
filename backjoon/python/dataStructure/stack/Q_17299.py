# 백준 오등큰수 자료구조(스택)
# 골드 3

N = int(input())
numbers  = list(map(int, input().split(' ')))
anw = [-1] * N
# 원소의 값이 최대 백만까지 이기 때문에 1,000,001개의 공간을 선언하여 사용
index = [0] * 1000001
stack = []

for i in numbers:
    index[i] += 1

for i in range(N):
    M = numbers[i]
    while stack and index[numbers[stack[-1]]]<index[M]:
        anw[stack.pop()] = M
    stack.append(i)
print(*anw)
