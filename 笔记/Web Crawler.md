# 爬虫

## 什么是爬虫

------

### 爬虫

爬虫（Web Crawler），也称为网络蜘蛛（Spider）或网络机器人，是一种自动化程序或脚本，用于系统地浏览和抓取互联网上的内容。爬虫的主要功能是从网页中提取数据，这些数据可以是文本、图片、视频、链接等。爬虫在搜索引擎、数据分析、信息聚合等领域广泛应用

#### 爬虫的工作原理

1.  起始点（种子 URL）： 爬虫从一个或多个预先设定的 URL 开始访问网页
2.  抓取网页内容： 爬虫下载网页的 HTML 内容，并解析其中的信息，比如标题、正文、链接等
3.  提取链接： 从网页中提取新的链接，并将其加入待爬取队列
4.  递归爬取： 根据设定的规则和深度限制，重复上述步骤，直到达到目标或满足停止条件
5.  存储和处理数据： 将抓取到的数据存储在数据库或文件中，供后续分析和处理

#### 常见爬虫应用

-   搜索引擎：Google、Bing 等通过爬虫收集网页内容，并建立索引以实现高效的搜索
-   数据收集：用于市场调研、舆情监控等，例如抓取社交媒体、商品信息等
-   信息聚合：新闻、天气、航班信息等平台通过爬虫抓取多来源数据进行整合

#### 爬虫的分类

1.  通用爬虫：抓取整个互联网，建立大规模数据索引。例如：Googlebot
2.  聚焦爬虫：针对特定领域的数据进行抓取，例如电商价格爬虫
3.  增量爬虫：只抓取网页中新增或更新的内容
4.  深度爬虫：重点抓取指定网站的深层页面

#### 爬虫的限制和法律问题

1.  技术限制：
    -   robots.txt：网站通过 `robots.txt` 文件告诉爬虫哪些页面可以访问，哪些不可以
    -   反爬措施：如 IP 封禁、验证码、速率限制等
2.  法律和道德约束：
    -   数据抓取可能侵犯隐私或版权
    -   在未授权的情况下爬取数据可能违反《计算机犯罪法》或其他相关法规

### 爬虫中的网络请求与响应

#### 爬虫中的请求

爬虫通过程序代码向目标服务器发起请求，以获取网页内容或其他资源

**请求的具体步骤：**

1.  构造请求： 爬虫根据目标网站的 URL，生成一个 HTTP 请求。请求的类型通常为 `GET` ，也可能是 `POST` （用于提交表单或获取动态数据）
2.  设置请求头： 为了模拟真实用户访问，爬虫通常会在请求中添加一些伪装信息，例如：
    -   `User-Agent` ：标识客户端类型，例如浏览器或操作系统
    -   `Referer` ：表示请求来源页面
    -   `Cookies` ：用于维持会话或模拟登录状态
    -   `Headers` ：如 `Accept`、`Content-Type` 等，指定希望接收的数据格式
3.  发送请求： 使用 HTTP 库（如 Python 的 `requests`、`httpx` ）将请求发送到服务器

#### 爬虫中的响应

目标服务器接收到爬虫的请求后，返回一个 HTTP 响应。爬虫通过解析响应内容提取所需数据

**响应的解析：**

1.  状态码检查：
    -   `200 OK` ：请求成功，爬虫可以进一步解析网页内容
    -   `301/302 重定向` ：服务器将请求指向新地址，爬虫需要跟随重定向
    -   `403 Forbidden` ：请求被拒绝，可能因为未授权访问或触发反爬机制
    -   `404 Not Found` ：资源不存在
    -   `429 Too Many Requests` ：请求频率过高，触发速率限制
2.  解析响应头：
    -   `Content-Type` ：确定返回内容的类型，如 `text/html` 或 `application/json`
    -   `Cookies ` ：可能需要提取并在后续请求中使用
3.  处理响应体：
    -   HTML 页面：用解析库（如 `BeautifulSoup` 或 `lxml` ）提取特定数据
    -   JSON 数据：直接解析为字典形式，用于提取结构化信息
    -   文件资源：如图片、PDF 等，保存到本地

#### 请求与响应的特殊场景

1. 动态内容加载：

有些网页内容通过 JavaScript 动态加载。爬虫可能需要：

-   使用浏览器自动化工具（如 Selenium）
-   分析 AJAX 请求，并模拟相应的 API 请求

2. 反爬机制：

-   IP 限制：触发频繁访问的防护，需切换代理 IP
-   验证码：阻止机器人访问，需使用 OCR 或破解工具处理
-   隐藏数据：部分数据可能以加密形式返回，需进行解密

#### 完整爬虫流程中的请求与响应

1.  输入目标 URL：构造请求，设置伪装信息
2.  发送请求：向服务器获取网页
3.  接收响应：检查状态码，解析响应头和体
4.  提取数据：从响应中抓取所需内容，存储到数据库或文件中
5.  递归处理：提取新链接并继续请求，直到抓取完成



## Urllib 库

------

### 安装

```
pip install urllib
```

### request 模块

#### 打开 URL

`urllib.request.urlopen(url, data=None, [timeout, ], cafile=None, capath=None, cadefault=False, context=None)`

| 参数        | 说明                                                         |
| ----------- | ------------------------------------------------------------ |
| `url`       | 要打开的 URL                                                 |
| `data`      | 可选参数，用于指定发送到服务器的数据。默认为 `None` ，表示不发送数据 |
| `timeout`   | 可选参数，指定超时时间（单位为秒）。默认为 `socket._GLOBAL_DEFAULT_TIMEOUT` ，表示使用全局默认超时时间 |
| `cafile`    | 可选参数，指定 CA 证书文件，默认为 `None`                    |
| `capath`    | 可选参数，指定 CA 证书路径，默认为 `None`                    |
| `cadefault` | 是否使用默认的 CA 证书，默认为 `False`                       |
| `context`   | 可选参数，用于指定SSL上下文，用于HTTPS请求中的证书验证和其他配置 |

方法：

| 方法名        | 作用                                           |
| ------------- | ---------------------------------------------- |
| `read()`      | 读取指定长度的内容，不写参数就是读取全部内容   |
| `readline()`  | 读取一行内容                                   |
| `readlines()` | 读取全部内容到一个列表中，每个元素都是一行内容 |
| `getcode()`   | 获取 HTTP 状态码，例如检查网页是否存在         |
| `info()`      | 获取 HTTP 响应头信息                           |
| `geturl()`    | 获取网页的 URL                                 |

```python
# 导包
import urllib.request
# 定义一个 URL
url = 'https://fanyi.baidu.com/sug'
# 定义参数
data = {
    'kw': 'dream'
}
# POST请求的参数必须进行编码
data = urllib.parse.urlencode(data).encode("UTF-8")
# 定制请求头
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36'
}
# 构建请求对象
req = urllib.request.Request(url=url, data=data, headers=headers)
# 模拟浏览器向用户发送请求
res = urllib.request.urlopen(url)
# 获取相应内容
content = res.read().decode("UTF-8")
```

>   res 是 HTTPResponse 类型

#### 下载 URL 内容

`urllib.request.urlretrieve(url, filename=None, reporthook=None, data=None)`

| 参数         | 说明                                                         |
| ------------ | ------------------------------------------------------------ |
| `url`        | 要下载的 URL                                                 |
| `filename`   | 可选参数，指定保存内容的本地文件名。如果不指定，将自动生成一个临时文件名 |
| `reporthook` | 可选参数，用于指定一个回调函数，用于显示下载进度             |
| `data`       | 可选参数，用于指定发送到服务器的数据。默认为 `None` ，表示不发送数据 |

```python
# 导包
import urllib.request
# 定义网页 URL
url = "https://www.baidu.com/"
# 下载网页源码
urllib.request.urlretrieve(url=url, filename="baidu.html")
# 定义图片 URL
url_img = "https://img.moegirl.org.cn/common/0/04/Bangdreamgdp4th.jpg"
# 下载图片
urllib.request.urlretrieve(url=url_img, filename="bangdream.jpg")
# 定义视频 URL
url_video = "https://vdept3.bdstatic.com/mda-kikph1r9mw6itkhk/v1-cae/mda-kikph1r9mw6itkhk.mp4?v_from_s=hkapp-haokan-hnb&auth_key=1721709279-0-0-1de6238ef771568b382a334cdf93ef89&bcevod_channel=searchbox_feed&cr=0&cd=0&pd=1&pt=3&logid=2078779992&vid=17284216555185208768&klogid=2078779992&abtest="
# 下载视频
urllib.request.urlretrieve(url=url_video, filename="剧场版《BanG Dream! FILM LIVE 2nd Stage》先导影片 2021年上映.mp4")
```

#### 构建 HTTP 请求

`urllib.request.Request(url, data=None, headers={}, origin_req_host=None, unverifiable=False, method=None)`

| 参数              | 说明                                                         |
| ----------------- | ------------------------------------------------------------ |
| `url`             | 要请求的 URL                                                 |
| `data`            | 可选参数，用于指定发送到服务器的数据。默认为`None`，表示不发送数据 |
| `headers`         | 可选参数，用于指定请求头信息的字典                           |
| `origin_req_host` | 可选参数，用于指定请求头中的"Host"字段值                     |
| `unverifiable`    | 可选参数，指示请求是否是无法验证的                           |
| `method`          | 可选参数，用于指定请求方法（ GET、POST 等）。默认为 `None` ，表示使用默认方法 |

```python
# 导包
import urllib.request
# 定义 URL
url = "https://www.baidu.com/"
# 定制请求头
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36'
}
# 构建一个 HTTP 请求对象
req = urllib.request.Request(url=url, headers=headers)
# 发送请求获取网页源码
res = urllib.request.urlopen(req)
# 读取全部内容
content = res.read().decode("UTF-8")
```

### error 模块

由 `urllib.request` 引发的异常： `urllib.error.URLError`

-   `reason` : 异常原因

HTTP 请求错误： `urllib.error.HTTPError`

-   `code` : HTTP 状态码
-   `reason` : 错误原因
-   `headers` : HTTP 响应头

### parse 模块

解析 URL 字符串并返回一个包含各个组成部分的命名元组：

`urllib.parse.urlparse(urlstring, scheme='', allow_fragments=True)`

| 参数              | 说明                                                         |
| ----------------- | ------------------------------------------------------------ |
| `urlstring`       | 要解析的 URL 字符串                                          |
| `scheme`          | 可选参数，用于指定默认的URL协议。如果URL字符串中没有指定协议，将使用默认的协议 |
| `allow_fragments` | 可选参数，用于指示是否允许解析URL中的片段标识符。默认为`True` |

将一个包含 URL 各个组成部分的命名元组转换为一个URL字符串：

`urllib.parse.urlunparse(parts)`

| 参数    | 说明                          |
| ------- | ----------------------------- |
| `parts` | 包含URL各个组成部分的命名元组 |

将一个相对URL与一个基础 URL 进行组合，生成一个绝对URL：

`urllib.parse.urljoin(base, url, allow_fragments=True)`

| 参数              | 说明                                                         |
| ----------------- | ------------------------------------------------------------ |
| `base`            | 基础 URL                                                     |
| `url`             | 相对 URL                                                     |
| `allow_fragments` | 可选参数，用于指示是否允许组合后的URL中包含片段标识符。默认为`True` |

将字典转换为 URL 编码的查询字符串：

`urllib.parse.urlencode(query, doseq=False, safe='', encoding=None, errors=None, quote_via=quote_plus)`

| 参数                                            | 说明                                                         |
| ----------------------------------------------- | ------------------------------------------------------------ |
| `query`                                         | 包含键值对的字典或可迭代对象                                 |
| `doseq`                                         | 可选参数，用于指示是否对多个相同的键生成多个键值对。默认为`False`，表示生成一个键值对 |
| `safe` 、 `encoding` 、 `errors` 、 `quote_via` | 可选参数，用于指定编码和引用的选项                           |

```python
# 导包
import urllib.parse
# 把参数编成一个字典
data = {
    'wd': '少女乐团派对',
    'game': '音游',
    'server': '国服'
}
# 传入字典，编码并拼接
data = urllib.parse.urlencode(data)
```

将查询字符串解析回字典：

`urllib.parse.parse_qs(qs, keep_blank_values=False, strict_parsing=False)`

| 参数                | 说明                         |
| ------------------- | ---------------------------- |
| `qs`                | 查询字符串                   |
| `keep_blank_values` | 是否保留空值，默认为 `False` |
| `strict_parsing`    | 是否严格解析，默认为 `False` |

对字符串进行 URL 编码，将特殊字符替换为 %xx 的形式：

`urllib.parse.quote(string, safe='/')`

| 参数     | 说明                               |
| -------- | ---------------------------------- |
| `string` | 要编码的字符串                     |
| `safe`   | 可选参数，用于指定不需要编码的字符 |

```python
# 导包
import urllib.parse
# 定义 URL
url = 'https://www.baidu.com/s?wd='
# 字符串编码
parse_url = urllib.parse.quote("少女乐团派对")
```

### robotparser 模块

#### 创建对象：

`urllib.robotparser.RobotFileParser()`

-   `set_url(url)`: 设置 `robots.txt` 文件的 URL
-   `read()`: 读取并解析 `robots.txt` 文件
-   `parse(lines)`: 解析 `robots.txt` 文件的行
-   `can_fetch(useragent, url)`: 检查指定的 `useragent` 是否可以抓取 `url`

#### Cookie 登录

`Cookie` 是 Web 服务器发送给客户端的数据片段，用于存储用户会话信息、身份验证令牌、偏好设置等

```python
# 导包
import urllib.request
# 定义 URl
url = "https://weibo.cn/6664219641/info"
# 定制请求头
headers = {
    # Cookie: 用户登录信息
    "Cookie": "_T_WM=938debadd5be889d45989b7dd4cbe7ab; SUB=_2A25LpbCPDeRhGeBI7VYT8SfKzz2IHXVo20xHrDV6PUJbktANLXD1kW1NRmjUyQ65XyFt_tls4iB3UjZz-RkjqPAT; SUBP=0033WrSXqPxfM725Ws9jqgMF55529P9D9W5SQq3n1zDz9ICY_cPd75r_5JpX5KzhUgL.FoqcSoBEeK.cSh22dJLoIp7LxKML1KBLBKnLxKqL1hnLBoMcSoqXeo24SoBp; SSOLoginState=1721876703; ALF=1724468703",
    # Referer: 判断此路径是否由上一个页面跳转来的
    "Referer":"https://weibo.cn/",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
}
# 定制请求对象
req = urllib.request.Request(url=url, headers=headers)
# 发送请求接收响应
res = urllib.request.urlopen(req)
# 获取响应内容
content = res.read().decode("UTF-8")
```

#### Handler 处理器

handler 处理器是用于处理 HTTP 请求的组件。它们允许用户自定义网络请求的处理细节，如代理、身份验证、重定向等

| 常用 Handler 处理器     | 用途                   | 功能                             |
| ----------------------- | ---------------------- | -------------------------------- |
| `HTTPHandler`           | 处理 HTTP 请求         | 发送 HTTP 请求和接收响应         |
| `HTTPSHandler`          | 处理 HTTPS 请求        | 处理 SSL 加密的 HTTP 请求        |
| `ProxyHandler`          | 通过代理服务器发送请求 | 允许请求通过指定的代理服务器转发 |
| `HTTPCookieProcessor`   | 处理 HTTP Cookies      | 自动处理发送和接收的 Cookies     |
| `HTTPBasicAuthHandler`  | 处理基本的 HTTP 认证   | 帮助处理需要 HTTP 基本认证的请求 |
| `HTTPDigestAuthHandler` | 处理摘要式的 HTTP 认证 | 处理需要摘要式认证的请求         |

```python
# 导包
import urllib.request
# 定义 URL
url = 'https://www.baidu.com/'
# 定制请求头
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
}
# 定制请求对象
req = urllib.request.Request(url, headers=headers)
# 获取 handler 对象
handler = urllib.request.HTTPHandler()
# 获取 opener 对象
opener = urllib.request.build_opener(handler)
# 调用 opener 对象
res = opener.open(req)
# 获取响应内容
content = res.read().decode("UTF-8")
```

#### Proxies 代理服务器

```python
#导包
import urllib.request
# 定义 URl
url = 'https://www.baidu.com/s?&wd=%E5%B0%91%E5%A5%B3%E4%B9%90%E5%9B%A2%E6%B4%BE%E5%AF%B9'
# 定制请求头
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36"
}
# 定制请求对象
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
# 获取 opener 对象，发送请求
opener = urllib.request.build_opener(handler)
# 调用 opener 对象，获取响应
res = opener.open(req)
```



## XPath 与 lxml 库

------

### XPath

XPath（XML Path Language）是一种在 XML 和 HTML 文档中查找信息的语言，用于在 XML 文档中进行导航和定位元素。XPath 使用路径表达式来选取文档中的节点或节点集

#### 节点选取

轴（Axixs）：定义了相对当前节点的导航方向

-   `child::` ：选取当前节点的所有直接子元素
-   `parent::` ：选取当前节点的父元素
-   `descendant::` ：选取当前节点的所有后代元素（子元素、孙元素等）
-   `ancestor::` ：选取当前节点的所有祖先元素（父元素、祖父元素等）
-   `attribute::` ：选取当前节点的所有属性
-   `self::` ：选取当前节点本身
-   `following-sibling::` ：选取当前节点之后的所有同级元素
-   `preceding-sibling::` ：选取当前节点之前的所有同级元素

节点测试（Node Test）：用于匹配特定类型的节点，如 `div` 匹配所有 `div` 元素

-   `element()` ：匹配元素节点
-   `attribute()` ：匹配属性节点
-   `text()` ：匹配文本节点
-   `comment()` ：匹配注释节点
-   `processing-instruction()` ：匹配处理指令节点。

谓语（Predicate）：属性选择。条件表达式，用于更精确地定位节点，它通常放在方括号中。例如 `div[@id='example']`

#### 路径运算符

-   `/` ：表示选取直接子节点
-   `//` ：表示选取子孙节点，无论它们在文档中的位置
-   `.` ：表示当前节点
-   `..` ：表示当前节点的父节点
-   `@` ：表示选取属性，如 `@id` 选取所有具有 `id` 属性的节点

#### 通配符

-   `*` ：匹配任何元素节点
-   `@*` ：匹配任何属性节点
-   `node()` ：匹配任何类型的节点

#### 函数

字符串函数：

-   `string()` ：将节点集转换为字符串
-   `concat()` ：连接两个或多个字符串
-   `starts-with()` ：检查字符串是否以指定的前缀开始
-   `contains()` ：检查字符串是否包含指定的子字符串
-   `substring()` ：提取字符串的子字符串
-   `string-length()` ：返回字符串的长度

数值函数：

-   `number()` ：将字符串转换为数值
-   `sum()` ：计算节点集的所有数值的总和
-   `floor()` ：返回小于或等于给定数值的最大整数
-   `ceiling()` ：返回大于或等于给定数值的最小整数
-   `round()` ：四舍五入到最接近的整数

布尔函数：

-   `boolean()` ：将值转换为布尔值
-   `not()` ：对布尔值取反
-   `true()` ：返回布尔值 true
-   `false()` ：返回布尔值 false

节点集函数：

-   `name()` ：返回节点的名称
-   `local-name()` ：返回不带命名空间前缀的节点名称
-   `namespace-uri()` ：返回节点的命名空间 URI
-   `root()` ：返回文档的根节点
-   `document()` ：用于访问外部文档
-   `id()` ：根据节点的ID属性值选取节点

位置函数：

-   `position()` ：返回当前节点在其上下文中的位置
-   `last()` ：返回上下文中节点集的数量
-   `count()` ：计算节点集的数量

#### 使用示例

```html
<books>
    <book>
        <title lang="en">Harry Potter</title>
        <author>J.K. Rowling</author>
    </book>
    <book>
        <title lang="zh">三体</title>
        <author>刘慈欣</author>
    </book>
</books>
```

-   `/books/book[1]` ：选取 `books` 元素下的第一个 `book` 子元素
-   `//book/title[@lang='zh']` ：选取所有 `book` 元素下的 `title` 元素，其中 `lang` 属性值为 `zh`
-   `//book[position()=last()]` ：选取最后一个 `book` 元素
-   `//book/author/text()` ：选取所有 `book` 元素下的 `author` 元素的文本内容
-   `//title[contains(text(), 'Potter')]` ：选取所有 title 元素，并检查它们是否包含子字符串"Potter"

### lxml

lxml 是一个功能强大、易于使用的库，用于处理 XML 和 HTML 文档。它基于 libxml2 和 libxslt，并提供了丰富的 API，支持 XPath 和 XSLT

#### 安装

```
pip install lxml
```

#### 核心模块

etree 模块：

-   处理 XML 和 HTML 的主模块
-   提供解析、构建、修改和序列化文档的功能

objectify 模块：

-   用于简化 XML 数据绑定，将 XML 转换为 Python 对象

#### 基础操作

解析 XML文档：

```python
from lxml import etree

# 从字符串解析 XML
xml_string = """<root><child name="child1">Content</child></root>"""
root = etree.fromstring(xml_string)  # 将字符串解析为 XML 元素树

# 从文件解析 XML
tree = etree.parse("example.xml")  # 解析 XML 文件
root = tree.getroot()  # 获取根节点
```

构建 XML：

```python
from lxml import etree

# 创建根节点
root = etree.Element("root")

# 创建子节点并添加到根节点
child = etree.SubElement(root, "child", name="child1")  # 设置属性
child.text = "Content"  # 设置子节点内容

# 转换为字符串并打印
xml_bytes = etree.tostring(root, pretty_print=True, encoding="utf-8")  # 美化输出
print(xml_bytes.decode("utf-8"))
```

XPath 查询：

```python
from lxml import etree

# 准备 XML 数据
xml_string = """<root><child name="child1">Content</child></root>"""
root = etree.fromstring(xml_string)

# 查询所有子节点
children = root.xpath("//child")  # 使用 XPath 查询 child 节点
for child in children:
    print(child.tag, child.text)  # 打印节点标签和内容

# 带条件的查询
filtered = root.xpath("//child[@name='child1']")  # 查询具有特定属性的子节点
print(filtered[0].text)  # 打印第一个匹配节点的内容
```

#### HTML 处理

解析 HTML：

```python
from lxml import html

# 准备 HTML 数据
html_string = """<html><body><h1>Title</h1></body></html>"""
tree = html.fromstring(html_string)  # 解析 HTML 字符串

# 使用 XPath 查询标题内容
title = tree.xpath("//h1/text()")[0]  # 获取 <h1> 标签的文本内容
print(title)
```

清理 HTML：`lxml.html.clean` 模块可用于移除 HTML 中的潜在安全风险内容，如 JavaScript

```python
from lxml.html.clean import Cleaner

# 含有潜在风险的 HTML 数据
html_string = """<html><body><script>alert('XSS')</script><h1>Safe</h1></body></html>"""

# 创建清理器对象
cleaner = Cleaner()

# 清理 HTML 数据
safe_html = cleaner.clean_html(html_string)
print(safe_html)  # 打印清理后的 HTML
```

#### 高级功能

XSLT 转换：

```python
from lxml import etree

# 原始 XML 数据
xml = etree.XML("""<root><child>Text</child></root>""")

# XSLT 模板
xslt = etree.XML("""<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <newroot><xsl:copy-of select="*"/></newroot>
</xsl:template>
</xsl:stylesheet>""")

# 执行 XSLT 转换
transform = etree.XSLT(xslt)
new_xml = transform(xml)

# 打印转换后的 XML
print(str(new_xml))
```

解析大文件（逐行解析）：使用 `iterparse` 方法

```python
from lxml import etree

# 逐行解析 XML 文件
for event, element in etree.iterparse("large.xml", events=("start", "end")):
    if event == "end" and element.tag == "target_tag":  # 仅处理结束事件和目标标签
        print(element.text)  # 打印目标标签内容
        element.clear()  # 清理已处理的节点，释放内存
```

#### 性能优化

-   `lxml` 是基于 C 的，因此性能非常高
-   对于只读操作，可以使用 `fromstring` 和 `iterparse`
-   使用 `objectify` 模块进一步简化代码

#### 常见问题

-   `UnicodeDecodeError` ：确保文档编码与解析时的设置一致，例如指定 `encoding="utf-8"``
-   ``XMLSyntaxError` ：确保输入的 XML 格式正确
-   HTML 格式不规范：使用 `html.fromstring` 或 `html.parser` 来处理不规范的 HTML



## Jsonpath 库

------

jsonpath-ng 是一个功能强大的库，用于在 JSON 数据中执行路径查询。它是 JSONPath 的 Python 实现，支持多种操作符和扩展功能

扩展库 jsonpath-ng.ext 提供了额外的功能，如过滤和正则表达式支持

### 安装

```
pip install jsonpath-ng
# 安装扩展版本
pip install jsonpath-ng.ext
```

### JSONPath 的基本语法

-   `$` ：根节点
-   `.` ：访问子属性
-   `..` ：递归搜索
-   `[]` ：用于数组索引或属性筛选
-   `[*]` ：数组中的所有元素
-   `?()` ：条件过滤
-   `(@.property)` ：当前节点

### 基础操作

导入库：

```python
from jsonpath_ng import jsonpath, parse  # 基础库
# 使用扩展功能时
from jsonpath_ng.ext import parse
```

解析 JSON 并查询：

```python
from jsonpath_ng import parse

# 示例 JSON 数据
data = {
    "store": {
        "book": [
            {"category": "fiction", "price": 10.99},
            {"category": "non-fiction", "price": 12.99}
        ],
        "bicycle": {"color": "red", "price": 19.95}
    }
}

# 定义 JSONPath 表达式
jsonpath_expr = parse('$.store.book[*].category')

# 执行查询
results = [match.value for match in jsonpath_expr.find(data)]
print(results)  # 输出 ['fiction', 'non-fiction']
```

使用数组索引：

```python
# 查询第一本书的价格
jsonpath_expr = parse('$.store.book[0].price')
price = [match.value for match in jsonpath_expr.find(data)]
print(price)  # 输出 [10.99]
```

### 条件过滤（拓展功能）

基本过滤：

```python
from jsonpath_ng.ext import parse

# 查询价格大于 11 的书
jsonpath_expr = parse('$.store.book[?(@.price > 11)]')

results = [match.value for match in jsonpath_expr.find(data)]
print(results)
# 输出 [{'category': 'non-fiction', 'price': 12.99}]
```

复杂条件：

```python
# 查询分类为 fiction 且价格小于 11 的书
jsonpath_expr = parse('$.store.book[?(@.category == "fiction" && @.price < 11)]')

results = [match.value for match in jsonpath_expr.find(data)]
print(results)
# 输出 [{'category': 'fiction', 'price': 10.99}]
```

正则表达式：

```python
from jsonpath_ng.ext import parse

# 查询分类以 "non" 开头的书
jsonpath_expr = parse('$.store.book[?(@.category =~ /non.*/)]')

results = [match.value for match in jsonpath_expr.find(data)]
print(results)
# 输出 [{'category': 'non-fiction', 'price': 12.99}]
```

### 高级用法与常见问题

#### 递归搜索

```python
# 查询所有价格
jsonpath_expr = parse('$..price')

results = [match.value for match in jsonpath_expr.find(data)]
print(results)
# 输出 [10.99, 12.99, 19.95]
```

#### 更新 JSON 数据

支持修改匹配到的 JSON 数据。示例：修改值

```python
from jsonpath_ng import parse

# 示例 JSON 数据
data = {"items": [{"name": "item1", "price": 5}, {"name": "item2", "price": 15}]}

# 定义 JSONPath 表达式
jsonpath_expr = parse('$.items[*].price')

# 修改价格
for match in jsonpath_expr.find(data):
    match.context.value[match.path.fields[0]] = match.value + 1

print(data)
# 输出 {"items": [{"name": "item1", "price": 6}, {"name": "item2", "price": 16}]}
```

#### 错误处理

-   查询未匹配到结果会返回空列表。
-   对于不规范的 JSON 数据，可能会抛出 `JSONDecodeError`

#### 性能优化

-   对于大数据集，尽量限制查询的范围，避免使用全局搜索 `..`
-   合理设计 JSONPath 表达式，提高查询效率

#### 常见问题

-   匹配多个结果：查询可能会返回多个匹配项，建议使用列表解析获取所有值
-   使用正则表达式：正则表达式需要在 `jsonpath-ng.ext` 中使用
-   替代选择：如果查询较为简单，可以使用 Python 的内置方法处理 JSON



## BeautifulSoup 库

------

Beautiful Soup 是一个用于解析 HTML 和 XML 的 Python 库。它提供了简单的 API，可以轻松地从网页中提取数据，并支持多种解析器

### 安装

```
pip install beautifulsoup4
pip install lxml  # 推荐的解析器（可选）
pip install html5lib  # 可选的解析器
```

### 基础概念

解析器选项：

-   `html.parser`：Python 内置解析器，易用但性能一般
-   `lxml`：性能更高，支持 HTML 和 XML
-   `html5lib`：构建更完整的 HTML 树，但速度较慢

数据结构：Beautiful Soup 会将 HTML/XML 转换为一棵树，提供多种便捷的方法来导航和操作节点

### 使用方法

导入库：

```python
from bs4 import BeautifulSoup
```

解析 HTML：

```python
html_doc = """
<html>
    <head><title>Example Page</title></head>
    <body>
        <p class="content">This is a paragraph.</p>
        <a href="http://example.com" id="link">Example Link</a>
    </body>
</html>
"""

# 使用 lxml 解析器
soup = BeautifulSoup(html_doc, "lxml")

# 使用 html.parser（默认解析器）
soup = BeautifulSoup(html_doc, "html.parser")
```

### 常用操作

#### 获取标签

```python
# 获取第一个 <title> 标签
title_tag = soup.title
print(title_tag.text)  # 输出: Example Page

# 获取第一个 <a> 标签
a_tag = soup.a
print(a_tag['href'])  # 输出: http://example.com
```

#### 查找元素

通过 `find` 和 `find_all`

```python
# 获取第一个符合条件的 <p> 标签
p_tag = soup.find("p", class_="content")
print(p_tag.text)  # 输出: This is a paragraph.

# 获取所有 <a> 标签
a_tags = soup.find_all("a")
for tag in a_tags:
    print(tag['href'])  # 输出所有链接
```

通过 CSS 选择器

```python
# 使用 CSS 选择器查找元素
link = soup.select_one("#link")  # 查找 id 为 link 的元素
print(link['href'])  # 输出: http://example.com

# 查找所有带有类名 content 的 <p> 标签
content_paragraphs = soup.select(".content")
for p in content_paragraphs:
    print(p.text)
```

### 遍历文档树

子节点和父节点：

```python
# 获取子节点
body = soup.body
for child in body.children:
    print(child)  # 输出 <p> 和 <a> 标签

# 获取父节点
a_tag = soup.a
print(a_tag.parent.name)  # 输出: body
```

搜索所有后代：

```python
# 遍历所有后代节点
for descendant in soup.descendants:
    print(descendant)
```

兄弟节点：

```python
# 获取下一个兄弟节点
p_tag = soup.p
print(p_tag.next_sibling)  # 输出: <a href="http://example.com" id="link">Example Link</a>
```

### 修改文档

修改属性：

```python
a_tag = soup.a
a_tag['href'] = "http://newlink.com"
print(a_tag)  # 输出: <a href="http://newlink.com" id="link">Example Link</a>
```

修改内容：

```python
p_tag = soup.p
p_tag.string = "Updated paragraph."
print(p_tag)  # 输出: <p class="content">Updated paragraph.</p>
```

插入新内容：

```python
new_tag = soup.new_tag("div", class_="new-class")
new_tag.string = "This is a new div."

body = soup.body
body.append(new_tag)
print(body)  # 输出带有新 div 的内容
```

#### 删除节点：

```python
# 删除节点
a_tag = soup.a
a_tag.decompose()
print(soup)  # <a> 标签已被移除
```

### 数据提取

提取文本：

```python
# 获取所有文本内容
print(soup.get_text())  # 输出整个文档的文本内容
```

获取属性：

```python
# 获取特定属性值
a_tag = soup.a
print(a_tag['href'])  # 输出: http://example.com
```

### 高级用法

搜索含有特定属性的标签：

```python
# 查找所有带有 href 属性的 <a> 标签
tags = soup.find_all("a", href=True)
for tag in tags:
    print(tag['href'])
```

使用正则表达式匹配：

```python
import re

# 查找以 "http" 开头的链接
tags = soup.find_all("a", href=re.compile("^http"))
for tag in tags:
    print(tag['href'])
```

处理多值属性：

```python
html_doc = '<p class="class1 class2">Example</p>'
soup = BeautifulSoup(html_doc, "html.parser")

# 查找含有特定类名的标签
tag = soup.find("p", class_="class1")
print(tag.text)  # 输出: Example
```

### 性能优化

-   选择解析器：`lxml` 通常比 `html.parser` 快
-   限制搜索范围：使用 `find` 和 `select_one` 替代 `find_all`
-   分段处理：对于大文档，分段解析可以提高效率

### 常见问题

#### HTML 格式不规范

Beautiful Soup 可以自动修复不完整的 HTML，但可能会出现意外结果。建议使用 `html5lib`

#### 特殊字符处理

Beautiful Soup 会自动处理 HTML 转义字符（如 `&` ）

#### Unicode 问题

解析含有特殊字符的 HTML 时，确保使用合适的编码（如 `utf-8` ）



## Selenium 库

------

Selenium 是一个用于自动化浏览器操作的工具，支持多种浏览器（Chrome、Firefox、Edge 等），并且可以用于测试、数据抓取和其他需要浏览器交互的任务

### 安装

```
pip install selenium
```

### 浏览器驱动

Selenium 需要匹配的浏览器驱动，例如：

-   ChromeDriver：用于 Chrome 浏览器
-   GeckoDriver：用于 Firefox 浏览器
-   EdgeDriver：用于 Edge 浏览器

驱动下载：官方驱动链接

### 快速开始

启动浏览器：

```python
from selenium import webdriver
from selenium.webdriver.common.by import By

# 配置 Chrome 浏览器
driver = webdriver.Chrome()

# 打开网页
driver.get("https://www.example.com")

# 关闭浏览器
driver.quit()
```

### 常用操作

查找元素：

```python
from selenium.webdriver.common.by import By

# 查找单个元素
element = driver.find_element(By.ID, "element_id")
element = driver.find_element(By.NAME, "element_name")
element = driver.find_element(By.CLASS_NAME, "element_class")
element = driver.find_element(By.TAG_NAME, "tag_name")
element = driver.find_element(By.CSS_SELECTOR, ".class_name")
element = driver.find_element(By.XPATH, "//tag[@attribute='value']")

# 查找多个元素
elements = driver.find_elements(By.CLASS_NAME, "class_name")
```

操作元素：

```python
# 点击按钮
button = driver.find_element(By.ID, "submit")
button.click()

# 输入文本
input_box = driver.find_element(By.NAME, "username")
input_box.send_keys("my_username")

# 清空输入框
input_box.clear()

# 获取文本
text = driver.find_element(By.ID, "header").text

# 获取属性
attribute_value = driver.find_element(By.ID, "logo").get_attribute("src")
```

### 等待操作

隐式等待：适用于全局设置等待时间

```python
driver.implicitly_wait(10)  # 设置全局等待时间为 10 秒
```

显式等待：等待特定条件满足时继续执行

```python
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# 等待元素可见
element = WebDriverWait(driver, 10).until(
    EC.visibility_of_element_located((By.ID, "element_id"))
)

# 等待元素可点击
element = WebDriverWait(driver, 10).until(
    EC.element_to_be_clickable((By.ID, "submit_button"))
)
```

### 浏览器操作

页面导航：

```python
# 打开 URL
driver.get("https://www.example.com")

# 获取当前 URL
current_url = driver.current_url

# 返回上一页
driver.back()

# 前进到下一页
driver.forward()

# 刷新页面
driver.refresh()
```

窗口管理：

```python
# 获取当前窗口句柄
current_window = driver.current_window_handle

# 获取所有窗口句柄
all_windows = driver.window_handles

# 切换窗口
driver.switch_to.window(all_windows[1])
```

### 高级功能

执行 JavaScript：

```python
# 执行 JavaScript
driver.execute_script("alert('Hello, Selenium!');")
```

处理弹窗：

```python
# 切换到弹窗
alert = driver.switch_to.alert

# 获取弹窗文本
print(alert.text)

# 接受弹窗
alert.accept()

# 取消弹窗
alert.dismiss()
```

截图：

```python
# 保存全屏截图
driver.save_screenshot("screenshot.png")
```

### 文件上传和下载

文件上传：

```python
upload_element = driver.find_element(By.ID, "file_input")
upload_element.send_keys("C:/path/to/your/file.txt")
```

文件下载（基于浏览器配置）：

```python
from selenium.webdriver.chrome.options import Options

# 设置 Chrome 配置
chrome_options = Options()
prefs = {"download.default_directory": "C:/path/to/download"}
chrome_options.add_experimental_option("prefs", prefs)

# 启动浏览器
driver = webdriver.Chrome(options=chrome_options)
```

### 移动操作（鼠标和键盘）

鼠标操作：

```python
from selenium.webdriver import ActionChains

# 初始化鼠标操作
actions = ActionChains(driver)

# 悬停
element = driver.find_element(By.ID, "menu")
actions.move_to_element(element).perform()

# 拖拽
source = driver.find_element(By.ID, "source")
target = driver.find_element(By.ID, "target")
actions.drag_and_drop(source, target).perform()
```

键盘操作：

```python
from selenium.webdriver.common.keys import Keys

input_box = driver.find_element(By.NAME, "search")
input_box.send_keys("Selenium")
input_box.send_keys(Keys.ENTER)
```

### 管理 Cookies

```python
# 获取所有 Cookies
cookies = driver.get_cookies()

# 添加 Cookie
driver.add_cookie({"name": "test_cookie", "value": "test_value"})

# 删除 Cookie
driver.delete_cookie("test_cookie")

# 清除所有 Cookies
driver.delete_all_cookies()
```

### 关闭浏览器

关闭当前窗口：

```python
driver.close()
```

退出浏览器：

```python
driver.quit()
```

### 性能优化

无头模式（Headless Mode）：

```python
from selenium.webdriver.chrome.options import Options

options = Options()
options.add_argument("--headless")
driver = webdriver.Chrome(options=options)
```

禁用图片加载：

```python
chrome_options = Options()
prefs = {"profile.managed_default_content_settings.images": 2}
chrome_options.add_experimental_option("prefs", prefs)
driver = webdriver.Chrome(options=chrome_options)
```

### 常见问题

-   `SessionNotCreatedException` ：确保浏览器版本和驱动版本兼容
-   `TimeoutException` ：增加等待时间，或者检查元素定位是否正确
-   元素不可见或未加载：使用显式等待确保元素加载完成



## Requests 库

------

Requests 是一个 Python 的 HTTP 库，旨在让 HTTP 请求变得简单易用。它支持发送 GET、POST 等 HTTP 请求，并提供了便捷的 API 来处理响应数据

### 安装

```
pip install requests
```

### HTTP 方法

GET 请求：

```python
# 带参数的 GET 请求
params = {"key1": "value1", "key2": "value2"}
response = requests.get("https://httpbin.org/get", params=params)

print(response.url)  # 输出请求的完整 URL
print(response.json())  # 解析 JSON 响应
```

POST 请求：

```python
# 发送表单数据
data = {"key1": "value1", "key2": "value2"}
response = requests.post("https://httpbin.org/post", data=data)

print(response.json())  # 输出 JSON 响应
```

### 请求参数

请求头 ：

```python
headers = {"User-Agent": "my-app"}
response = requests.get("https://httpbin.org/headers", headers=headers)
print(response.json())
```

JSON 数据：

```python
# 发送 JSON 数据
json_data = {"key": "value"}
response = requests.post("https://httpbin.org/post", json=json_data)
print(response.json())
```

文件上传：

```python
files = {"file": open("example.txt", "rb")}
response = requests.post("https://httpbin.org/post", files=files)
print(response.json())
```

### 响应处理

基本属性：

| 方法                   | 说明                              |
| ---------------------- | --------------------------------- |
| `response.status_code` | HTTP 状态码                       |
| `response.headers`     | 响应头                            |
| `response.text`        | 响应内容（文本）                  |
| `response.content`     | 响应内容（二进制）                |
| `response.json()`      | JSON 响应（需要确保是 JSON 格式） |

响应状态检查：

```python
response = requests.get("https://www.example.com")
response.raise_for_status()  # 如果状态码为 4xx/5xx 会抛出异常
```

### 超时和重试

#### 设置超时

```python
response = requests.get("https://www.example.com", timeout=5)  # 超时时间为 5 秒
```

#### 重试机制

通过 `urllib3` 的 `Retry` 功能实现：

```python
from requests.adapters import HTTPAdapter
from requests.packages.urllib3.util.retry import Retry

session = requests.Session()
retries = Retry(total=3, backoff_factor=0.3, status_forcelist=[500, 502, 503, 504])
adapter = HTTPAdapter(max_retries=retries)

session.mount("http://", adapter)
session.mount("https://", adapter)

response = session.get("https://httpbin.org/status/500")
```

### 会话（Session）

使用会话对象：

```python
session = requests.Session()
session.headers.update({"User-Agent": "my-app"})

# 使用会话发送请求
response = session.get("https://httpbin.org/headers")
print(response.json())
```

持久化 Cookie：

```python
# 自动处理 Cookie
session = requests.Session()
session.get("https://httpbin.org/cookies/set?key=value")
response = session.get("https://httpbin.org/cookies")
print(response.json())
```

### 身份验证

基本认证：

```python
from requests.auth import HTTPBasicAuth

response = requests.get("https://httpbin.org/basic-auth/user/passwd", auth=HTTPBasicAuth("user", "passwd"))
print(response.json())
```

Token 认证：

```python
headers = {"Authorization": "Bearer your_token"}
response = requests.get("https://api.example.com/protected", headers=headers)
print(response.json())
```

### 代理设置

```python
proxies = {
    "http": "http://10.10.1.10:3128",
    "https": "https://10.10.1.11:1080",
}
response = requests.get("https://www.example.com", proxies=proxies)
```

### SSL 验证

默认验证：Requests 默认会验证 SSL 证书

忽略 SSL 验证：

```python
response = requests.get("https://self-signed.badssl.com/", verify=False)
print(response.status_code)
```

自定义证书：

```python
response = requests.get("https://example.com", cert=("path/to/cert.pem", "path/to/key.pem"))
```

### 流式下载

流式响应：

```python
response = requests.get("https://www.example.com/large-file", stream=True)

with open("large_file.txt", "wb") as f:
    for chunk in response.iter_content(chunk_size=8192):
        f.write(chunk)
```

流式 JSON 解析：

```python
response = requests.get("https://api.example.com/stream", stream=True)
for line in response.iter_lines():
    if line:
        print(line.decode("utf-8"))
```

### 常见问题

-   `ConnectionError` ：网络连接失败，请检查 URL 或代理设置
-   `Timeout` ：请求超时，请增加超时时间或检查网络连接
-   SSL 证书问题：使用 `verify=False` 忽略 SSL 验证，或提供正确的证书路径

### 性能优化

使用会话（Session）：会话对象可以复用 TCP 连接，提高性能

降低重试次数：对于高并发请求，合理设置重试机制，避免资源浪费



## Scrapy 框架

------

Scrapy 是一个高效的 Python 爬虫框架，主要用于快速提取网页数据并支持多种定制化功能

### 安装与验证

安装：

```
pip install scrapy
```

验证安装：

```
scrapy --version
```

### 创建 Scrapy 项目

#### 初始化项目

```
scrapy startproject <项目名称>
```

#### 目录结构

```
<项目名称>/
├── <项目名称>/       # 项目模块
│   ├── spiders/      # 自定义爬虫文件
│   ├── __init__.py   # 初始化文件
│   ├── items.py      # 定义爬取的数据结构
│   ├── pipelines.py  # 数据处理逻辑
│   ├── middlewares.py # 中间件定义
│   └── settings.py   # 项目配置
├── scrapy.cfg        # 配置入口文件
```

#### 创建爬虫

```
scrapy genspider <爬虫名称> <目标域名>
```

#### 编写爬虫

以下是一个简单爬虫的示例，爬取 `example.com` 的标题：

```python
import scrapy

class ExampleSpider(scrapy.Spider):
    name = "example"  # 爬虫名称，运行时使用
    start_urls = ["http://example.com"]  # 初始 URL 列表

    def parse(self, response):
        # 提取网页标题
        title = response.xpath("//title/text()").get()
        yield {"title": title}  # 生成一个结果字典
```

#### 启动爬虫

```
scrapy crawl <爬虫名称>
```

### 数据提取

#### 使用 XPath

```python
# 提取单个元素
response.xpath("//title/text()").get()

# 提取多个元素
response.xpath("//a/@href").getall()
```

#### 使用 CSS 选择器

```python
# 提取单个元素
response.css("title::text").get()

# 提取多个元素
response.css("a::attr(href)").getall()
```

### 管道

#### 定义管道

在 `pipelines.py` 中定义数据处理逻辑：

```python
class ExamplePipeline:
    def process_item(self, item, spider):
        # 对数据进行处理
        print(item)
        return item
```

#### 启用管道

在 `settings.py` 中激活管道：

```python
ITEM_PIPELINES = {
    '<项目名称>.pipelines.ExamplePipeline': 300,  # 数字表示执行优先级，越小优先级越高
}
```

### 配置文件 ( `settings.py` )

设置 User-Agent：

```python
USER_AGENT = "my-bot (+http://www.example.com)"
```

设置并发数：

```python
CONCURRENT_REQUESTS = 16  # 默认 16
```

设置下载延迟：

```python
DOWNLOAD_DELAY = 1  # 单位为秒
```

禁用机器人协议（默认启用）：

```python
ROBOTSTXT_OBEY = False
```

### 中间件（Middlewares）

#### 定义中间件

在 `middlewares.py` 中定义：

```python
class ExampleMiddleware:
    def process_request(self, request, spider):
        # 在请求发送前处理
        request.headers["User-Agent"] = "CustomUserAgent"
        return None
```

#### 启用中间件

在 `settings.py` 中激活：

```python
DOWNLOADER_MIDDLEWARES = {
    '<项目名称>.middlewares.ExampleMiddleware': 543,
}
```

### 存储爬取数据

将结果保存为 JSON 文件：

```
scrapy crawl <爬虫名称> -o output.json
```

保存为 CSV 文件：

```
scrapy crawl <爬虫名称> -o output.csv
```

### 日志和调试

#### 启用调试日志

在 `settings.py` 中设置：

```python
LOG_LEVEL = "DEBUG"
```

#### 使用 `shell` 调试：

```
scrapy shell <URL>
```

进入调试模式后，可以直接运行 XPath 或 CSS 查询：

```
response.xpath("//title/text()").get()
```

### 高级功能

#### 爬取多页数据

通过 `next_page` 链接实现多页爬取：

```python
def parse(self, response):
    # 提取当前页的数据
    for item in response.css("div.item"):
        yield {"name": item.css("h2::text").get()}

    # 获取下一页链接
    next_page = response.css("a.next::attr(href)").get()
    if next_page:
        yield response.follow(next_page, callback=self.parse)
```

#### 自定义命令行参数

```
scrapy crawl <爬虫名称> -a category="electronics"
```

在爬虫中获取参数：

```python
class ExampleSpider(scrapy.Spider):
    name = "example"

    def __init__(self, category=None, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.start_urls = [f"http://example.com/{category}"]
```

#### 分布式爬取

使用 Scrapy 和 Redis 实现分布式爬取，推荐搭配 `scrapy-redis`

### 性能优化

#### 启用缓存

```python
HTTPCACHE_ENABLED = True
HTTPCACHE_EXPIRATION_SECS = 3600  # 缓存有效期
```

#### 使用异步下载器

默认情况下，Scrapy 已启用异步下载器，无需额外配置

#### 增加并发数

```python
CONCURRENT_REQUESTS = 32
```

### 常见问题

#### 访问受限制的内容（如登录）

可在爬虫中模拟登录请求：

```python
import scrapy

class LoginSpider(scrapy.Spider):
    name = "login"

    def start_requests(self):
        return [scrapy.FormRequest("http://example.com/login",
                                   formdata={"username": "user", "password": "pass"},
                                   callback=self.after_login)]

    def after_login(self, response):
        # 登录后爬取其他页面
        yield scrapy.Request("http://example.com/dashboard")
```

#### 遇到 IP 限制

-   使用代理池或 VPN
-   增加请求延迟：

```python
DOWNLOAD_DELAY = 2
```

