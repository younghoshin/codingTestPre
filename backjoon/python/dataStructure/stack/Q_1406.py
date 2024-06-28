# 백준 에디터 자료구조(스택) + 빠른입출력
# 실버 2
import sys
# sys로 빠른 입출력가능함 rstirp은 뒤에 공백과 개행문자를 제거함
inputList = list(sys.stdin.readline().rstrip())
stack =[]
N = int(input())


for i in range(N):
    action = sys.stdin.readline().rstrip()
    action = action[-1]
    if action == 'L':
        if inputList:
            stack.append(inputList.pop())
    elif action == 'D':
        if stack:
            inputList.append(stack.pop())
    elif action == 'B':
        if inputList:
            inputList.pop()
    else :
        inputList.append(action)
    
while stack:
    inputList.append(stack.pop())
    
print(*inputList,sep='')    