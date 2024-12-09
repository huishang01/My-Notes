import scrapy
from movie_heaven.items import MovieHeavenItem


class MovieSpider(scrapy.Spider):
    name = "movie"
    allowed_domains = ["btwuji.com"]
    start_urls = ["https://btwuji.com/html/gndy/china/index.html"]

    def parse(self, response):
        a_list = response.xpath('//div[@class="co_content8"]//td[2]//a[2]')

        for a in a_list:
            src = 'https://btwuji.com/' + a.xpath('./@href').extract_first()
            name = a.xpath('./text()').extract_first()

            # mete 传递变量
            yield scrapy.Request(url=src, callback=self.parse2, meta={'name': name})

    def parse2(self, response):
        img = response.xpath('//div[@id="Zoom"]//img/@src').extract_first()

        # 接收变量
        name = response.meta['name']

        movie = MovieHeavenItem(img, name)

        yield movie
# '//div[@class='co_content8']/ul/table[@class='tbspan']/tbody/tr[2]/td[2]/b/a[2]/@href'
# 'https://btwuji.com/'
