# 导包
import urllib.parse
import urllib.request

# 定义 URL
url = "https://www.baidu.com/s?"

# 把参数编成一个字典
data = {
    'wd': '少女乐团派对',
    'game': '音游',
    'server': '国服'
}

# 编码并拼接
new_url = url + urllib.parse.urlencode(data)

# 定制请求头
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36'
}

# 构建请求对象
req = urllib.request.Request(url=new_url, headers=headers)

# 发送请求
res = urllib.request.urlopen(req)

# 读取所有内容并打印
print(res.read().decode("UTF-8"))
