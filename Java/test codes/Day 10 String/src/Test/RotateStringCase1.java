package Test;

        /* 给定两个字符串, A和B。
        A的旋转操作就是将A 最左边的字符移动到最右边。
        例如, 若A = 'abcde'，在移动一次之后结果就是'bcdea'
        如果在若干次调整操作之后，A能变成B，那么返回True。
        如果不能匹配成功，则返回false */

public class RotateStringCase1 {
    public static void main(String[] args) {
        // 定义两个字符串
        String strA = "abcde";
        String strB = "cdeab";

        // 打印结果
        System.out.println(compareStr(strA, strB));
    }

    // 比较两个字符串的方法
    public static boolean compareStr(String strA, String strB) {
        for (int i = 0; i < strA.length(); i++) {
            // 旋转strA
            strA = rotateString(strA);
            // 将旋转strA后的值与strB比较
            if (strA.equals(strB)) {
                return true;
            }
        }
        return false;
    }

    // 旋转字符串的方法
    public static String rotateString(String str) {
        // 获取字符串第一个字符
        char first = str.charAt(0);
        // 获取字符串第一个字符后面的字符串
        String end = str.substring(1);
        // 拼接并返回
        return end + first;
    }
}
