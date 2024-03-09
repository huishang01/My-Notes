package test;

/*
生成10个1~100之间的数存入数组。
1）求出所有数据的和
2）求所有数据的平均值
3）统计有多少个数据比平均值小
 */

import java.util.Random;

public class Test7 {
    public static void main(String[] args) {
        // 创建Random对象
        Random r = new Random();
        // 生成1~30个1~100之间的数存入数组
        int x = r.nextInt(30) + 1;
        int[] arr = new int[x];
        for (int i = 0; i < arr.length; i++) {
            int num = r.nextInt(100) + 1;
            arr[i] = num;
            // 遍历数组
            System.out.print(arr[i] + "  ");
        }
        // 求出所有数据的和
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println();
        System.out.println("所有数据的和为：" + sum);
        // 求所有数据的平均值
        int avg = sum / arr.length;
        System.out.println("所有数据的平均值为：" + avg);
        // 统计有多少个数据比平均值小
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < sum) {
                count++;
            }
        }
        System.out.println("有 " +  count + " 个数据比平均值小");
    }
}
