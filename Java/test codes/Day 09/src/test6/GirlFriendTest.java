package test6;

public class GirlFriendTest {
    public static void main(String[] args) {
        GirlFriend[] arr = new GirlFriend[4];

        GirlFriend gf1 = new GirlFriend("栗山未来",15 , "天然呆、贫乳、眼镜", "园艺、韭菜炒猪肝、吃面包大赛、狗");
        GirlFriend gf2 = new GirlFriend("立华奏",16 , "学生会长、长直发、三无、羽翼型翅膀", "麻婆豆腐");
        GirlFriend gf3 = new GirlFriend("泉此方",18 , "呆毛、长直、宅女", "动画、游戏");
        GirlFriend gf4 = new GirlFriend("亚可·卡嘉莉",17, "无铁炮、元气、魔女", "魔法");

        arr[0] = gf1;
        arr[1] = gf2;
        arr[2] = gf3;
        arr[3] = gf4;

        // 求平均年龄
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getAge();
        }
        int average = sum / arr.length;
        System.out.println("平均年龄：" + average);

        // 求低于平均年龄个数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getAge() < average) {
                count++;
                System.out.println(arr[i].getName());
                System.out.println(arr[i].getAge());
                System.out.println(arr[i].getMoePoint());
                System.out.println(arr[i].getHobby());
            }
        }
        System.out.println("低于平均年龄个数：" + count);
    }
}
