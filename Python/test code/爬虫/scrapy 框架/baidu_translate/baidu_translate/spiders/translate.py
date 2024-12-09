from typing import Iterable

import scrapy
from scrapy import Request
import json


class TranslateSpider(scrapy.Spider):
    name = "translate"
    allowed_domains = ["fanyi.baidu.com"]
    start_urls = ["https://fanyi.baidu.com/sug"]

    def parse(self, response):
        pass

    def start_requests(self):
        url = "https://fanyi.baidu.com/sug"

        data = {
            'kw': 'translate'
        }

        yield scrapy.FormRequest(url=url, formdata=data, callback=self.parse2)

    def parse2(self, response):
        content = response.text
        obj = json.loads(content, encoding='utf-8')

        print(obj)

