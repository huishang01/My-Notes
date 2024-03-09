package test;

import java.util.Scanner;

/*
输入一个数，判断该数是不是回文数
 */

public class Test7 {
    public static void main(String[] args) {
        // 键盘录入一个数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int x = sc.nextInt();    // 1234  123  12  1
        // 存储x用于最后比较
        int temp = x;    // 1234
        // 记录倒数
        int y = 0;    // 0  4  43  432
        // 获取每一位数字
        while (x != 0) {
            // 获取个位数
            int ge = x % 10;    // 4  3  2  1
            // 删除x的个位，减少一位数
            x = x / 10;    // 123  12  1  0
            // 获取的数字拼接到右边
            y = y * 10 + ge;    // 4  43  432  4321
        }
        // 输出倒数
        System.out.println(y);    // 4321
        // 判断该数是否为回文数
        System.out.println(temp == y);    // false
    }
}
