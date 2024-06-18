package StringDemo;

public class InterceptPhoneNumber {
    public static void main(String[] args) {
        // 定义一个字符串表示手机号
        String phoneNumber = "13111451919";

        // 定义一个字符串表示手机号前三位
        String start = phoneNumber.substring(0,3);

        // 定义一个字符串表示手机号后四位
        String end = phoneNumber.substring(7);

        // 输出结果
        System.out.println(start + "****" + end);
    }
}
