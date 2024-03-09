package test;

/*
从键盘输入两个正整除，求他们的商和余数，要求不能用除号和求余符号
 */

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 录入除数
        System.out.println("请输入除数：");
        int chuShu = sc.nextInt();
        // 录入被除数
        System.out.println("请输入被除数：");
        int beiChuShu = sc.nextInt();
        // 统计相减次数为商
        int count = 0;
        // 求余数
        while (chuShu >= beiChuShu) {
            // 相减到最后，除数就是余数
            chuShu = chuShu - beiChuShu;
            // 每减一次c就+1
            count++;
        }
        // 输出结果
        System.out.println("余数是 " + chuShu);
        System.out.println("商是 " + count);
    }
}
