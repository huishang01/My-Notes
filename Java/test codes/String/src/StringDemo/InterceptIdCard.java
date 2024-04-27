package StringDemo;

public class InterceptIdCard {
    public static void main(String[] args) {
        // 定义一个字符串表示身份证号
        String idCard = "469812200508221854";

        // 截取出生年月日
        String birthday = idCard.substring(12, 14);
        String birthmonth = idCard.substring(10, 12);
        String birthyear = idCard.substring(6, 10);

        // 截取性别
        int i = idCard.charAt(16);
        String gender = "";
        if (i % 2 == 0) {
            gender = "女";
        } else {
            gender = "男";
        }

        // 打印人物信息
        System.out.println("人物信息为：");
        System.out.println("出生年月日：" + birthyear + "年" + birthmonth + "月" + birthday + "日");
        System.out.println("性别：" + gender);
    }
}
