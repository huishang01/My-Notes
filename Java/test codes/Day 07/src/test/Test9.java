package test;

import java.util.Random;
import java.util.Scanner;

// 双色球算法

public class Test9 {
    public static void main(String[] args) {
        System.out.println("和真双色球");
        System.out.println("====================================");
        int[] arr = creatNum();
        System.out.println("中奖号码为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        System.out.println("====================================");
        int[] userArr = userNum();
        System.out.println();
        System.out.println("用户输入号码为：");
        for (int i = 0; i < userArr.length; i++) {
            System.out.print(userArr[i] + "  ");
        }
        System.out.println();
        System.out.println("====================================");
        int countRed = 0;
        int countBlue = 0;
        // 判断红球
        for (int i = 0; i < userArr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] == userArr[i]) {
                    countRed++;
                    break;
                }
            }
        }
        // 判断蓝球
        if (userArr[userArr.length - 1] == arr[arr.length - 1]) {
            countBlue++;
        }
        System.out.println("红球中将数为：" + countRed);
        System.out.println("蓝球中将数为：" + countBlue);
        // 判断中将
        if (countRed == 6 && countBlue == 1) {
            System.out.println("恭喜你中了一等奖！");
        } else if (countRed == 6 && countBlue == 0) {
            System.out.println("恭喜你中了二等奖！");
        } else if (countRed == 5 && countBlue == 1) {
            System.out.println("恭喜你中了三等奖！");
        } else if ((countRed == 5 && countBlue == 0) || (countRed == 4 && countBlue == 1)) {
            System.out.println("恭喜你中了四等奖！");
        } else if ((countRed == 4 && countBlue == 0) || (countRed == 3 && countBlue == 1)) {
            System.out.println("恭喜你中了五等奖！");
        } else if ((countRed == 2 && countBlue == 1) || (countRed == 1 && countBlue == 1) || (countRed == 0 && countBlue == 1)) {
            System.out.println("恭喜你中了六等奖！");
        } else {
            System.out.println("谢谢惠顾！");
        }
    }

    // 获取用户输入号码
    public static int[] userNum() {
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length - 1; ) {
            System.out.print("请输入第" + (i + 1) + "个红球号码：");
            int redNum = sc.nextInt();
            if (redNum >= 1 && redNum <= 33) {
                boolean flag = contains(arr, redNum);
                if (!flag) {
                    arr[i] = redNum;
                    i++;
                } else {
                    System.out.println("号码重复，请重新输入！");
                }
            } else {
                System.out.println("号码超出范围，请重新输入！");
            }
        }
        while (true) {
            System.out.print("请输入蓝球号码：");
            int blueNum = sc.nextInt();
            if (blueNum >= 1 && blueNum <= 16) {
                arr[arr.length - 1] = blueNum;
                break;
            } else {
                System.out.println("号码超出范围，请重新输入！");
            }
        }
        return arr;
    }

    // 获取中奖号码
    public static int[] creatNum() {
        int[] arr = new int[7];

        // 获取红球号码
        Random r = new Random();
        for (int i = 0; i < arr.length - 1; ) {
            int redNum = r.nextInt(33) + 1;
            boolean flag = contains(arr, redNum);
            if (!flag) {
                arr[i] = redNum;
                i++;
            }
        }
        // 获取蓝球号码
        int blueNum = r.nextInt(16) + 1;
        arr[arr.length - 1] = blueNum;
        return arr;
    }

    // 判断红球号码是否重复
    public static boolean contains(int[] arr, int redNum) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == redNum) {
                return true;
            }
        }
        return false;
    }
}
