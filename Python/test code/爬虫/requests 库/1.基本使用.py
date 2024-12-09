import requests

url = 'https://www.baidu.com'  # 定义 URL

response = requests.get(url=url)  # 发送请求获取响应数据

print(type(response))  # 查看响应数据的类型

response.encoding = 'utf-8'  # 设置响应数据的编码格式

print(response.text)  # 获取响应数据文本

print(response.url)  # 获取 URL

print(response.content)  # 获取二进制的响应数据

print(response.status_code)  # 获取响应码

print(response.headers)  # 获取响应头
