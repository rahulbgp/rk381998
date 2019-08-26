str=input("enter string")
l=[]
for ele in str:
    if ele not in l:
        l.append(ele)
        l.append(str.count(ele))
        l1=[int(x) for x in l[1::2]]
        temp=l.index(max(l1))
print(l[temp-1])
    
