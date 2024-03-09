package test;

import java.util.Scanner;

// 根据票号奇偶判断座位左右

public class Test1 {
    public static void main(String[] args) {
        // 键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的票号：");
        int ticket = sc.nextInt();
        // 判断范围1~100
        if (ticket >= 1 && ticket <= 100) {
            // 判断奇偶
            if (ticket % 2 == 1) {
                System.out.println("您的票号为奇数，请坐左边。");
            } else {
                System.out.println("您的票号为偶数，请坐右边。");
            }
        } else {
            System.out.println("您的票号不合法！");
        }
    }
}
