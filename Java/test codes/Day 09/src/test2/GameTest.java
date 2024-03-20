package test2;

public class GameTest {
    public static void main(String[] args) {
        // 创建角色
        Game role1 = new Game("探路者", 100,'男');
        Game role2 = new Game("动力小子", 100, '男');

        // 展示角色外貌
        role1.roleInfo();
        role2.roleInfo();
        System.out.println();

        // 开始战斗  若血量为 0 则结束循环
        while (true) {
            // role1 攻击 role2
            role1.attack(role2);
            if (role2.getHP() == 0) {
                System.out.println(role1.getName() + " 击杀了 " + role2.getName());
                break;
            }
            // role2 攻击 role1
            role2.attack(role1);
            if (role1.getHP() == 0) {
                System.out.println(role2.getName() + " 击杀了 " + role1.getName());
                break;
            }
        }
    }
}
