from sklearn.feature_extraction.text import CountVectorizer
import jieba


def count_cn_demo():
    """
    中文文本特征抽取 CountVectorizer()
    统计每个样本特征词出现的次数
    :return:
    """
    data = ['「请别在意。我是旅人，得继续旅行才行。」',
            '某个地方有个正在旅行的魔女，她的名字是伊蕾娜。',
            '身为旅人，在很长很长的旅途中，她与形形色色的国家与人们邂逅。',
            '只允许魔法师入境的国家、最喜欢肌肉的壮汉、在死亡深渊等待恋人归来的青年、独自留守国家早已灭亡的公主，最后，还有她身为魔女的至今为止与从今以后。',
            '和莫名其妙、滑稽可笑的人们相遇，接触某人美丽的日常生活，魔女日复一日编织出相逢与离别的故事。']

    # 将中文文本进行分词
    data_new = []
    for sent in data:
        data_new.append(cut_word(sent))
    # print(data_new)

    # 实例化一个转换器类
    transfer = CountVectorizer(stop_words=['为止', '从今以后', '允许', '入境', '喜欢', '才行'])

    # 调用 fit_transform() 方法
    data_final = transfer.fit_transform(data_new)

    print('data_final:\n', data_final.toarray())
    print('特征名字：\n', transfer.get_feature_names_out())
    return None


def cut_word(text):
    """
    进行中文分词 '我爱北京天安门' => '我 爱 北京 天安门'
    jieba.cut(text)
    :param text: str
    :return: str
    """
    # 分词后强转成列表，然后拼接成间隔为空格的字符串
    text = ' '.join(list(jieba.cut(text)))
    return text


if __name__ == '__main__':
    count_cn_demo()
    # print(cut_word('我爱北京天安门'))
