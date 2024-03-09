package test;

/*求最值*/

public class Test6 {
    public static void main(String[] args) {
        int[] arr = {33, 5, 22, 44, 55};
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
