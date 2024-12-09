# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter


class MovieHeavenPipeline:
    def open_spider(self, spider):
        self.f = open('movie.json', 'w', encoding='utf-8')

    def process_item(self, item, spider):
        self.f.write(str(item))

    def close_sipider(self, spider):
        self.f.close()
