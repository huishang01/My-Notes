arr = [21, 25, 21, 23, 22, 20]
print(arr)

arr.append(31)
print(arr)

new_arr = [29, 33, 30]
arr.extend(new_arr)
print(arr)

print(arr[0])

print(arr[-1])

print(arr.index(31))