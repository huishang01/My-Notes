import urllib.request

url = 'https://www.baidu.com/s?&wd=%E5%B0%91%E5%A5%B3%E4%B9%90%E5%9B%A2%E6%B4%BE%E5%AF%B9'

headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
}

req = urllib.request.Request(url, headers=headers)

# 定制代理池
proxies_pool = {
    'http': '218.87.205.76:17465',
    'http': '218.87.205.76:17465',
    'http': '218.87.205.76:17465',
}
proxies = proxies_pool

# 获取 handler 对象
handler = urllib.request.ProxyHandler(proxies=proxies)

# 获取 opener 对象
opener = urllib.request.build_opener(handler)

# 调用 opener 对象
res = opener.open(req)

content = res.read().decode('utf-8')

with open("daili.html", 'w', encoding='utf-8') as f:
    f.write(content)
