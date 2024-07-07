inputs = input()
max = len(inputs)
if not 0<max<31:
    print("-1")
    exit()
for i in range(1, (len(inputs)//2)+1):
    sub = inputs[:i]
    count = 1
    totalLen = 0
    for j in range(i, len(inputs)+1, i):
        endIndex = min(i+j,len(inputs))
        sub2 = inputs[j:endIndex]
        if sub == sub2:
            count+=1
        else :
            totalLen += len(str(count))+len(sub) if count>1 else len(sub)
            sub = sub2
            count = 1
    max = min(max,totalLen+len(sub))
print(max)