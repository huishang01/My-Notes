package test;

import java.util.Scanner;

/*
求平方根（如果为小数，只取整数部分）
 */

public class Test2 {
    public static void main(String[] args) {
        // 录入整数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        // 获取1-num之间的所有整数
        for (int i = 1; i <= num; i++) {
            // 如果i^2=num，那么i就是num的平方根
            if (i * i == num) {
                System.out.println(i + " 是 " + num + " 的平方根");
                // 满足条件就结束循环
                break;
            } else if (i * i > num) {     // 如果i^2>num，那么i的前一个数就是num的平方根的整数部分
                System.out.println(i - 1 + " 是 " + num + " 的平方根的整数部分");
                // 满足条件就结束循环
                break;
            }
        }
    }
}
