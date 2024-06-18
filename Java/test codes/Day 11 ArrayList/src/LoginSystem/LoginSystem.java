package LoginSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static LoginSystem.StudentSystem.studentSystem;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> list = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("------欢迎来到学生管理系统------");
            System.out.println("请选择操作：");
            System.out.println("1 - 登录  2 - 注册  3 - 忘记密码  4 - 退出");
            String choose = sc.next();
            switch (choose) {
                case "1" -> {
                    login(list);  // 登录
                    studentSystem(); // 进入学生管理系统
                }
                case "2" -> register(list); // 注册
                case "3" -> forgetPassword(list); // 忘记密码
                case "4" -> {
                    System.out.println("退出成功！"); // 退出系统
                    System.exit(0);
                }
                default -> System.out.println("输入不合法！");
            }
            System.out.println();
        }
    }

    // 登录
    private static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            String username;
            username = sc.next();
            if (!contains(list, username)) {
                System.out.println("该用户不存在，请注册！");
                return;
            }

            System.out.println("请输入密码：");
            String password = sc.next();

            while (true) {
                String code = code();
                System.out.println("请输入验证码：");
                System.out.println("验证码：" + code);
                String inputCode = sc.next();
                if (!inputCode.equals(code)) {
                    System.out.println("验证码错误，请重新输入！");
                } else {
                    break;
                }
            }

            // 验证密码
            User userInfo = new User(username, password, null, null);
            boolean result = checkUserInfo(list, userInfo);
            if (result) {
                System.out.println("登陆成功！");
                return;
            } else {
                System.out.println("用户名或密码错误，你还剩" + (2 - i) + "次机会！");
                if (i == 2) {
                    System.out.println("账户已锁定，请重置密码！");
                }
            }
        }
    }

    // 注册
    private static void register(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        // 创建用户对象存储注册信息
        User u = new User();

        // 用户名
        System.out.println("请输入用户名：");
        while (true) {
            String username = sc.next();

            // 判断用户名格式是否正确
            if (!checkUsername(username)) {
                System.out.println("用户名不合法，请重新输入：");
                continue;
            }

            // 验证用户名唯一性
            if (contains(list, username)) {
                System.out.println("该用户名已存在，请重新输入：");
                continue;
            }

            // 把用户名添加到用户中
            u.setUsername(username);
            break;
        }

        // 密码
        while (true) {
            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("请再次输入密码：");
            String rePassword = sc.next();
            if (!password.equals(rePassword)) {
                System.out.println("两次输入的密码不一致，请重新输入！");
            } else {
                u.setPassword(password);
                break;
            }
        }

        // 身份证号
        System.out.println("请输入身份证号：");
        while (true) {
            String ID = sc.next();
            if (checkID(ID)) {
                u.setId(ID);
                break;
            } else {
                System.out.println("身份证号不合法，请重新输入：");
            }
        }

        // 手机号
        System.out.println("请输入手机号：");
        while (true) {
            String phoneNum = sc.next();
            if (checkPhoneNum(phoneNum)) {
                u.setPhoneNum(phoneNum);
                break;
            } else {
                System.out.println("手机号不合法，请重新输入：");
            }
        }

        // 把用户添加到集合中
        list.add(u);
        System.out.println("注册成功！");
    }

    // 忘记密码
    private static void forgetPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = sc.next();
        // 验证用户名唯一性
        if (!contains(list, username)) {
            System.out.println("该用户名不存在，请注册！");
            return;
        }

        while (true) {
            System.out.println("请输入身份证号：");
            String ID = sc.next();
            System.out.println("请输入手机号：");
            String phoneNum = sc.next();

            System.out.println("请输入验证码：");
            while (true) {
                String code = code();
                System.out.println("验证码：" + code);
                String inputCode = sc.next();
                if (!code.equals(inputCode)) {
                    System.out.println("验证码错误，请重新输入：");
                } else {
                    break;
                }
            }

            // 验证身份
            User userInfo = new User(null, null, ID, phoneNum);
            if (!checkUserIdentity(list, userInfo)) {
                System.out.println("身份证号或手机号错误，请重试！");
            } else {
                break;
            }
        }

        // 修改密码
        User u = new User();
        while (true) {
            System.out.println("请输入新的密码：");
            String password = sc.next();
            System.out.println("请再次输入密码：");
            String rePassword = sc.next();
            if (!password.equals(rePassword)) {
                System.out.println("两次密码不一致，请重新输入！");
            } else {
                u.setPassword(password);
                return;
            }
        }
    }

    // 根据用户名验证身份的方法
    public static boolean checkUserIdentity(ArrayList<User> list, User userIdentity) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getId().equals(userIdentity.getId()) && user.getPhoneNum().equals(userIdentity.getPhoneNum())) {
                return true;
            }
        }
        return false;
    }

    // 根据用户名验证密码的方法
    public static boolean checkUserInfo(ArrayList<User> list, User userInfo) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(userInfo.getUsername())) {
                String userPassword = user.getPassword();
                if (userPassword != null && userPassword.equals(userInfo.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    // 根据用户名返回索引的方法
    public static int index(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    // 生成验证码的方法
    public static String code() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char rChar1 = (char) (r.nextInt(26) + 'a');
            char rChar2 = (char) (r.nextInt(26) + 'A');
            char[] arr = {rChar1, rChar2};
            sb.append(arr[r.nextInt(2)]);
        }
        sb.insert(r.nextInt(4), r.nextInt(10));
        return sb.toString();
    }

    // 验证手机号格式是否的方法
    public static boolean checkPhoneNum(String phoneNum) {
        // 长度为11位
        if (phoneNum.length() != 11) {
            return false;
        }

        // 不能以0为开头
        if (phoneNum.startsWith("0")) {
            return false;
        }
        // 必须都是数字
        for (int i = 0; i < phoneNum.length(); i++) {
            char c = phoneNum.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }

        return true;
    }

    // 验证身份证号格式是否正确的方法
    public static boolean checkID(String ID) {
        // 长度为18位
        if (ID.length() != 18) {
            return false;
        }

        // 不能以0为开头
        if ((ID.startsWith("0"))) {
            return false;
        }

        //前17位必须都是数字
        for (int i = 0; i < ID.length() - 1; i++) {
            char c = ID.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }

        // 最为一位可以是数字，也可以是大写X或小写x
        char c = ID.charAt(ID.length() - 1);
        if ((c >= '0' && c <= '9') || c == 'x' || c == 'X') {
            return true;
        }

        return false;
    }

    // 验证用户名格式是否正确的方法
    public static boolean checkUsername(String username) {
        // 用户名长度必须在3~15位之间
        int length = username.length();
        if (!(length >= 3 && length <= 15)) {
            return false;
        }

        // 用户名只能是数字和字母的组合
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }

        // 统计用户名中有多少个字母
        int letterCount = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                letterCount++;
            }
        }

        // 统计用户名中有多少个数字
        int NUmCount = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c >= '0' && c <= '9')) {
                NUmCount++;
            }
        }
        return letterCount > 0 && NUmCount > 0;
    }

    // 判断用户名唯一性的方法
    public static boolean contains(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
