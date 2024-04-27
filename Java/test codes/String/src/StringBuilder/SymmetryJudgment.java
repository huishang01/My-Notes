package StringBuilder;

import java.util.Scanner;

public class SymmetryJudgment {
    public static void main(String[] args) {
        // 录入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.next();

        // 创建StringBuilder对象，反转，将结果转为字符串后判断得出结果
        boolean result = new StringBuilder(str).reverse().toString().equals(str);

        // 根据结果打印结论
        if (result) {
            System.out.println(str + " 是对成字符串");
        } else {
            System.out.println(str + " 不是对成字符串");
        }
    }
}
