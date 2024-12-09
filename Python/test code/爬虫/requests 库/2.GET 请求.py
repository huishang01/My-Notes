import requests


# 定义 URL
url = 'https://www.baidu.com/s'

# 定义参数
params = {
    'wd': '北京'
}

# 定义请求头
headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36'
}

# 发送请求获取响应
response = requests.get(url=url, params=params, headers=headers)

# 获取响应数据文本
content = response.text

print(content)

# 总结
# 1. 参数用 params 传递
# 2. 参数无需 urlencoding 编码
# 3. 不需要定制请求对象
# 4. URL 中的 ? 可以不加

