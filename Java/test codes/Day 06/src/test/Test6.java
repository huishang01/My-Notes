package test;

// 用方法实现判断数组中是否存在某个数

public class Test6 {
    public static void main(String[] args) {
        int[] arr = {12, 543, 657, 78, 7789, 34, 456, 678, 783, 423, 45, 87};
        String flag = contains(arr, 12);
        System.out.println(flag);
    }

    public static String contains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return "存在";
            }
        }
        return "不存在";
    }
}
