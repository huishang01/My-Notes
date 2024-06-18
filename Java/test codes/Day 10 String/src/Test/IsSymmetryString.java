package Test;

// 请定义一个方法用于判断一个字符串是否是对称的字符串，并在主方法中测试方法。
// 例如："abcba"、"上海自来水来自海上"均为对称字符串。

import java.util.Scanner;

public class IsSymmetryString {
    public static void main(String[] args) {
        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();

        if (isSymmetryString(str)) {
            System.out.println("该字符串是对称字符串。");
        } else {
            System.out.println("该字符串不是对称字符串。");
        }
    }

    // 判断一个字符串是否是对称的字符串的方法
    public static boolean isSymmetryString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.toString().contentEquals(sb.reverse());
    }
}
