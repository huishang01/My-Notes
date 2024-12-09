import urllib.request

url = "https://weibo.cn/6664219641/info"

headers = {
    # Cookie: 用户登录信息
    "Cookie": "_T_WM=938debadd5be889d45989b7dd4cbe7ab; SUB=_2A25LpbCPDeRhGeBI7VYT8SfKzz2IHXVo20xHrDV6PUJbktANLXD1kW1NRmjUyQ65XyFt_tls4iB3UjZz-RkjqPAT; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9W5SQq3n1zDz9ICY_cPd75r_5JpX5KzhUgL.FoqcSoBEeK.cSh22dJLoIp7LxKML1KBLBKnLxKqL1hnLBoMcSoqXeo24SoBp; SSOLoginState=1721876703; ALF=1724468703",
    # Referer: 判断此路径是否由上一个页面跳转来的
    "Referer":"https://weibo.cn/",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
}

req = urllib.request.Request(url=url, headers=headers)

res = urllib.request.urlopen(req)

content = res.read().decode("UTF-8")

print(content)
