# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter
from scrapy.utils.project import get_project_settings
import pymysql


class ReadbookPipeline:
    def openspider(self, spider):
        self.f = open('readbook.json', 'w', encoding='utf-8')

    def process_item(self, item, spider):
        self.f.write(str(item))
        return item

    def closespider(self, spider):
        self.f.close()


class MysqlPipeline:
    def openspider(self, spider):
        settings = get_project_settings()
        self.host = settings['DB_HOST']
        self.port = settings['DB_PORT']
        self.user = settings['DB_USER']
        self.password = settings['DB_PASSWORD']
        self.name = settings['DB_NAME']
        self.charset = settings['DB_CHARSET']

        self.connect()

    def connect(self, spider):
        self.conn = pymysql.connect(
            host=self.host,
            port=self.port,
            user=self.user,
            password=self.password,
            db=self.name,
            charset=self.charset
        )

        self.cursor = self.conn.cursor()

    def process_item(self, item, spider):
        sql = 'insert into books(name, src) values("{}", "{}")'.format(item['name'], item['src'])
        # 执行 SQL 语句
        self.cursor.execute(sql)
        # 提交
        self.conn.commit()

        return item

    def closespider(self, spider):
        self.cursor.close()
        self.conn.close()
