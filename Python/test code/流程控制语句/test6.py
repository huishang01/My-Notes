age = int(input("请输入你的年龄："))
year = int(input("请输入入职时长（年）："))
level = int(input("请输入你的级别："))

if age >= 18:
    print("你是成年了")
    if age <= 30:
        print("你的年龄达标了")
        if year > 2:
            print("恭喜你，年龄和入职时长都达标了")
        elif level > 3:
            print("恭喜你，年龄和级别都达标了")
        else:
            print("不好意思，你的级别未达标")
    else:
        print("你太老了")
else:
    print("未成年禁止")