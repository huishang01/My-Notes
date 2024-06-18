package Test;

// 请编写程序，由键盘录入一个字符串，统计字符串中大小写英文字母和数字分别有多少个。
// 比如：Hello12345World中字母：10个，数字：5个。

import java.util.Scanner;

public class CountLetter {
    public static void main(String[] args) {
        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();

        // 定义计数器来统计各个字符的数量
        int countUppercase = 0;
        int countLowercase = 0;
        int countNumber = 0;
        int countLetter = 0;

        // 遍历字符串，得到每个字符，然后调用方法进行字符类型判断
        for (int i = 0; i < str.length(); i++) {
            // 大写字母数量
            if (isUppercase(str.charAt(i))) {
                countUppercase++;
            }

            // 小写字母数量
            if (isLowercase(str.charAt(i))){
                countLowercase++;
            }

            // 数字数量
            if (isNumber(str.charAt(i))){
                countNumber++;
            }

            // 字母数量
            if (isLetter(str.toLowerCase().charAt(i))) {
                countLetter++;
            }
        }

        // 输出结果
        System.out.println("大写字母有" + countUppercase + "个");
        System.out.println("小写字母有" + countLowercase + "个");
        System.out.println("数字有" + countNumber + "个");
        System.out.println("字母有" + countLetter + "个");
    }

    // 判断字母的方法
    public static boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }

    // 判断大写字母的方法
    public static boolean isUppercase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    // 判断小写字母的方法
    public static boolean isLowercase(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }

    // 判断数字的方法
    public static boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
