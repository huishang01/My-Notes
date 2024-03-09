package test;

/*
从键盘输入一个数n（要求n>=10），表示数组的长度，
使用随机函数生成n个0~99之间的随机整数并存入数组，
求这n个数组元素中每个元素的各位值之积，并输出。
例如24，它的十位数字为2，个位为4，则各位数值之积为2*4=8。
注意：采用方法(或函数)来实现，此函数(或方法)用于返回某个整数的各位数值之积。
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        // 从键盘输入一个数n（要求n>=10），表示数组的长度
        System.out.println("请输入数组的长度：");
        int arrLong = sc.nextInt();
        // 使用随机函数生成n个0~99之间的随机整数并存入数组
        int[] arr = new int[arrLong];
        for (int i = 0; i < arr.length; i++) {
            int random = r.nextInt(100);
            arr[i] = random;
        }
        // 输出数组的各位数值之积
        System.out.println("数组的各位数值之积为：");
        System.out.println(Arrays.toString(product(arr)));
    }

    // 求这n个数组元素中每个元素的各位值之积
    public static int[] product(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int ge = arr[i] % 10;
            int shi = arr[i] / 10;
            arr[i] = ge * shi;
        }
        return arr;
    }
}
