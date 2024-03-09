package test;

import java.util.Random;
import java.util.Scanner;

/*从键盘输入一个数n（要求n>=10），表示数组的长度，
使用随机函数生成n个0~99之间的随机整数并存入数组，
判断这n个数组元素中每个元素的各位值之积，并输出。
例如24，它的十位数字为2，个位为4，则各位数值之积为2*4=8。
注意：采用方法(或函数)来实现，此函数(或方法)用于返回某个整数的各位数值之积。*/

public class Test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = a1(n);
        for (int num : arr) {
            int x = a2(num);
            System.out.println(num + "  " + x);
        }
    }

    // 生成包含 n 个 0~99 之间的随机整数的数组
    public static int[] a1(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int j = r.nextInt(100);
            arr[i] = j;
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        return arr;
    }

    // 计算一个整数的各位数值之积
    public static int a2(int num) {
        int x = 1;
        if (num >= 10) {
            while (num != 0) {
                int ge = num % 10;
                x *= ge;
                num /= 10;
            }
        } else {
            while (num != 0) {
                int ge = num % 10;
                x *= 0;
                num /= 10;
            }
        }
        return x;
    }
}
