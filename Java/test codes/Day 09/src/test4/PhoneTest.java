package test4;

// 使用键盘录入存入三个手机数据（品牌、价格、颜色）到一个数组中

import java.util.Scanner;

public class PhoneTest {
    public static void main(String[] args) {
        Phone[] arr = new Phone[3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            Phone p = new Phone();

            System.out.println("请输入手机品牌：");
            String brand = sc.next();
            p.setPhoneBrand(brand);

            System.out.println("请输入手机价格：");
            int price = sc.nextInt();
            p.setPhonePrice(price);

            System.out.println("请输入手机颜色：");
            String color = sc.next();
            p.setPhoneColor(color);
            System.out.println();
            // 把获取到的数据添加到数组中
            arr[i] = p;
        }

        // 打印输出
        for (int i = 0; i < arr.length; i++) {
            // 遍历数组，把得到的数据传入创建的对象中
            Phone p = arr[i];

            System.out.println(p.getPhoneBrand() +", "+ p.getPhonePrice() +", "+ p.getPhoneColor());
        }
    }
}
