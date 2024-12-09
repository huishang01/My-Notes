"""
文件处理相关工具，内含：
函数：print_file_info(file_name)，接收传入文件的路径，打印文件的全部内容，如文件不存在则捕获异常，输出提示信息，通过finally关闭文件对象
函数：append_to_file(file_name, data)，接收文件路径以及传入数据，将数据追加写入到文件中
"""

def print_file_info(file_name):
    """
    接收传入文件的路径，打印文件的全部内容，如文件不存在则捕获异常，输出提示信息，通过finally关闭文件对象
    :param file_name: 字符串类型，接收文件的路径
    :return:
    """

    try:
        file = open(file_name, 'r')  # 打开文件
        try:
            file_contents = file.read()
            print(file_contents)
        finally:
            file.close()  # 关闭文件
    except FileNotFoundError:
        print(f"文件'{file_name}'不存在")


def append_to_file(file_name, data):
    """
    接收文件路径以及传入数据，将数据追加写入到文件中
    :param file_name: 字符串类型，接收文件的路径
    :param data: 接收要写入的数据
    :return:
    """
    try:
        file = open(file_name, "w")
        file.write(data)
    except FileNotFoundError:
        print(f"文件'{file_name}'不存在")

if __name__ == "__main__":
    print_file_info("bill.txt")
    append_to_file("bill.txt", "123456")