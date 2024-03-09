package test;

public class Test1 {
    public static void main(String[] args) {
        playGame();
        System.out.println();
        getSum(10, 20);
        getLength(1.25, 1.5);
        getArea(5);
    }

    public static void playGame() {
        System.out.println("hello world!");
        int a = 10;
        int b = 20;
        int result = a + b;
        System.out.println(result);
    }

    public static void getSum(int a, int b) {
        int result = a + b;
        System.out.println(result);
    }

    public static void getLength(double width, double leng) {
        double result = (width + leng) * 2;
        System.out.println(result);
    }

    public static void getArea(double radius) {
        double result = radius * radius * 3.14;
        System.out.println(result);
    }
}
