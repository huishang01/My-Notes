print("欢迎来到黑马游乐场，儿童免费，成人收费")

age = int(input("请输入你的年龄年龄："))

if age >= 18:
    print("你已成年，游玩需补票10元")
else:
    print("你未成年，可以免费游玩")

print("祝您游玩愉快!")