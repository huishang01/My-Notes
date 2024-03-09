package test;

import java.util.Random;

// 生成5位的随机密码，前四位为随机大小写字母，最后一位是数字

public class Test3 {
    public static void main(String[] args) {
        // 把大小写字母存入数组中
        char[] chs = new char[52];
        for (int i = 0; i < chs.length; i++) {
            if (i < 26) {
                // 小写字母
                // ASCII里97为a
                chs[i] = (char) (97 + i);
            } else {
                // 大写字母
                // ASCII里65为A
                chs[i] = (char) (65 + i - 26);
            }
        }
        // 定义一个字符串记录结果
        String result = "";
        // 随机抽取四次
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(chs.length);
            result = result + chs[randomIndex];
        }
        // 随机抽取0~9
        int num = r.nextInt(10);
        result = result + num;
        // 输出结果
        System.out.println(result);
    }
}
