package test;

// 用两个办法累加1~100之间的偶数

public class Test4 {
    public static void main(String[] args) {
        // 初始化结果
        int sum = 0;
        // 获取1-100之间的偶数
        for (int i = 2; i <= 100; i = i + 2) {
            System.out.print(i + " ");
            // 累加结果与i
            sum += i;
        }
        // 换行并输出结果
        System.out.println();
        System.out.println(sum);
        //
        System.out.println("------------------------------------");
        // 初始化结果
        int sum2 = 0;
        for (int i = 1; i <= 100; i++) {
            // 筛选出1-100之间的偶数
            if (i % 2 == 0) {
                System.out.print(i + " ");
                // 累加结果与i
                sum2 += i;
            }
        }
        // 换行并输出结果
        System.out.println();
        System.out.println(sum2);
    }
}
