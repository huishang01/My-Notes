package test;

// 数100~200之间的质数

public class Test2 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
