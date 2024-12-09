"""
股票计算小程序
"""

name = "迪士尼" # 公司名
stock_price = 19.99 # 当前股价
stock_code = "003032" # 股票代码
stock_price_daily_growth_factor = 1.2 # 股票每日增长系数
growth_days = 7 # 增长天数

result1 = f"公司：{name}，股票代码：{stock_code}，当前股价：{stock_price}"

result2 = "每日增长系数是：%.1f，经过%d天后，股价达到了：%.2f" % (stock_price_daily_growth_factor, growth_days, stock_price * stock_price_daily_growth_factor ** 7)

print(result1)
print(result2)