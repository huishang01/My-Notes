package test;

import java.util.Random;

public class Test8 {
    public static void main(String[] args) {
        int[] arr = {2, 588, 888, 1000, 10000};
        int[] newArr = new int[arr.length];
        Random r = new Random();
        for (int i = 0; i < arr.length; ) {
            int randomIndex = r.nextInt(arr.length);
            int price = arr[randomIndex];
            if (!contains(newArr, price)) {
                newArr[i] = price;
                i++;
            }
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }
    }

    public static boolean contains(int[] arr, int price) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == price) {
                return true;
            }
        }
        return false;
    }
}
