# 导包
import urllib.parse

# 定义 URL
url = 'https://www.baidu.com/s?wd='

# 字符串编码
parse_url = urllib.parse.quote("少女乐团派对")

print(url + parse_url)
