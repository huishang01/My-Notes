import scrapy


class TongchengSpider(scrapy.Spider):
    name = "tongcheng"
    allowed_domains = ["yongzhou.58.com"]
    start_urls = [
        "https://yongzhou.58.com/sou/?key=%E5%89%8D%E7%AB%AF&classpolicy=uuid_M7Q5ytNrhcSSYaTQJbjmPNPW65cM2TCx%2Cclassify_B&search_uuid=M7Q5ytNrhcSSYaTQJbjmPNPW65cM2TCx&search_type=input"]

    def parse(self, response):
        # 返回字符串数据
        # content1 = response.text
        # print()
        # print('======================================================================')
        # print()
        # print(content1)

        # 返回二进制数据
        # content2 = response.body
        # print()
        # print('======================================================================')
        # print()
        # print(content2)

        # 使用 xpath 定位元素
        span = response.xpath('//*[@id="filter"]/div[1]/a[1]/span')
        print()
        print('======================================================================')
        print()

        # 获取 span 里的内容
        print(span.extract())  # 提取selector对象data的属性值
        print(span.extract_first())  # 提取selector列表的第一个数据
