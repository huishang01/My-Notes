import urllib.request
import urllib.error


url = "https://www.ghxxi.com/"

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36'
}

try:
    req = urllib.request.Request(url=url, headers=headers)

    res = urllib.request.urlopen(req)

    content = res.read().decode("UTF-8")

    print(content)
except urllib.error.URLError:
    print("系统出错")