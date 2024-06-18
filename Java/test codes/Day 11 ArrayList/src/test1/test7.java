package test1;

/*
需求：
1，main方法中定义一个集合，存入三个用户对象。
      用户属性为：id，username，password
2，要求：定义一个方法，根据id查找对应的用户信息。
      如果存在，返回索引
      如果不存在，返回-1
*/

import java.util.ArrayList;

public class test7 {
    public static void main(String[] args) {
        // 定义一个集合
        ArrayList<User> list = new ArrayList<>();

        // 存入三个用户对象
        list.add(new User("001", "aaa", "123456"));
        list.add(new User("002", "bbb", "abcdef"));
        list.add(new User("003", "bbb", "qwerty"));

        System.out.println(contains("001", list));
        System.out.println(getIndex("004", list));
    }

    // 根据id查找对应的用户信息返回真假的方法
    public static boolean getIndex(String id, ArrayList<User> list) {
        return contains(id, list) >= 0;
    }

    // 根据id查找对应的用户信息返回索引的方法
    public static int contains(String id, ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
