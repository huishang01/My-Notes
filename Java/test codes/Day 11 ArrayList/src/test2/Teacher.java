package test2;

public class Teacher {
    private String name;
    private String major;

    public Teacher() {
    }

    public Teacher(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String toString() {
        return "姓名：" + name + ", " + "专业：" + major;
    }
}
