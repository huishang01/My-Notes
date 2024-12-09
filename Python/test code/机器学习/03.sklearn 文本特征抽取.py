from sklearn.feature_extraction.text import CountVectorizer


def count_demo():
    """
    文本特征抽取 CountVectorizer()
    统计每个样本特征词出现的次数
    :return:
    """
    data = ['life is short, i like like python', 'life is too long, i dislike python']

    # 实例化一个转换器类  stop_words: 停用词
    transfer = CountVectorizer(stop_words=['is', 'too'])

    # 调用 fit_transform() 方法
    data_new = transfer.fit_transform(data)

    print('data_new:\n', data_new.toarray())
    print('特征名字：\n', transfer.get_feature_names_out())
    return None


def count_cn_demo():
    """
    中文文本特征抽取 CountVectorizer()
    统计每个样本特征词出现的次数
    :return:
    """
    data = ['我 爱 北京 天安门', '天安门 上 太阳 升']

    # 实例化一个转换器类
    transfer = CountVectorizer()

    # 调用 fit_transform() 方法
    data_new = transfer.fit_transform(data)

    print('data_new:\n', data_new.toarray())
    print('特征名字：\n', transfer.get_feature_names_out())
    return None


if __name__ == '__main__':
    # 文本特征抽取
    count_demo()
    # 中文文本特征抽取
    # count_cn_demo()
