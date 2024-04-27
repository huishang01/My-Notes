package StringDemo;

public class ArrToString {
    public static void main(String[] args) {
        // 创建一个数组
        int[] arr = {1, 2, 3, 4, 5};
        // 调用拼接成字符串的方法并打印
        System.out.println(arrToString(arr));
    }

    // 拼接成字符串的方法
    public static String arrToString(int[] arr) {
        // 如果数组为空，则返回空白
        if (arr == null) {
            return "";
        }

        // 如果数组长度为0，则返回 []
        if (arr.length == 0) {
            return "[]";
        }

        // 字符串的开头
        String result = "[";
        // 遍历数组得到每个元素
        for (int i = 0; i < arr.length; i++) {
            // 如果是最后一个元素则不加间隔符
            if (i == arr.length - 1) {
                result += arr[i];
            } else {
                result += arr[i] + ", ";
            }
        }
        // 字符串的结尾
        return result += "]";
    }
}
