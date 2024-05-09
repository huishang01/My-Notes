package Test;

// 我国的居民身份证号码，由由十七位数字本体码和一位数字校验码组成。
// 请定义方法判断用户输入的身份证号码是否合法，并在主方法中调用方法测试结果。
// 规则为：号码为18位，不能以数字0开头，前17位只可以是数字，最后一位可以是数字或者大写字母X。

import java.util.Scanner;

public class IsIdValid {
    public static void main(String[] args) {
        // 键盘录入一个身份证号码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个身份证号码：");
        String id = sc.nextLine();

        if (isIdValid(id)) {
            System.out.println("该身份证号合法");
        } else {
            System.out.println("该身份证号不合法");
        }
    }

    // 判断用户输入的身份证号码是否合法的方法
    public static boolean isIdValid(String id) {
        // 判断号码长度是否为18位
        if (id.length() != 18) {
            return false;
        }

        // 判断号码开头是否为数字0
        if (id.charAt(0) == '0') {
            return false;
        }

        // 判断号码前17位是否为数字
        for (int i = 0; i < 17; i++) {
            if (id.charAt(i) < '0' || id.charAt(i) > '9') {
                return false;
            }
        }

        // 判断号码最后一位是否为数字或者大写字母X
        char lastChar = id.charAt(17);
        if (!Character.isDigit(lastChar) && lastChar != 'X') {
            return false;
        }

        return true;
    }
}
