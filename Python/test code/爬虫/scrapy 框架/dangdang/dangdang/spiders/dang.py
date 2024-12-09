import scrapy
from dangdang.items import DangdangItem


class DangSpider(scrapy.Spider):
    name = "dang"
    # 如果是多页下载，allowed_domains 一般只写域名
    allowed_domains = ["category.dangdang.com"]
    start_urls = ["http://category.dangdang.com/cp01.01.00.00.00.00.html"]

    base_url = 'http://category.dangdang.com/pg'
    page = 1

    def parse(self, response):
        li_list = response.xpath('//ul[@id="component_59"]/li')

        src_list = []
        name_list = []
        price_list = []

        for li in li_list:
            # 图片
            src = li.xpath('./a/img/@data-original')
            if src:
                src = src
            else:
                src = li.xpath('.//a/img/@src')

            # 书名
            name = li.xpath('.//p[@name="title"]/a/text()')

            # 价格
            price = li.xpath('.//p[@class="price"]/span[@class="search_now_price"]/text()')

            book = DangdangItem(src=src, name=name, price=price)

            print(book)

            # yield 迭代器
            yield book

        if self.page < 100:
            self.page += 1
            url = self.base_url + str(self.page) + '-cp01.01.00.00.00.00.html'
            # scrapy.Request() 是 scrapy 的 get 请求
            # callback 是要执行的函数
            yield scrapy.Request(url=url, callback=self.parse)
