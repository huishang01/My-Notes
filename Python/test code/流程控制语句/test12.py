import random
num = random.randint(1,100)

count = 0

flag = True

while flag:
    
    guess = int(input("请输入你要猜的数字："))
    
    count += 1
    
    if guess == num:
        print("恭喜你猜中了")
        flag = False
    elif guess > num:
        print("大了")
    else:
        print("小了")
    
print("你总共猜了",count,"次")