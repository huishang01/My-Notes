list = [1,2, 3, 4, 5, 6, 7 ,8 ,9, 10]
list2 = []
list3 = []

i = 0
while i < len(list):
    if list[i] % 2 == 0:
        print(list[i])
        list2.append(list[i])
    i += 1
    
print(list2)

for j in list:
    if j % 2 == 0:
        print(j)
        list3.append(j)

print(list3)