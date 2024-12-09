# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
import urllib.request


class DangdangPipeline:
    def open_spider(self, spider):
        self.f = open('book.json', 'a', encoding='utf-8')

    def process_item(self, item, spider):
        # 模式一 该模式对文件操作过于频繁
        #     1. write 比如传递一个字符串，而非其他对象
        #     2. w 模式下每个对象都会打开一次文件，覆盖之前的内容
        # with open('book.json', 'a', encoding='utf-8') as f:
        #     f.write(str(item))

        # 模式二
        self.f.write(str(item))

        return item

    def close_spider(self, spider):
        self.f.close()

# 多条管道开启
#     1. 定义管道类
#     2. 在 settings 开启管道
#        "dangdang.pipelines.DangDangDownloadPipeline": 301
class DangDangDownloadPipeline:
    def process_item(self, item, spider):
        url = 'https' + item.get('src')
        filename = './books' + item.get('name') + '.jpg'
        urllib.request.urlretrieve(url=url, filename=filename)

        return item



