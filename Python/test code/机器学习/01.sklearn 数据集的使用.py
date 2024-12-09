from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split


def datasets_demo():
    """
    sklearn 数据集的使用
    :return:
    """

    # 获取数据集
    iris = load_iris()
    print("鸢尾花数据集：\n", iris)
    print("查看数据集描述：\n", iris['DESCR'])
    print('查看特征值的名字：\n', iris.feature_names)
    print('查看特征值：\n', iris.data, iris.data.shape)

    # 数据集的划分
    # return：训练集的特征值，测试集的特征值，训练集的目标值，测试集的目标值
    # 特征值，目标值，测试集范围，随机数种子
    x_train, x_test, y_train, y_test = train_test_split(iris.data, iris.target, test_size=0.2, random_state=22)
    print('训练集的特征值：\n', x_train, x_train.shape)
    print('测试集的特征值：\n', x_test, x_test.shape)
    print('训练集的目标值：\n', y_train, y_train.shape)
    print('测试集的目标值：\n', y_test, y_test.shape)

    return None


if __name__ == '__main__':
    datasets_demo()
