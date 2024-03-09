package test;

import java.util.Scanner;

/*
机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。 按照如下规则计算机票价格:
旺季(5-10月)头等舱9折，经济舱8.5折， 淡季(11月到来年4月)头等舱7折，经济舱6.5折。
*/


public class Test1 {
    public static void main(String[] args) {
        // 键盘录入机票原价、月份、舱位
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票的原价：");
        int tickit = sc.nextInt();
        System.out.println("请输入当前的月份：");
        int month = sc.nextInt();
        System.out.println("请输入购买的舱位（头等舱为 0 ，经济舱为 1 ）：");
        int seat = sc.nextInt();

        // 判断月份的淡旺季
        if (month >= 5 && month <= 10) {
            // 旺季的折扣
            tickit = getPrice(tickit, seat, 0.9, 0.85);
        } else {
            // 淡季折扣
            tickit = getPrice(tickit, seat, 0.7, 0.65);
        }
        System.out.println("您需要支付的金额为：" + tickit);
    }

    // 用方法实现根据舱位选择折扣
    public static int getPrice(int tickit, int seat, double v0, double v1) {
        switch (seat) {
            case 0:
                tickit = (int) (tickit * v0);
                break;
            case 1:
                tickit = (int) (tickit * v1);
                break;
        }
        return tickit;
    }
}
