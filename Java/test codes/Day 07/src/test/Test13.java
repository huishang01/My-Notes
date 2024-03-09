package test;

/*
个位^3 + 十位^3 + 百位^3 = 水仙花数
 */
public class Test13 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100;
            if (i == ge * ge * ge + shi * shi * shi + bai * bai * bai) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("1000以内一共有" + count + "个水仙数");
    }
}
