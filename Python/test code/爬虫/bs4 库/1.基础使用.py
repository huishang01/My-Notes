from bs4 import BeautifulSoup

soup = BeautifulSoup(open('1.基础使用.html', encoding='utf-8'), 'lxml')

# 返回第一个符合条件的标签
# print(soup.a)
# 返回标签的属性和属性值
# print(soup.a.attrs)

# find()：返回第一个符合条件的标签
# 可以根据属性来查找
# print(soup.find('a', title="杀手寓言"))
# class 需要添加下划线
# print(soup.find('a', class_='an-text', title="影之诗F 方舟篇"))

# find_all：返回包含了所有符合条件的标签的列表
# print(soup.find_all('a'))
# 多个标签需放到列表里传递
# print(soup.find_all(['a', 'span']))
# limit：查找前几个的数据
# print(soup.find_all('li', limit=2))

# select：返回包含了所有符合条件的标签的列表
# print(soup.select('a'))
# 通过类来查找（类选择器）
# print(soup.select('.an-text'))
# 通过 id 来查找（id 选择器）
# print(soup.select('#no1'))

# 属性选择器：查找包含该属性的该标签的列表
# print(soup.select('div[id]'))
# 也可以指定属性的值
# print(soup.select('div[id="no2"]'))

# 层级选择器
#   后代选择器：返回父标签下的所有标签的列表
# print(soup.select('li a'))
#   子代选择器：返回父标签下的子标签的列表
# print(soup.select('li>div>a'))
#   同级选择器：返回包含两个标签的所有内容的列表
# print(soup.select('a, span'))

# 获取标签内容
# obj = soup.select('li div')[-1]
# 若标签里还包含其他标签，string 就获取不到内容
# print(obj.string)
# 而 get_text() 都可以获取内容
# print(obj.get_text())

obj = soup.select('.an-text')[0]
# 通过属性值获取标签名
# print(obj.name)
# 将属性值作为字典返回
# print(obj.attrs)
# 通过属性名获取属性值
# print(obj.attrs.get('class'))
# print(obj.get('class'))
# print(obj['class'])
