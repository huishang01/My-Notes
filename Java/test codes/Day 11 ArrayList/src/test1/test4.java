package test1;

import java.util.ArrayList;

public class test4 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("zhansan", 18));
        list.add(new Student("Lisi", 19));
        list.add(new Student("Wangwu", 20));
        list.add(new Student("Wangwu", 21));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
