package test;

public class Test2 {
    public static void main(String[] args) {
        int sum1 = getSum(10, 20, 30);
        int sum2 = getSum(11, 21, 31);
        int sum3 = getSum(12, 23, 34);
        int sum4 = getSum(13, 26, 37);
        int result = sum1 + sum2 + sum3 + sum4;
        System.out.println(result);
    }

    public static int getSum(int sum1, int sum2, int sum3) {
        int result = sum1 + sum2 + sum3;
        return result;
    }
}
