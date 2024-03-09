package test;

import java.util.Arrays;
import java.util.Random;

// 二维数组存入数据

public class Test11 {
    public static void main(String[] args) {
        // 给二维数组随机赋值
        int[][] arr = new int[2][5];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(100);
                System.out.print(arr[i][j] + "  ");
            }
        }
        System.out.println();
        // 输出方式一
        System.out.println((Arrays.toString(arr[0]) + Arrays.toString(arr[1])).replace("][", ", "));
        // 输出方式二
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
        }
    }
}
