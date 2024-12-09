# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class DangdangItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()

    src = scrapy.Field()  # /a/img/@src
    name = scrapy.Field  # //ul[@id="component_59"]/li/p[@name="title"]/a/text()
    price = scrapy.Field()  # //ul[@id='component_59']/li/p[@class='price']/span[@class='search_now_price']/text()
