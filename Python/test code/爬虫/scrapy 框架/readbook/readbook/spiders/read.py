import scrapy
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule


class ReadSpider(CrawlSpider):
    name = "read"
    allowed_domains = ["www.dushu.com"]
    start_urls = ["https://www.dushu.com/book/1617_1.html"]
    # follow 跟进
    rules = (Rule(LinkExtractor(allow=r"/book/1617_\d+\.html"), callback="parse_item", follow=True),)

    def parse_item(self, response):
        item = {}
        img_list = response.xpath('//div[@class="bookslist"]//img')

        for img in img_list:
            src = img.xpath('./@data-original').extract_first()
            name = img.xpath('./@alt').extract_first()

            print(name, src)

        #item["domain_id"] = response.xpath('//input[@id="sid"]/@value').get()
        #item["name"] = response.xpath('//div[@id="name"]').get()
        #item["description"] = response.xpath('//div[@id="description"]').get()
        return item
