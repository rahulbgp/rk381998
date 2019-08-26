a=int(input("enter amount"))
valid_notes=[2000,500,200,100,50,20,10,5,1]
count=[0,0,0,0,0,0,0,0,0]
for x,y in zip(valid_notes,count):
    if a>=x:
        y=a//x
        a=a-y*x
        print(x,'=',y)
