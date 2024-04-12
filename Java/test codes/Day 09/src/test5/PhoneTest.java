package test5;

// 求三个手机价格的平均值

public class PhoneTest {
    public static void main(String[] args) {
        Phone[] arr = new Phone[3];

        Phone p1 = new Phone("小米", 1999, "白色");
        Phone p2 = new Phone("华为", 3999, "灰色");
        Phone p3 = new Phone("苹果", 8999, "黑色");

        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;

        // 获取三部手机的价格并且累加
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].getPhonePrice();
        }

        // 输出平均值
        System.out.println(sum / arr.length);
    }
}
