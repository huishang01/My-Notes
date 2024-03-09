package test;

import java.util.Scanner;

/*
判断质数
 */

public class Test3 {
    public static void main(String[] args) {
        // 键盘录入一个整数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        // 标记num是否为质数
        boolean flag = true;
        // 获取2到num-1的所有数字进行判断
        for (int i = 2; i < num; i++) {
            // 如果num能被i整数，那么num不是质数
            if (num % i == 0) {
                // 如果num不是质数，那么flag标记为false
                flag = false;
                // 判断完毕结束循环
                break;
            }
        }
        // 如果flag标记为true，那么num是质数
        if (flag) {
            System.out.println(num + " 是质数");
        } else {
            System.out.println(num + " 不是质数");
        }
    }
}
