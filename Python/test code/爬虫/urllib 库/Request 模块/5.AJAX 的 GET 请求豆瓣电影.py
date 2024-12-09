# 导包
import urllib.request
import json
import urllib.parse


def create_req(page):
    # 定义 URL
    url = f'https://movie.douban.com/j/chart/top_list?type=17&interval_id=100%3A90&action=&'

    # 定请求头
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
    }

    data = {
        'start': (page - 1) * 20,
        'limit': 20
    }

    # 参数转码
    data = urllib.parse.urlencode(data)

    # 拼接 URL
    new_url = url + data

    # 发送请求
    req = urllib.request.Request(url=url, headers=headers)

    # 返回请求
    return req


def get_content(req):
    # 接收响应
    res = urllib.request.urlopen(req)

    # 读取相应内容
    content = res.read().decode("UTF-8")

    #  返回相应内容
    return content


def save(content, page):
    # 保存到本地
    with open(f"douban//douban_{page}.json", "w", encoding="UTF-8") as f:
        f.write(content)


# 主程序入口
if __name__ == "__main__":
    start = int(input("起始页码："))
    end = int(input("结束页码："))
    for i in range(start, end + 1):
        req = create_req(i)
        content = get_content(req)
        save(content, i)
