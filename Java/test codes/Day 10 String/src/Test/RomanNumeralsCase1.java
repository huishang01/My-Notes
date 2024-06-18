package Test;

        /*键盘录入一个字符串，
        要求1：长度为小于等于9
        要求2：只能是数字
        将内容变成罗马数字
        下面是阿拉伯数字跟罗马数字的对比关系：
        Ⅰ－1、Ⅱ－2、Ⅲ－3、Ⅳ－4、Ⅴ－5、Ⅵ－6、Ⅶ－7、Ⅷ－8、Ⅸ－9
        注意点：
        罗马数字里面是没有0的
        如果键盘录入的数字包含0，可以变成""(长度为0的字符串)*/

import java.util.Scanner;
import java.util.StringJoiner;

public class RomanNumeralsCase1 {
    public static void main(String[] args) {
        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        String number;
        System.out.println("请输入一个字符串：");

        // 判断字符串是否符合要求
        while (true) {
            number = sc.nextLine();
            if (judgmentStr(number)) {
                break;
            } else {
                System.out.println("字符串不合法，请重新输入：");
            }
        }

        // 打印转换后的罗马数字
        System.out.println(RomanNumerals(number));
    }

    // 把数字转换成罗马数字的方法
    public static String RomanNumerals(String number) {
        // 创建一个数组存储罗马数字符号
        String[] romanNumerals = {"", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ"};

        // 创建StringJoiner对象用来拼接成罗马数字
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < number.length(); i++) {
            int c = number.charAt(i) - 48;
            sj.add(romanNumerals[c]);
        }
        return sj.toString();
    }

    // 判断字符串是否符合要求的方法
    public static boolean judgmentStr(String number) {
        // 要求1：长度为小于等于9
        if (number.length() > 9) {
            return false;
        }

        // 要求2：只能是数字
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
