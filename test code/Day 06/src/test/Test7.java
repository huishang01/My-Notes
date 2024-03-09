package test;

// 用方法实现列出3~8之间的数

public class Test7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] copyArr = copyOfRange(arr, 3, 8);
        for (int i = 0; i < copyArr.length; i++) {
            System.out.print(copyArr[i] + "  ");
        }
    }

    public static int[] copyOfRange(int[] arr, int from, int to) {
        int[] copyArr = new int[to - from];
        int index = 0;
        for (int i = from - 1; i < to - 1; i++) {
            copyArr[index] = arr[i];
            index++;
        }
        return copyArr;
    }
}
