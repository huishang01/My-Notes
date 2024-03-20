package test1;

import java.util.Random;

public class Game {
    // 成员变量
    private String name;
    private int HP;
    // 男性外貌
    String[] boyfaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    // 女性外貌
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};

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
    // this 表示攻击者（方法调用者）  role 表示被攻击者（被方法传入者）
    public void attack(Game role) {
        Random r = new Random();

        // 计算造成的伤害
        int damage = r.nextInt(20) + 1;

        // 更新血量，若 HP < 0，则为 0
        int remainHP = role.getHP() - damage;
        remainHP = remainHP < 0 ? 0 : remainHP;
        role.setHP(remainHP);

        System.out.println(this.getName() + "举起拳头，打了" + role.getName() + "一下，" +
                "造成了" + damage + "点伤害，" + role.getName() + "还剩下了" + remainHP + "点血");
    }
}
