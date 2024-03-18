package test2;

public class GirlsFriends {
    // 属性
    // private 权限修饰符，只在本类访问
    private String name;
    private int age;
    private String gender;

    // 滤值（用 public 修饰）
    // set 赋值（不需要返回值）   get 供值（需要返回值）
    // this. 调用本类成员

    private GirlsFriends() {

    }

    public GirlsFriends(String name, int age, String gender) {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int a) {
        if (a >= 0 && a <= 20) {
            this.age = a;
        } else {
            System.out.println("非法参数");
        }
    }

    public int getAge() {
        return age;
    }

    public void setGender(String g) {
        gender = g;
    }

    public String getGender() {
        return gender;
    }

    // 行为
    public void talk() {
        System.out.println("说话");
    }

    public void sleep() {
        System.out.println("睡觉");
    }
}
