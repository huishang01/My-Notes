package test;

/*
某系统的数字密码(大于0) 。比如1983，采用加密方式进行传输
    规则如下:
        每位数加上5
        再对10求余，
        最后将所有数字反转，
        得到一串新数。
*/

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        // 获取密码
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入密码：");
        int num = sc.nextInt();
        int temp = num;

        // 计算数组长度
        int count = 0;
        while (num != 0) {
            num = num / 10;
            count++;
        }

        // 获取密码的每一位数
        int[] arr = new int[count];
        int a = arr.length - 1;
        while (temp != 0) {
            arr[a] = temp % 10;
            temp = temp / 10;
            a--;
        }

        // 每位数加上5
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 5;
        }

        // 对10求余
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10;
        }

        // 将所有数字反转
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int x = 0;
            x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
        }

        // 得到加密后的数字
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            x = x * 10 + arr[i];
        }
        System.out.println("加密后的数字为：" + x);

        // 解密反转
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int q = 0;
            q = arr[i];
            arr[i] = arr[j];
            arr[j] = q;
        }

        // 解密求余
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 4) {
                arr[i] = arr[i] + 10;
            }
        }

        // 解密+5
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - 5;
        }

        // 得到解密后的密码
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            y = y * 10 + arr[i];
        }
        System.out.println("密码为：" + y);
    }
}
