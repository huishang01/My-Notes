f = open("bill.txt", "r", encoding="UTF-8")

f2 = open("bill.txt.bak", "w", encoding="UTF-8")

for line in f:
    if line.count("正式"):
        f2.write(line)

f.close()
f2.close()