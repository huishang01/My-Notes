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

public class RomanNumeralsCase2 {
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            sb.append(RomanNumerals(number.charAt(i)));
        }
        System.out.println(sb);
    }

    // 把数字转换成罗马数字的方法
    public static String RomanNumerals(char number) {
        // 创建一个数组存储罗马数字符号
        // Ⅰ－1、Ⅱ－2、Ⅲ－3、Ⅳ－4、Ⅴ－5、Ⅵ－6、Ⅶ－7、Ⅷ－8、Ⅸ－9
        return switch (number) {
            case '0' -> "";
            case '1' -> "Ⅰ";
            case '2' -> "Ⅱ";
            case '3' -> "Ⅲ";
            case '4' -> "Ⅳ";
            case '5' -> "Ⅴ";
            case '6' -> "Ⅵ";
            case '7' -> "Ⅶ";
            case '8' -> "Ⅷ";
            case '9' -> "Ⅸ";
            default -> "";
        };
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
