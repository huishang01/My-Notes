package BookSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BookSystem {
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("-----欢迎来到图书管理-----");
            System.out.println("1: 添加图书");
            System.out.println("2: 列出所有图书");
            System.out.println("3: 查询图书信息");
            System.out.println("4: 删除图书");
            System.out.println("5: 修改图书信息");
            System.out.println("6: 退出");
            System.out.println("请输入你的选项：");

            String choose = sc.next();
            switch (choose) {
                case "1" -> addBook(list); // 添加图书
                case "2" -> selectBook(list); // 列出所有图书
                case "3" -> checkBook(list); // 根据图书ID查询该图书信息
                case "4" -> delBook(list); // 根据图书ID删除图书;
                case "5" -> setBook(list); // 根据图书ID修改图书信息
                case "6" -> {
                    System.out.println("退出成功！");
                    break loop;
                }
                default -> System.out.println("输入不合法！");
            }
            System.out.println();
        }
    }

    // 根据图书ID修改图书信息的方法
    public static void setBook(ArrayList<Book> list) {
        Scanner sc = new Scanner(System.in);
        if (list.size() == 0) {
            System.out.println("你还未添加图书！");
        } else {
            loop:
            while (true) {
                System.out.println("请输入要修改的图书ID：");
                String id = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId().equals(id)) {
                        System.out.println("请输入新的书名：");
                        list.get(i).setName(sc.next());
                        System.out.println("请输入新的作者：");
                        list.get(i).setAuthor(sc.next());
                        System.out.println("请输入新的价格：");
                        list.get(i).setPrice(sc.next());
                        System.out.println("修改成功！");
                        break loop;
                    }
                }
                System.out.println("该图书不存在！");
            }
        }
    }

    // 根据图书ID删除图书的方法
    public static void delBook(ArrayList<Book> list) {
        Scanner sc = new Scanner(System.in);
        if (list.size() == 0) {
            System.out.println("你还未添加图书！");
        } else {
            loop:
            while (true) {
                System.out.println("请输入要删除的图书ID：");
                String id = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId().equals(id)) {
                        list.remove(i);
                        System.out.println("删除成功！");
                        break loop;
                    }
                }
                System.out.println("该图书不存在！");
            }
        }
    }

    // 根据图书ID查询该图书信息的方法
    public static void checkBook(ArrayList<Book> list) {
        Scanner sc = new Scanner(System.in);
        if (list.size() == 0) {
            System.out.println("你还未添加图书！");
        } else {
            loop:
            while (true) {
                System.out.println("请输入要查询的图书ID：");
                String id = sc.next();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId().equals(id)) {
                        System.out.println("ID\t\t\t书名\t\t作者\t\t价格");
                        System.out.println(list.get(i).toString());
                        break loop;
                    }
                }
                System.out.println("该图书不存在！");
            }
        }
    }

    // 列出所有图书的方法
    public static void selectBook(ArrayList<Book> list) {
        System.out.println("ID\t\t\t书名\t\t作者\t\t价格");
        if (list.size() == 0) {
            System.out.println("你还未添加图书！");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        }
    }

    // 添加图书的方法
    public static void addBook(ArrayList<Book> list) {
        Scanner sc = new Scanner(System.in);
        Book b = new Book();

        while (true) {
            System.out.println("请输入图书ID：");
            String id = sc.next();
            if (index(list, id) >= 0) {
                System.out.println("该图书已存在！");
            } else {
                b.setId(id);
                break;
            }
        }
        System.out.println("请输入书名：");
        b.setName(sc.next());
        System.out.println("请输入作者：");
        b.setAuthor(sc.next());
        System.out.println("请输入价格：");
        b.setPrice(sc.next());

        list.add(b);
        System.out.println("添加成功！");
    }

    // 根据id返回图书索引的方法
    public static int index(ArrayList<Book> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
