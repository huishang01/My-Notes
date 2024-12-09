print("猜字谜小游戏")

if int(input("请输入想菜的数字：")) == 10:
    print("恭喜你，第一次就猜对了")
elif int(input("猜错了，再猜一次：")) == 10:
    print("这次猜对了呢")
elif int(input("又猜错了，再猜一次：")) == 10:
    print("最后一次终于猜对了呢")
else:
    print("机会用完，答案是10")    