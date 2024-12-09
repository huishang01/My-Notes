from selenium import webdriver

path = 'chromedriver-win64/chromedriver.exe'

browser = webdriver.Chrome()

url = 'https://www.jd.com'

browser.get(url)

input()

content = browser.page_source

print(content)
