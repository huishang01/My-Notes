package LoginSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void studentSystem() {
        // 创建集合存储学生信息
        ArrayList<Student> list = new ArrayList<>();

        loop:
        while (true) {
            // 初始菜单
            System.out.println("-------------欢迎来到黑马学生管理系统----------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择: ");

            // 主程序
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStu(list);
                case "2" -> delStu(list);
                case "3" -> setStu(list);
                case "4" -> queryStu(list);
                case "5" -> {
                    System.out.println("退出成功！");
                    break loop;
                }
                default -> System.out.println("输入不合法！");
            }
            System.out.println();
        }
    }

    // 修改学生
    public static void setStu(ArrayList<Student> list) {
        System.out.println("请输入学生ID：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = index(list, id);
        if (index >= 0) {
            System.out.println("请输入学生姓名：");
            list.get(index).setName(sc.next());
            System.out.println("请输入学生年龄：");
            list.get(index).setAge(sc.nextInt());
            System.out.println("请输入学生家庭住址：");
            list.get(index).setAddress(sc.next());
            System.out.println("修改成功！");
        } else {
            System.out.println("该学生不存在！");
        }
    }

    // 删除学生的方法
    public static void delStu(ArrayList<Student> list) {
        System.out.println("请输入学生ID：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = index(list, id);
        if (index >= 0) {
            System.out.println("删除成功！");
            list.remove(index);
        } else {
            System.out.println("该学生不存在！");
        }
    }

    // 添加学生的方法
    public static void addStu(ArrayList<Student> list) {
        // 创建学生对象
        Student s = new Student();

        // 添加学生信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生ID：");
        while (true) {
            String id = sc.next();
            if (index(list, id) >= 0) {
                System.out.println("该ID已存在！请重新输入：");
            } else {
                s.setId(id);
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        s.setName(sc.next());
        System.out.println("请输入学生年龄：");
        s.setAge(sc.nextInt());
        System.out.println("请输入学生家庭住址：");
        s.setAddress(sc.next());

        // 把已添加学生信息的学生对象添加到集合中
        list.add(s);
        System.out.println("添加成功！");
    }

    // 查询学生的方法
    public static void queryStu(ArrayList<Student> list) {
        System.out.println();
        if (list.size() == 0) {
            System.out.println("当前无学生信息，请添加后再查询");
        } else {
            System.out.println("ID\t\t姓名\t\t年龄\t家庭住址");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());

            }
        }
    }

    // 根据ID查询集合索引的方法
    public static int index(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
