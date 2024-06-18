package test1;

import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> list = new ArrayList<>();

        // 添加元素
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");

        // 遍历集合
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }
        System.out.println("]");
    }
}
