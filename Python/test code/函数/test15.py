# 定义两个全局变量
monny = 5000000 # 存储余额
name = None # 存储客户名

# 定义开始菜单
def start_menu():
    print(f"{name}，欢迎来到ATM，请选择操作：")
    print("查询余额\t[输入1]")
    print("存款\t\t[输入2]")
    print("取款\t\t[输入3]")
    print("退出\t\t[输入4]")
    select = int(input("请输入你的选择："))
    return select
    
# 查询余额
def inquire(header):
    if header == True:
        print("---------查询余额---------")
    print("您的余额为：", monny, "元")
    
# 存款
def deposit():
    cun = int(input("请输入要存储的金额："))
    global monny
    monny += cun
    print("存款成功！")
    inquire(False)

# 取款
def withdrawal():
    qu = int(input("请输入要取走的金额："))
    global monny
    monny -= qu
    print("取款成功！")
    inquire(False)

# 主程序
name = input("请输入你的姓名：")
while(True):
    select = start_menu()
    if select == 1:
        inquire(True)
    elif select == 2:
        deposit()
    elif select == 3:
        withdrawal()
    elif select == 4:
        print("程序已退出！")
        break
    else:
        print("输入无效！")