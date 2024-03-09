package test;

import java.util.Scanner;

// 根据成绩判断礼物

public class Test2 {
    public static void main(String[] args) {
        // 键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入成绩：");
        int score = sc.nextInt();
        // 确定成绩范围
        if (score >= 0 && score <= 100) {
            // 判断成绩以确定奖励
            if (score >= 95 && score <= 100) {
                System.out.println("送自行车一辆");
            } else if (score >= 90 && score <= 94) {
                System.out.println("游乐场玩一天");
            } else if (score >= 80 && score <= 89) {
                System.out.println("送变形金刚一个");
            } else {
                System.out.println("揍一顿");
            }
        } else {
            System.out.println("成绩不合法！");
        }
    }
}
