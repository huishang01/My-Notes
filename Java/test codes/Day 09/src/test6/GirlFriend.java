package test6;

public class GirlFriend {
    private String name;
    private int age;
    private String moePoint;
    private String hobby;

    public GirlFriend() {
    }

    public GirlFriend(String name, int age, String moePoint, String hobby) {
        this.name = name;
        this.age = age;
        this.moePoint = moePoint;
        this.hobby = hobby;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public String getMoePoint() {
        return moePoint;
    }

    /**
     * 设置
     * @param moePoint
     */
    public void setMoePoint(String moePoint) {
        this.moePoint = moePoint;
    }

    /**
     * 获取
     * @return hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置
     * @param hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
