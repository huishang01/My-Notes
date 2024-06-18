package test2;

//请定义教师（Teacher）类，属性包含姓名和专业名称。
//将若干教师对象存入ArrayList集合中，并遍历集合打印教师信息，格式如下：
// 姓名：赵老师, 专业：javase
// 姓名：钱老师, 专业：javaee
// 姓名：孙老师, 专业：php
// 姓名：李老师, 专业：python

import java.util.ArrayList;

public class TeacherTest {
    public static void main(String[] args) {
        ArrayList<Teacher> list = new ArrayList<>();

        Teacher t1 = new Teacher("赵老师", "javase");
        Teacher t2 = new Teacher("钱老师", "javadee");
        Teacher t3 = new Teacher("孙老师", "php");
        Teacher t4 = new Teacher("李老师", "python");

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}
