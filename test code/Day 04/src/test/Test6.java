package test;

/*
假设有一张足够大得纸，厚度为0.1毫米，折叠多少次，可以超过珠穆朗玛峰的高度（8848.53米）
*/

public class Test6 {
    public static void main(String[] args) {
        // 珠穆朗玛峰的高度(8848.53米)
        double height = 8848530;
        // 纸的厚度(0.1毫米)
        double paper = 0.1;
        // 循环(纸张折叠)次数
        int count = 0;
        while(height > paper) {
            // 折纸
            paper *= 2;
            // 折一次加一次
            count++;
        }
        // 输出结果
        System.out.println("折叠 " + count + " 次，可以超过珠穆朗玛峰的高度");
    }
}
