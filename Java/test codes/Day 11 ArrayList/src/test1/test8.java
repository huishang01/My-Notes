package test1;

/*
需求：
        定义Javabean类：Phone
        Phone属性：品牌，价格。
        main方法中定义一个集合，存入三个手机对象。
        分别为：小米，1000。苹果，8000。锤子 2999。
        定义一个方法，将价格低于3000的手机信息返回。
*/

import java.util.ArrayList;

public class test8 {
    public static void main(String[] args) {
        // 定义一个集合，存入三个手机对象
        ArrayList<Phone> list = new ArrayList<>();

        list.add(new Phone("小米", 1000));
        list.add(new Phone("苹果", 8000));
        list.add(new Phone("锤子", 2999));

        // 输出结果
        ArrayList<Phone> phones = getPhoneInfo(list);
        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i).toString());
        }
    }

    // 将价格低于3000的手机信息返回的方法
    public static ArrayList<Phone> getPhoneInfo(ArrayList<Phone> list) {
        // 定义一个集合存储结果
        ArrayList<Phone> phones = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() < 3000) {
                phones.add(list.get(i));
            }
        }
        return phones;
    }
}
