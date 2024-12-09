from selenium import webdriver
from selenium.webdriver.common.by import By

browser = webdriver.Chrome()

browser.get('https://www.baidu.com')

# 根据 ID 获取标签
inputs = browser.find_element(By.ID, 'su')

# 根据标签属性的属性名获取属性值
print(inputs.get_attribute('value'))

# 获取标签名
print(inputs.tag_name)

# 根据 超链接标签 的内容获取 标签
a = browser.find_element(By.LINK_TEXT, '图片')

# 获取标签的内容
print(a.text)
