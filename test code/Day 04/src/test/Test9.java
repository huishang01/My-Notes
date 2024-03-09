package test;

// 用for和while两个办法求出1~100之间的累加

public class Test9 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum+=i;
        }
        System.out.println(sum);

        int a = 0;
        int i = 1;
        do {
            a += i;
            i++;
        } while (i <= 100);
        System.out.println(a);
    }
}
