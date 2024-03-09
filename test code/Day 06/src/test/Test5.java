package test;

// 用方法找出数组中的最大数

public class Test5 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 4, 32, 5};
        System.out.println(getMax(arr));;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
