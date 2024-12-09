temperature = float(input("请输入你的体温："))


# 定义函数
def contains(temperature):
    if temperature < 37.5:
        print(f"你的体温是{temperature}度，体温正常")
    else:
        print(f"你的体温是{temperature}度，你已发烧")

contains(temperature)