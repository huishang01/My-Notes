package test;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] age = {11, 12, 13, 14};
        String[] name = {"Alen", "Mikasa", "Almean"};
        double[] height = {160.0, 123.4, 234.213, 342};
        System.out.println(age[0]);
        System.out.println(name[1]);
        System.out.println(height[2]);

        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
            sum += arr[i];
            if (arr[i] % 3 == 0) {
                count++;
            }
        }
        System.out.println();
        System.out.println(sum);
        System.out.println(count);

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < arr.length; i++) {
            if (arr1[i] % 2 == 0) {
                arr1[i] /= 2;
            } else {
                arr1[i] *= 2;
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "  ");
        }
    }
}
