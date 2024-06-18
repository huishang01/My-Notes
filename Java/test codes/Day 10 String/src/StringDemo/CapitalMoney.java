package StringDemo;

import java.util.Scanner;

public class CapitalMoney {
    public static void main(String[] args) {
        // 键盘录入一个金额
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个金额：");
        int money = 0;
        while (true) {
            money = sc.nextInt();
            if (money >= 0 && money <= 9999999) {
                break;
            } else {
                System.out.println("金额不合法，请重新输入：");
            }
        }

        // 把录入的金额转换成大写金额
        String result = getString(money);

        // 含有连续零就省去单位且只保留一个零
        // 十位个位连写中间不加零
        // 末尾是零或连续零就直接省略只剩一个元

        // 输出结果
        System.out.println(result);
    }

    // 补零和加单位的方法
    private static String getString(int money) {
        String capitalMoney = getCapitalMoney(money);

        // 七位数补零
        int capitalMoneyLength = capitalMoney.length();
        for (int i = 0; i < 7 - capitalMoneyLength; i++) {
            capitalMoney = "零" + capitalMoney;
        }

        // 添加单位
        String result = "";
        String[] str = {"佰 ", "拾 ", "萬 ", "仟 ", "佰 ", "拾 ", "元"};
        for (int i = 0; i < capitalMoney.length(); i++) {
            result = result + capitalMoney.charAt(i) + str[i];
        }
        return result;
    }

    // 把数字转换成大写金额的方法
    public static String getCapitalMoney(int money) {
        String[] str = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String capitalMoney = "";
        while (true) {
            // 取出最右边位
            int ge = money % 10;
            // 转换成大写金额并拼接
            capitalMoney = str[ge] + capitalMoney;
            // 去除最右边位
            money /= 10;

            if (money == 0) {
                break;
            }
        }
        return capitalMoney;
    }
}
