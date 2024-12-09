import requests
from bs4 import BeautifulSoup

# 定义 URL
url = 'https://www.gushiwen.cn/user/login.aspx?from=http://www.gushiwen.cn/user/collect.aspx'

# 定义请求头
headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36'
}

# 获取源码
response = requests.get(url=url, headers=headers)
content = response.text

# 解析源代码
soup = BeautifulSoup(content, 'lxml')

# 获取隐藏域
viewstate = soup.select('#__VIEWSTATE')[0].attrs.get('value')
viewstategenerator = soup.select('#__VIEWSTATEGENERATOR')[0].attrs.get('value')

# 获取验证码
# session()：将请求变成一个对象
session = requests.session()

# 通过 session 对象发送请求
res_code = session.get('https://www.gushiwen.cn/RandCode.ashx')

# 将验证码使用二进制重新保存
cont_code = res_code.content
with open('code.jpg', 'wb') as f:
    f.write(cont_code)

# 看图识码
code = input('请输入验证码：')

# 登录的 URL
url_post = 'https://www.gushiwen.cn/user/login.aspx?from=http%3a%2f%2fwww.gushiwen.cn%2fuser%2fcollect.aspx'

# 定义参数
data = {
    '__VIEWSTATE': viewstate,
    '__VIEWSTATEGENERATOR': viewstategenerator,
    'from': 'http://www.gushiwen.cn/user/collect.aspx',
    'email': 'huishang20050822@outlook.com',
    'pwd': 'huishang5201314',
    'code': code,
    'denglu': '登录',
}

# 通过 session 对象发送请求
res_post = session.post(url=url_post, data=data, headers=headers)

cont_post = res_post.text

with open('gushiwen.html', 'w', encoding='utf-8') as f:
    f.write(cont_post)
