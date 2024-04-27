package StringDemo;

public class InvertString {
    public static void main(String[] args) {
        // 创建一个字符串
        String str = "123456";
        // 打印已反转的字符串
        System.out.println(invertString(str));
    }

    // 反转字符串的方法
    public static String invertString(String str) {
        String result = "";
        // 从字符串最后一个索引遍历得到每一个元素
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            // 拼接字符
            result += c;
        }
        // 返回拼接好的，已反转的字符串
        return result;
    }
}
