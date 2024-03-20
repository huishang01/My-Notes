package test2;

import java.util.Random;

public class Game {
    // 成员变量
    private String name;    // 名字
    private int HP;         // 血量
    private char gender;    // 性别
    private String face;    // 外貌 根据 性别 随机选择

    // 男性外貌
    String[] boyfaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    // 女性外貌
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹"};

    // attack 攻击描述
    String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };
    // injured 受伤描述
    String[] injureds_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    // 空参构造
    public Game() {
    }

    // 带参构造
    public Game(String name, int HP, char gender) {
        this.name = name;
        this.HP = HP;
        this.gender = gender;
        setFace(gender);
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(char gender) {
        Random r = new Random();
        int i = r.nextInt(boyfaces.length);
        if (gender == '男') {
            this.face = boyfaces[i];             // 赋值 外貌 给 男
        } else if (gender == '女') {
            this.face = girlfaces[i];            // 赋值 外貌 给 女
        } else {
            this.face = "面目狰狞且惨不忍睹";    // 若其他性别就 默认
        }
    }

    // 展示角色信息
    public void roleInfo() {
        System.out.println("名字：" + getName());
        System.out.println("血量：" + getHP());
        System.out.println("性别：" + getGender());
        System.out.println("外貌：" + getFace());
    }

    // 定义一个方法用于攻击
    // this 表示攻击者（方法调用者）  role 表示被攻击者（被方法传入者）
    public void attack(Game role) {
        Random r = new Random();
        // 随机攻击描述
        int index = r.nextInt(attacks_desc.length);
        String moves = attacks_desc[index];
        System.out.printf(moves, this.getName(), getName());
        System.out.println();

        // 计算造成的伤害
        int damage = r.nextInt(20) + 1;

        // 更新血量，若 HP < 0，则为 0
        int remainHP = role.getHP() - damage;
        remainHP = remainHP < 0 ? 0 : remainHP;
        role.setHP(remainHP);
        if (remainHP > 90) {
            System.out.printf(injureds_desc[0], role.getName());
        } else if (remainHP > 80) {
            System.out.printf(injureds_desc[1], role.getName());
        } else if (remainHP > 70) {
            System.out.printf(injureds_desc[2], role.getName());
        } else if (remainHP > 60) {
            System.out.printf(injureds_desc[3], role.getName());
        } else if (remainHP > 40) {
            System.out.printf(injureds_desc[4], role.getName());
        } else if (remainHP > 20) {
            System.out.printf(injureds_desc[5], role.getName());
        } else if (remainHP > 0) {
            System.out.printf(injureds_desc[6], role.getName());
        } else{
            System.out.printf(injureds_desc[7], role.getName());
        }
        System.out.println();
        System.out.println();
    }
}