import urllib.request
from lxml import etree

start_page = 1
end_page = 2


def creat_request(page):
    # 定义 URL
    if page == 1:
        url = 'https://sc.chinaz.com/tupian/dangaotupian.html'
    else:
        url = f'https://sc.chinaz.com/tupian/dangaotupian_{page}.html'

    # 定制请求头
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36',
    }

    # 创建请求对象
    req = urllib.request.Request(url, headers=headers)
    return req


def get_context(req):
    res = urllib.request.urlopen(req)  # 访问网页
    cont = res.read().decode('utf-8')  # 获取源代码
    return cont
    # print(cont)


def download_img(context):
    # 解析源码
    tree = etree.HTML(context)
    # 获取图片链接
    images = tree.xpath('//img[@class="lazy"]/@data-original')
    titles = tree.xpath('//img[@class="lazy"]/@alt')
    for i in range(len(images)):
        title = titles[i]+ '.jpg'
        url = "https:" + images[i]
        urllib.request.urlretrieve(url=url, filename=f'./images/{title}')
        # print(title + url)


for page in range(start_page, end_page + 1):
    req = creat_request(page)  # 定制请求对象
    context = get_context(req)  # 获取网页源码
    download_img(context)  # 下载图片
