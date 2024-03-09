package test;

public class Test4 {
    public static void main(String[] args) {
        int heShang1 = 150, heShang2 = 210, heShang3 = 165;
        int temp = heShang1 > heShang2 ? heShang1 : heShang2;
        int result = temp > heShang3 ? temp : heShang3;
        System.out.println(result);
    }
}
