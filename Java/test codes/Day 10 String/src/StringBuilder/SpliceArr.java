package StringBuilder;

public class SpliceArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(arrToString(arr));
    }

    // 把数组拼接成字符串的方法
    public static String arrToString(int[] arr) {
        // 创建StringBuilder对象
        StringBuilder sb = new StringBuilder();

        // 字符串开头
        sb.append("[");

        // 将数组中的元素一一拼接
        for (int i = 0; i < arr.length; i++) {
            // 如果不是数组最后一个元素就加间隔符
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        // 字符串结尾
        sb.append("]");

        // 转为字符串返回
        return sb.toString();
    }
}
