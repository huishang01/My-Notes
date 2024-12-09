from bs4 import BeautifulSoup
import urllib.request

url = 'https://yuc.wiki/202410/'

headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Safari/537.36'
}

req = urllib.request.Request(url, headers=headers)

res = urllib.request.urlopen(req)

content = res.read().decode('utf-8')

soup = BeautifulSoup(content, 'lxml')

names = soup.select('.title_cn_r')

images = soup.select('div img')[:-2]


def clean_filename(filename):
    # 替换掉不允许出现在文件名中的字符
    forbidden_chars = '<>:"/\\|?*'
    for char in forbidden_chars:
        filename = filename.replace(char, "_")
    return filename


for i in range(len(names)):
    name = names[i].string
    src = images[i]['src']
    # print(name + ':' + img)
    urllib.request.urlretrieve(url=src, filename=f'images/{clean_filename(name)}.jpg')
