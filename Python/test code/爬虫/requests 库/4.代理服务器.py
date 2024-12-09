import requests


url = 'https://www.baidu.com/s'

params = {
    'wd': '北京'
}

headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36'
}

proxies = {
    'https': '218.87.205.37:20970',
    'https': '202.101.213.82:19456',
}

res = requests.get(url=url, params=params, headers=headers, proxies=proxies)

content = res.text

# 保存文件
with open('daili.html', 'w', encoding='utf-8') as f:
    f.write(content)

