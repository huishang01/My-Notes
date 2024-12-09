import random

monny = 10000

for i in range(1, 20):
    if monny == 0:
        print("工资发完了，下个月再领取吧")
        break
    
    ji_xiao = random.randint(1,10)
    if ji_xiao < 5:
        print(f"员工{i}，绩效分{ji_xiao}，低于5，不发工资，下一位")
        continue
    else:
        print(f"向员工{i}发放工资1000元，账户余额还剩余{monny - 1000}元")
        monny -= 1000
        