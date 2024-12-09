import urllib.request
from lxml import etree

# 1. 获取网页源码
url = 'http://www.baidu.com'  # 定义 URL

headers = {  # 定制请求头
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36',
}

req = urllib.request.Request(url, headers=headers)  # 定制请求对象

res = urllib.request.urlopen(req)  # 访问网站获取响应数据

content = res.read().decode('utf-8')  # 读取响应数据

# 2. 解析网页源码
html_tree = etree.HTML(content)

result = html_tree.xpath('//input[@id="su"]/text()')

print(html_tree)
