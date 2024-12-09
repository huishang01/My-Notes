import json
import urllib.request
import jsonpath

url = 'https://dianying.taobao.com/cityAction.json?activityId=&_ksTS=1726884505385_512&jsoncallback=jsonp513&action=cityAction&n_s=new&event_submit_doGetAllRegion=true'

headers = {
    "Host": "dianying.taobao.com",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:124.0) Gecko/20100101 Firefox/124.0",
    "Accept": "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01",
    "Accept-Language": "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2",
    "Accept-Encoding": "gzip, deflate, br",
    "X-Requested-With": "XMLHttpRequest",
    "bx-v": "2.5.20",
    "Connection": "keep-alive",
    "Referer": "https://dianying.taobao.com/",
    "Cookie": "cna=yjIoHjf6QU8BASQJilAptZKb; t=c1aca9cf75aff1285d80d2846baecf7b; cookie2=1c5fe548147b1c52aa0587e2b319a87a; v=0; _tb_token_=59eb381d87d13; isg=BDw8SaKndiE4UEJ97tTAVPHADtruNeBfP2jPOha9nCcK4d1rPkdk75AfwYmZshi3; xlly_s=1",
    "Sec-Fetch-Dest": "empty",
    "Sec-Fetch-Mode": "cors",
    "Sec-Fetch-Site": "same-origin"
}

req = urllib.request.Request(url, headers=headers)

res = urllib.request.urlopen(req)

content = res.read()

obj = json.load(open('2.解析淘票票.json', 'r', encoding='utf-8'))

cities = jsonpath.jsonpath(obj, '$..regionName')

print(cities)

