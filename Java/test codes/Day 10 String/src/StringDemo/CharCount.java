package StringDemo;

import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = sc.nextLine();

        // 遍历字符串中的字符
        int smallCount = 0;
        int bigCount = 0;
        int numberCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 对字符类型进行判断，并统计
            if (c >= 'a' && c <= 'z') {
                smallCount++;
            } else if (c >= 'A' && c <= 'Z') {
                bigCount++;
            } else if (c >= '0' && c <= '9') {
                numberCount++;
            }
        }

        // 输出各个字符类型的数量
        System.out.println("小写字母有 " + smallCount + " 个");
        System.out.println("大写字母有 " + bigCount + " 个");
        System.out.println("数字有 " + numberCount + " 个");
    }
}
