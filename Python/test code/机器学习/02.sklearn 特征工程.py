from sklearn.feature_extraction import DictVectorizer


def dict_demo():
    """
    字典特征抽取
    :return:
    """
    data = [
        {'city': '北京', 'temperature': 100},
        {'city': '上海', 'temperature': 60},
        {'city': '深圳', 'temperature': 30},
    ]

    # 1. 实例化一个转换器类
    transfer = DictVectorizer(sparse=False)

    # 2. 调用 fit_transform()
    data_new = transfer.fit_transform(data)

    print('data_new: \n', data_new)
    print('特征名字: \n', transfer.get_feature_names_out())

    return None


if __name__ == '__main__':
    dict_demo()
