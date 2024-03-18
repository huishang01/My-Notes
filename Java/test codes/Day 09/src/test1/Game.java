package test1;

import java.util.Random;

public class Game {
    // 成员变量
    private String name;
    private int HP;

    // 空参构造
    public Game() {
    }

    // 带参构造
    public Game(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }

    // 成员方法 Setter & Getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    // 定义一个方法用于攻击
    public void attack(Game role) {
        // 计算造成的伤害
        Random r = new Random();
        int damage = r.nextInt(20) + 1;

        // 更新血量，若 HP < 0，则为 0
        int remainHP = role.getHP() - damage;
        remainHP = remainHP < 0 ? 0 : remainHP;
        role.setHP(remainHP);

        // this 表示攻击者（方法调用者）  role 表示被攻击者（被方法传入者）
        System.out.println(this.getName() + " 攻击了 " + role.getName()
                + "，造成了 " + damage + " 点伤害，"
                + role.getName() + " 剩余血量 " + remainHP + " 点 ");
    }
}
