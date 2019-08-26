l=[[ 'Acme', 'Italian', 2, 4, 3, 5],[ 'Flintstone', 'Steak', 5, 2, 4, 3, 3, 4],[ 'Bella Troy', 'Italian', 1, 4, 5]]
for ele in l:
        if(ele[1]=='Italian' and ele.count(5)>0 and 1 not in ele):
            print(ele[0])
