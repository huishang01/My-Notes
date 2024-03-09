package test;

/*
 (某商城每个季度的营业额如下:单位(万元)
第一季度：22，66，44
第二季度：77，33，88
第三季度：25，45，65
第四季度：11，66，99
要求计算出每个季度的总营业额和全年的总营业额
*/

public class Test12 {
    public static void main(String[] args) {
        int[][] arr = {
                {22, 66, 44},
                {77, 33, 88},
                {25, 45, 65},
                {11, 66, 99}
        };
        int yearSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] quaArr = arr[i];
            int sum = sum(arr[i]);
            System.out.println("第" + (i + 1) + "个季度的总营业额：" + sum);
            yearSum = yearSum + sum;
        }
        System.out.println("全年的总营业额：" + yearSum);
    }

    // 每个季度的总营业额
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
}
