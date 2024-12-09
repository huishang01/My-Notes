# 导包
import urllib.request

# 定义 URL
url = "https://www.baidu.com/"

# 定制请求头
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36'
}

# 定制 HTTP 请求对象
req = urllib.request.Request(url=url, headers=headers)

# 发送请求获取网页源码
res = urllib.request.urlopen(req)

# 读取全部内容
content = res.read().decode("UTF-8")
print(content)