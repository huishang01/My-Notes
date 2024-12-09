import scrapy


class CarrankSpider(scrapy.Spider):
    name = "carrank"
    allowed_domains = ["www.autohome.com.cn"]
    start_urls = ["https://www.autohome.com.cn/rank/1"]

    def parse(self, response):
        content = response.text
        with open('1.html', 'w', encoding='utf-8') as f:
            f.write(content)

        print('==============================================================================')
        car_name_list = response.xpath('//div[@class="infinite-scroll-component "]//div[@class="tw-text-nowrap tw-text-lg tw-font-medium hover:tw-text-[#ff6600]"]/text()')

        for i in len(car_name_list):
            print(car_name_list[i])
        print('==============================================================================')

        # xpath 解析，获取车价的列表
        car_price_list = response.xpath('//div[@class="infinite-scroll-component"]//div[@class=" tw-font-medium tw-text-[#717887]"]')

        print(car_price_list)

        for price in car_price_list:
            print(price)
        print('==============================================================================')
