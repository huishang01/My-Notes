package test;

import java.util.Random;

// 给数组随机排序

public class Test10 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            int x = r.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
