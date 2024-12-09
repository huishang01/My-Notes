# 导包
import urllib.request

# 定义一个 URL
url = "https://www.baidu.com/"

# 模拟浏览器向用户发送请求
res = urllib.request.urlopen(url)

# res 是 HTTPResponse 类型
print(type(res))

# 获取页面源码
# 读取全部内容
content1 = res.read().decode("UTF-8")
print(content1)

# 读取一行
content2 = res.readline().decode("UTF-8")
print(content2)

# 读取全部行
content3 = res.readlines()
print(content3)

# 获取 HTTP 状态码
code = res.getcode()
print(code)

# 获取 HTTP 响应头
header = res.info()
print(header)

# 获取网页的 URL
print(res.geturl())