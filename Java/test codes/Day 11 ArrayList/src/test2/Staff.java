package test2;

public class Staff {
    private String name;
    private int wage;

    public Staff() {
    }

    public Staff(String name, int wage) {
        this.wage = wage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public String toString() {
        return "姓名：" + name + ", " + "工资：" + wage;
    }
}
