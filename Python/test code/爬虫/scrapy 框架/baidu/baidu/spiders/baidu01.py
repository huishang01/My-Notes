import scrapy


class Baidu01Spider(scrapy.Spider):
    name = "baidu01"
    allowed_domains = ["www.baidu.com"]
    start_urls = ["https://www.baidu.com/"]

    def parse(self, response):
        print('这是百度')

