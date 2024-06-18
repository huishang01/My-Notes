package Test;

// 键盘输入任意字符串，打乱里面的内容

import java.util.Random;
import java.util.Scanner;

public class UpsetString {
    public static void main(String[] args) {
        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();

        // 将获取到的字符串转为字符数组
        char[] arr = str.toCharArray();

        // 遍历字符数组
        for (int i = 0; i < arr.length; i++) {
            // 获取一个随机数
            Random r = new Random();
            int num = r.nextInt(arr.length);

            // 用洗牌算法交换当前位置的字符和随机位置的字符
            char temp = arr[i];
            arr[i] = arr[num];
            arr[num] = temp;
        }

        // 将字符数组转换为字符串并输出
        String string = new String(arr);
        System.out.println("打乱后的字符串为：");
        System.out.println(string);
    }
}
