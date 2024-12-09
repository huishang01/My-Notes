from selenium import webdriver
from selenium.webdriver.common.by import By
import time

browser = webdriver.Chrome()

browser.get('https://www.baidu.com')

time.sleep(1)  # 睡眠 2s

inputs = browser.find_element(By.ID, 'kw')  # 选中文本框

inputs.send_keys('Steam')  # 输入 Steam

button = browser.find_element(By.ID, 'su')  # 选中搜索按钮

button.click()  # 点击搜索

time.sleep(2)  # 睡眠 2s

js_bottom = 'document.documentElement.scrollTop=100000'
browser.execute_script(js_bottom)  # 滑倒底部

time.sleep(2)  # 睡眠 2s

next_page = browser.find_element(By.XPATH, '//a[@class="n"]')
next_page.click()  # 点击下一页

browser.execute_script(js_bottom)  # 滑倒底部

time.sleep(2)  # 睡眠 2s

browser.back()  # 返回上一级

time.sleep(2)  # 睡眠 2s

browser.forward()  # 回到前一页

time.sleep(3)  # 睡眠 3s

browser.quit()


