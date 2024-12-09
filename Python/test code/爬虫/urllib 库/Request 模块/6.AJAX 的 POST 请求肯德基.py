# 导包
import urllib.request
import urllib.parse


def create_req(page):
    """
    构建请求对象
    :param page: 页码
    :return: 返回请求对象
    """
    # 定义 URL
    url = "https://www.kfc.com.cn/kfccda/ashx/GetStoreList.ashx?op=cname"

    # 定制参数
    data = {
        "cname": "北京",
        "pid": "",
        "pageIndex": f"{page}",
        "pageSize": "10"
    }

    # 转码
    data = urllib.parse.urlencode(data).encode("UTF-8")

    # 定制请求头
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
    }

    # 构建请求对象
    req = urllib.request.Request(url, data, headers)

    # 返回请求对象
    return req


def get_content(req):
    """
    发送请求，获取相应内容
    :param req: 请求
    :return: 相应内容
    """
    # 发送请求获取响应
    res = urllib.request.urlopen(req)

    # 读取响应内容
    content = res.read().decode("UTF-8")

    return content


def save(content, page):
    """
    保存响应的内容到本地JSON
    :param content: 相应内容
    :param page: 页码
    :return:
    """
    with open(f"kfc_adr//kfc_adr_{page}.json", "w", encoding="UTF-8") as f:
        f.write(content)


# 主程序
if __name__ == "__main__":
    start = int(input("起始页码："))
    end = int(input("结束页码："))

    for page in range(start, end + 1):
        req = create_req(page)
        content = get_content(req)
        save(content, page)
