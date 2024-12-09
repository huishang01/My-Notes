import random
num = random.randint(1, 10)
print("答案", num)
guess = int(input("请输入你猜的数字："))

if guess == num:
    print("恭喜你，猜对了！")
else:
    if guess > num:
        print("大了")
    else:
        print("小了")
        
    guess = int(input("再猜一次："))
    if guess == num:
        print("恭喜您猜对了")
    else:
        if guess > num:
            print("大了")
        else:
            print("小了")
        
        guess = int(input("再猜一次："))
        if guess == num:
            print("恭喜您猜对了")
        else:
            if guess > num:
                print("大了，答案是", num)
            else:
                print("小了答案是", num)