package test2;

public class GirlsFriendsTest {
    public static void main(String[] args) {
        // 创建女朋友对象
        GirlsFriends gf1 = new GirlsFriends("樱岛麻衣", 16, "兔女郎");
        gf1.setName("樱岛麻衣");
        gf1.setAge(16);
        gf1.setGender("兔女郎");

        System.out.println(gf1.getName());
        System.out.println(gf1.getAge());
        System.out.println(gf1.getGender());

        gf1.talk();
        gf1.sleep();

        System.out.println("================================");

        GirlsFriends gf2 = new GirlsFriends("艾米莉亚", 16, "半精灵");
        gf2.setName("艾米莉亚");
        gf2.setAge(16);
        gf2.setGender("半精灵");

        System.out.println(gf2.getName());
        System.out.println(gf2.getAge());
        System.out.println(gf2.getGender());

        gf2.talk();
        gf2.sleep();
    }
}
