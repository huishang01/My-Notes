import urllib.request

url = 'https://www.baidu.com/'

headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
}

req = urllib.request.Request(url, headers=headers)

# 获取 handler 对象
handler = urllib.request.HTTPHandler()

# 获取 opener 对象
opener = urllib.request.build_opener(handler)

# 调用 opener 对象
res = opener.open(req)

content = res.read().decode('utf-8')

print(content)
