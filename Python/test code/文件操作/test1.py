# 方法一

f = open("word.txt", "r", encoding="UTF-8")

count = 0

for line in f:
    if line.count("itheima"):
        count += 1

print("方法一：", count)

# 方法二

f2 = open("word.txt", "r", encoding="UTF-8")

count2 = 0

lines = f2.readlines()

for line in lines:
    line = line.strip()
    line = line.split(" ")
    for i in line:
        if i.count("itheima"):
            count2 += 1

print("方法二：", count2)
