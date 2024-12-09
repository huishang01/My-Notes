import requests, json


# 定义 URL
url = 'https://fanyi.baidu.com/sug'

# 定义参数
data = {
    'kw': 'you',
}

# 定义请求头
headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36'
}

# 发送请求获取响应
response = requests.post(url=url, data=data, headers=headers)

# 获取响应数据文本
content = response.text

obj = json.loads(content)

print(obj['data'][0]['v'])

# 总结
# 1. POST 请求不需要编解码
# 2. POST 请求的参数是 data
# 3. 不需要定制请求对象

