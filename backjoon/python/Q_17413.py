inputs = input()
output = ''
outList = ''
for i in inputs:
    if i == '<' and len(outList)>0:
        output += outList[::-1]
        outList = i
    elif i =='>':
        output += outList+i
        outList =''
    elif i ==' ':
        if '<' not in outList:
            output += outList[::-1]+i
            outList =''
        else:
            outList += i
    else:
        outList = outList+i
if outList:
    output += outList[::-1]       
print(output)