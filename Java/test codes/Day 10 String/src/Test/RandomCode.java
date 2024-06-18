package Test;

/*
生成验证码
内容：可以是小写字母，也可以是大写字母，还可以是数字
规则：
长度为5
内容中是四位字母，1位数字。
其中数字只有1位，但是可以出现在任意的位置。
*/

import java.util.Random;

public class RandomCode {
    public static void main(String[] args) {
        String code = getCode();
        System.out.println("随机生成的验证码为：" + code);
    }

    // 生成符合规则的验证码
    public static String getCode() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        // 生成随机数字
        char number = getRandomNumber();

        // 生成0 ~ 4之间的随机数用来决定数字插入的位置
        int position = r.nextInt(5);

        // 生成4个随机字母
        for (int i = 0; i < 4; i++) {
            // 生成随机字母
            char letter = getRandomLetter();

            // 如果position等于i，则在改处插入数字
            if (i == position) {
                sb.append(number);
            }
            // 把生成的字母添加到sb中
            sb.append(letter);

            // 如果position等于4，则在最后一位插入数字
            if (position == 4) {
                sb.append(number);
            }
        }

        // 转换为字符串并返回
        return sb.toString();
    }

    // 生成随机字母
    public static char getRandomLetter() {
        Random r = new Random();

        // 创建一个0 ~ 1之间的随机数来决定生成的是小写字母还是大写字母
        int randomType = r.nextInt(2);

        if (randomType == 0) {
            // 生成大写字母
            int uppercaseAscii = r.nextInt(26) + 65;
            return (char) uppercaseAscii;
        } else {
            // 生成小写字母
            int lowercaseAscii = r.nextInt(26) + 97;
            return (char) lowercaseAscii;
        }
    }

    // 生成随机数字
    public static char getRandomNumber() {
        Random r = new Random();
        int numberAscii = r.nextInt(10) + 48;
        return (char) numberAscii;
    }
}
