package Test;

// 现有如下文本：
// "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的"。
// 请编写程序，统计该文本中"Java"一词出现的次数。

public class StringCount {
    public static void main(String[] args) {
        String text = "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的";
        String word = "Java";

        System.out.println("出现次数：" + countOccurrences(text, word));
    }

    // 统计文本中指定单词出现的次数的方法
    public static int countOccurrences(String text, String word) {
        int count = 0;  // 用于记录出现的次数
        int index = 0;  // 用于记录单词查找的起始索引

        while (true) {
            index = text.indexOf(word, index);  // 使用 indexOf() 方法查找文本中指定单词的位置
            if (index != -1) {  // 如果找到了
                count++;  // 计数器+1
                index += word.length();  // 把起始索引移动到下一个位置
            } else {
                break;  // 没找到就跳出循环
            }
        }

        return count;  // 返回单词出现的次数
    }
}
