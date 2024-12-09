print("欢迎来到黑马动物园")

if int(input("请输入你的身高（cm）：")) < 120:
    print("你的身高未超出120cm，可以免费游玩")
elif int(input("请输入你的VIP等级（1－5）：")) > 3:
    print("你的VIP等级大于3，可以免费游玩")
elif int(input("今天几号：")) ==1:
    print("今天是1号，可以免费游玩")
else:
    print("你无法满足免费游玩的条件，游玩需要购票10元")

print("祝你游玩愉快")