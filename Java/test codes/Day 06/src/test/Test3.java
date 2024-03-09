package test;

// 用方法比较两个长方形的面积

public class Test3 {
    public static void main(String[] args) {
        double area1 = getArea(12.3, 34.2);
        double area2 = getArea(34.5, 67.4);
        if (area1 > area2) {
            System.out.println("第一个长方形更大");
        } else {
            System.out.println("第二个长方形更大");
        }
    }

    public static double getArea(double len, double width) {
        double area = len * width;
        return area;
    }
}
