package StringJoiner;

import java.util.StringJoiner;

public class SpliceSting {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};

        System.out.println(toString(arr));
    }

    // 把字符串数组拼接成一个字符串的方法
    public static String toString(String[] arr){
        // 创建StringJoiner对象，指定间隔符为", "，开头为"["，结尾为"]"
        StringJoiner sj = new StringJoiner(", ", "[", "]");

        // 将数组中的元素一一拼接
        for (int i = 0; i < arr.length; i++) {
            sj.add(arr[i]);
        }

        // 转为字符串返回
        return sj.toString();
    }
}
