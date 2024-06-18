package test1;

import java.util.ArrayList;
import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<Student> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            // 创建学生对象
            Student s = new Student();

            // 设置姓名
            System.out.println("姓名：");
            String name = sc.next();
            s.setName(name);

            // 设置年龄
            System.out.println("年龄：");
            int age = sc.nextInt();
            s.setAge(age);

            // 把学生对象添加到集合中
            list.add(s);
        }

        // 遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
