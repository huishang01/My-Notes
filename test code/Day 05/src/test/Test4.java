package test;

/*
猜数字小游戏
（系统自动生成一个数据（100以内），每次从键盘输入猜的数字，并提示大了还是小了，直到猜中为止。

随机获取任意数a ~ 任意数b公式：
int num = r.nextInt( 100 ) + 1;
                      |      |
                      x      y
    X = b - a + 1
    Y = |0 - a|
 */

import java.util.Random;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        // 创建键盘录入和随机数的对象
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        // 游戏标题
        System.out.println("猜数字(1~100)小游戏");
        // 用if判断是否开始游戏
        System.out.println("按 1 开始游戏，按其他数字退出游戏");
        int start = sc.nextInt();
        if (start == 1) {
            System.out.println("游戏开始，随机数已给出，你有 5 次机会");
            // 获取一个1~100之间的随机数
            int num = r.nextInt(100) + 1;
            // 统计猜的次数
            int count = 0;
            // 使用while循环来实现猜数字游戏
            while (true) {
                // 录入猜的数字
                System.out.println("请输入你要猜的数：");
                int guessNum = sc.nextInt();
                // 判断猜的数字是否正确
                if (guessNum > num) {
                    // 提示大于答案
                    System.out.println();
                    System.out.println("大了");
                } else if (guessNum < num) {
                    // 提示小于答案
                    System.out.println();
                    System.out.println("小了");
                } else {
                    // 提示猜中并结束循环
                    System.out.println();
                    System.out.println("猜中了");
                    System.out.println("游戏结束");
                    break;
                }
                // 猜一次就计一次数
                count++;
                // 提示剩余次数
                System.out.println("你还剩 " + (5 - count) + " 次机会");
                // 如果猜了5次还没猜中就给出答案并结束循环
                if (count == 5) {
                    System.out.println("杂鱼别猜了，答案是 " + num);
                    System.out.println("游戏结束");
                    break;
                }
            }
        } else {
            System.out.println("游戏已退出");
        }
    }
}
