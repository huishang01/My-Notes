package test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入老虎一的体重：");
        int weight1 = sc.nextInt();
        System.out.println("请输入老虎二的体重：");
        int weight2 = sc.nextInt();
        String result = weight1 == weight2 ? "相同" : "不同";
        System.out.println(result);
    }
}
