package test;

// 在唱歌比赛中，有6名评委给选手打分，分数范围是[o - 100]之间的整数。
// 选手的最后得分为: 去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分。

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        int[] scores = getScores();
        int max = getMax(scores);
        int min = getMin(scores);
        int sum = getSum(scores);
        // 计算最终得分
        int result = ( sum - max - min ) / (scores.length - 2);
        System.out.println("最终得分为：" + result);
    }

    // 计算总分
    public static int getSum(int[] scores){
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }
        return  sum;
    }

    // 获取最高分
    public static int getMax(int[] scores) {
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return max;
    }

    // 获取最高分
    public static int getMin(int[] scores) {
        int min = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return min;
    }

    // 获取6个分数
    public static int[] getScores() {
        int[] scores = new int[6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; ) {
            System.out.println("请输入评分：");
            scores[i] = sc.nextInt();
            if (scores[i] >= 0 && scores[i] <= 100) {
                scores[i] = scores[i];
                i++;
            } else {
                System.out.print("评分不合法，");
            }
        }
        return scores;
    }
}
