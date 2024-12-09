from selenium import webdriver
from selenium.webdriver.common.by import By

#  创建浏览器对象
browser = webdriver.Chrome()

# 发送请求获取响应
browser.get('http://www.baidu.com')

# 根据 ID 查找标签
# button = browser.find_element(By.ID, 'su')

# 根据标签的属性值查找标签
# button = browser.find_element(By.NAME, 'wd')

# 根据 XPATH 查找标签返回列表
# button = browser.find_elements(By.XPATH, '//input[@id="su"]')

# 根据标签名查找标签返回列表
# button = browser.find_elements(By.TAG_NAME, 'input')

# 根据 bs4 查找标签返回列表
# button = browser.find_elements(By.CSS_SELECTOR, '#su')

# 根据超链接标签内容查找标签返回列表
button = browser.find_elements(By.LINK_TEXT, '图片')

print(button)
