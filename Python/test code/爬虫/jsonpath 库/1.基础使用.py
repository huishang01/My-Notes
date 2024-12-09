import jsonpath
import json

obj = json.load(open('1.基础使用.json', 'r', encoding='utf-8'))

# 获取所有作者
# authors = jsonpath.jsonpath(obj, '$.store.book[*].author')
authors = jsonpath.jsonpath(obj, '$..author')

# 获取所有书
tags = jsonpath.jsonpath(obj, '$.store.*')

# 获取所有书的价格
prices = jsonpath.jsonpath(obj, '$.store..price')

# 获取第三本书
third_book = jsonpath.jsonpath(obj, '$..book[2]')

# 获取最后一本书
last_book = jsonpath.jsonpath(obj, '$..book[(@.length-1)]')

# 获取前两本书
# first_two_book = jsonpath.jsonpath(obj, '$..book[0,1]')
first_two_book = jsonpath.jsonpath(obj, '$..book[:2]')

# 获取带 isbn 标签的书
filter_book = jsonpath.jsonpath(obj, '$..book[?(@.isbn)]')

# 获取价格大于 10 的书
up_ten_book = jsonpath.jsonpath(obj, '$..book[?(@.price > 10)]')

print(up_ten_book)


