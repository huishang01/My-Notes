# 导包
import urllib.request

# 定义网页 URL
url = "https://www.baidu.com/"

# 下载网页源码
urllib.request.urlretrieve(url=url, filename="baidu.html")

# 定义图片 URL
url_img = "https://img.moegirl.org.cn/common/0/04/Bangdreamgdp4th.jpg"

# 下载图片
urllib.request.urlretrieve(url=url_img, filename="bangdream.jpg")

# 定义视频 URL
url_video = "https://vdept3.bdstatic.com/mda-kikph1r9mw6itkhk/v1-cae/mda-kikph1r9mw6itkhk.mp4?v_from_s=hkapp-haokan-hnb&auth_key=1721709279-0-0-1de6238ef771568b382a334cdf93ef89&bcevod_channel=searchbox_feed&cr=0&cd=0&pd=1&pt=3&logid=2078779992&vid=17284216555185208768&klogid=2078779992&abtest="

# 下载视频
urllib.request.urlretrieve(url=url_video, filename="剧场版《BanG Dream! FILM LIVE 2nd Stage》先导影片 2021年上映.mp4")

