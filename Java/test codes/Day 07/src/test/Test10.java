package test;

import java.util.Arrays;

/*
 * 冒泡排序算法
 * 1.比较数组中两个相邻的元素，如果第一个数比第二个数大，就交换两个数的位置
 * 2.每一次比较都会产生一个最大，或者最小的数字
 * 3.下一轮则可以少一次排序
 * 4.依次循环，直到结束
*/

public class Test10 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 7, 1, 8, 4, 9, 3, 5};
        //进行排序
        sort(arr);
        //输出数组
        System.out.print(Arrays.toString(arr));
    }

    public static void sort(int arr[]) {
        //临时变量
        int temp = 0;
        //外层循环，进行比较的次数
        for (int i = 0; i < arr.length; i++) {
            //内层循环，判断两个数，如果第一个数比第二个数大，那么两个数交换位置
            // 因为最后一个数无法再比所以要-1
            for (int j = 0; j < arr.length - i - 1; j++) {
                //升序用>，降序用<
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

