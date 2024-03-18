package test1;

public class PhoneTest {
    public static void main(String[] args) {
        Phone p = new Phone();
        p.brand = "小米";
        p.price= 1999.9;
        System.out.println(p.brand);
        System.out.println(p.price);

        p.call();
        p.playGame();
    }
}
