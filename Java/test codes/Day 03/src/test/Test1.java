package test;

import java.util.Scanner;

public class Test1 {
    /*
        需求: 键盘录入一个三位数, 将数值拆分出个位, 十位, 百位, 随后打印在控制台

                数值拆分的公式 :

                    个位: 数值 % 10
                    十位: 数值 / 10 % 10
                    百位: 数值 / 10 / 10 % 10
                    千位: 数值 / 10 / 10 / 10 % 10
                    ...

                 对于数值的最高位, 简化处理

                    123 : 百位            123 / 100  ---> 1
                    1234 : 千位           1234 / 1000 ---> 1
                    12345 : 万位          12345 / 10000 ---> 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个三位数：");
        int num = sc.nextInt();
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100 % 10;
        System.out.println("个位是：" + ge);
        System.out.println("十位是：" + shi);
        System.out.println("百位是：" + bai);
    }
}
