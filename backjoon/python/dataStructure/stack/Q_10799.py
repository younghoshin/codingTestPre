stick = input()
stack = []
count = 0

for i in range(len(stick)):
    if '(' == stick[i] :
        stack.append(i)
    else:
        del stack[len(stack)-1]
        count += 1 if stick[i-1] == ')' else len(stack)
print(count)
        
            