class Phone:
    __is_5G_enable = None  # bool类型

    def __check_5g(self, contains):
        self.__is_5G_enable = contains
        if self.__is_5G_enable:
            print("5G开启")
        else:
            print("5G关闭，启动4G网络")

    def call_by_5g(self, contains):
        self.__check_5g(contains)
        print("正在通话中...")


contains = input("是否开启5G(Y/N)：")
if contains == "Y":
    contains = True
elif contains == "N":
    contains = False

p = Phone()
p.call_by_5g(contains)
