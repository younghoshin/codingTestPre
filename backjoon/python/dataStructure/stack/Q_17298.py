# 백준 오큰수 자료구조(스택)
# 골드 4
N = int(input())
checkStack = []
printArr = [0 for i in range(N)]
numList = list(map(int, input().split()))

for i in range(N):
    while len(checkStack) > 0 and numList[checkStack[-1]]<numList[i]:
        printArr[checkStack.pop()] = numList[i]
    checkStack.append(i)

for i in checkStack:
    printArr[i] = -1
print(*printArr)
