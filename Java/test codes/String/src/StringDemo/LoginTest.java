package StringDemo;

import java.util.Scanner;

public class LoginTest {
    public static void main(String[] args) {
        // 正确的用户名和密码
        String trueUsername = "田所浩二";
        String truePassword = "114514";

        // 录入用户输入的用户名和密码
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("用户名：");
            String username = sc.nextLine();
            System.out.println("密 码：");
            String password = sc.nextLine();

            // 用 equals 比较两个字符串
            if (username.equals(trueUsername) && password.equals(truePassword)) {
                System.out.println("登录成功！");
                break;
            } else {
                if (i == 1) {
                    System.out.println("登录失败，用户名或密码有误！您还剩1次机会！");
                } else if (i == 2) {
                    System.out.println("登录失败，账户" + username + "已被锁定！请联系管理员。");
                } else {
                    System.out.println("登录失败，用户名或密码有误！");
                }
            }
        }
    }
}
