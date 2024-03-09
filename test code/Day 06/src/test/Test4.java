package test;

public class Test4 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55};
        prinitArr(arr);
    }

    public static void prinitArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
