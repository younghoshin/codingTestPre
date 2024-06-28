# 스택 수열 자료구조(스택)
# 실버 2
N = int(input())
list = []
stack = []
output=[]
count = 1
for i in range(N):
    list.append(int(input()))

while list:    
    if stack :
        if stack[-1] == list[0]:
            list.pop(0)
            stack.pop()
            output.append('-')
        else :
            stack.append(count)
            count+=1
            output.append('+')
    else :
        stack.append(count)
        count+=1
        output.append('+')
    if count == N+2:
        print('NO')
        exit()

for i in output:
    print(i)