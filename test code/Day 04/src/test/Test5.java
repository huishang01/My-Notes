package test;

import java.util.Scanner;

/*
从键盘输入两个整数a,b，统计在a,b范围内（包含a,b）同时被3和被5整除的数据个数
 */

public class Test5 {
    public static void main(String[] args) {
        // 键盘录入两个数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字表示范围的开始：");
        int start = sc.nextInt();
        System.out.println("请输入第二个数字表示范围的结束：");
        int end = sc.nextInt();
        // 统计变量
        int count = 0;
        // 利用循环获取范围内的每一个数字
        for (int i = start; i <= end; i++) {
            // 判断每一个数字，满足既能被3整除又能被5整除
            if (i % 3 == 0 && i % 5 == 0) {
                // 被整除一次temp + 1
                count++;
            }
        }
        // 输出结果
        System.out.println("既能被3整除又能被5整除有 " + count + " 个");
    }
}
