package test3;

public class User {
    // 成员变量
    private String username;
    private String password;
    private String email;
    private String gender;
    private int  age;

    // alt + Ins  生成标准 JavaBean 快捷键
    // 空参构造
    public User() {

    }

    // 带参构造
    public User(String username, String password, String email, String gender, int  age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    // 每个成员变量的 set 设置 & get 获取
    public void setUsername () {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword () {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail () {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setGender () {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge () {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
