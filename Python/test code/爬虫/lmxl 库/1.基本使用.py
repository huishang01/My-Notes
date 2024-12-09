from lxml import etree

html_etree = etree.parse('1.基本使用.html')
print(html_etree)

li_list = html_etree.xpath('//li[@id]/text()')
print(li_list)
print(len(li_list))

m10 = html_etree.xpath('//li[@id="m10"]/text()')
print(m10)

s2 = html_etree.xpath('//li[@class="s2"]/text()')
print(s2)

m12 = html_etree.xpath('//li[@id="m12"]/@class')
print(m12)

contains = html_etree.xpath('//li[contains(@id, "11")]/text()')
print(contains)
print(len(contains))

starts_with = html_etree.xpath('//li[starts-with(@id, "d")]/text()')
print(starts_with)
print(len(starts_with))

ands = html_etree.xpath('//li[@id="m13" and @class="s2"]/text()')
print(ands)

ors = html_etree.xpath('//li[@id="m10"]/text() | //li[@id="m12"]/text()')
print(ors)
