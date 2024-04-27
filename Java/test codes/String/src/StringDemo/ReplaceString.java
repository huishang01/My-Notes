package StringDemo;

public class ReplaceString {
    public static void main(String[] args) {
        // 获取字符串
        String talk = "学校给的sb凳子tmd小木凳，坐得屁股疼还没靠背";

        // 定义一个敏感词库
        String[] arr = {"tmd", "cnm", "mlgb", "sb"};

        // 将字符串中的关键字替换为星号
        for (int i = 0; i < arr.length; i++) {
            talk = talk.replace(arr[i], "***");
        }

        // 打印替换后的结果
        System.out.println(talk);
    }
}
