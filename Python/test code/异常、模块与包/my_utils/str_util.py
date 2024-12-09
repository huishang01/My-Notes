"""
字符串相关工具，内含：
函数：str_reverse(s)，接受传入字符串，将字符串反转返回
函数：substr(s, x, y)，按照下标x和y，对字符串进行切片
"""

def str_reverse(s):
    """
    接受传入字符串，将字符串反转返回
    :param s: 接收字符串
    :return: 返回字符串
    """
    return s

def substr(s, x, y):
    """
    按照下标x和y，对字符串进行切片
    :param s: 接收字符串
    :param x: 切片的开始索引
    :param y: 切片的结束索引
    :return: 返回切片后的字符串
    """
    return s[x:y:1]

if __name__ == "__main__":
    print(substr("12345678", 3, 7))