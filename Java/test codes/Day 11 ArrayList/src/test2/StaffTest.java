package test2;

// 有如下员工信息：

// 姓名：张三，工资：3000
// 姓名：李四，工资：3500
// 姓名：王五，工资：4000
// 姓名：赵六，工资：4500
// 姓名：田七，工资：5000

// 先需要将所有的员工信息都存入ArrayList集合中，并完成如下操作：
// 1、判断是否有姓名为“王五”的员工，如果有，改名为“王小五”
// 2、判断是否有姓名为“赵六”的员工，如果有，将其删除
// 3、给姓名为“田七”的员工，涨500工资

import java.util.ArrayList;

public class StaffTest {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<Staff> list = new ArrayList<>();

        // 存入员工信息
        list.add(new Staff("张三", 3000));
        list.add(new Staff("李四", 3500));
        list.add(new Staff("王五", 4000));
        list.add(new Staff("赵六", 4500));
        list.add(new Staff("田七", 5000));

        // 遍历集合得到每一个员工的信息
        for (int i = 0; i < list.size(); i++) {
            // 判断是否有姓名为“王五”的员工，如果有，改名为“王小五”
            if (list.get(i).getName().equals("王五")) {
                list.get(i).setName("王小五");
            }
            // 判断是否有姓名为“赵六”的员工，如果有，将其删除
            if (list.get(i).getName().equals("赵六")) {
                list.remove(i);
            }

            // 给姓名为“田七”的员工，涨500工资
            if (list.get(i).getName().equals("田七")) {
                list.get(i).setWage(list.get(i).getWage() + 500);
            }
        }

        // 遍历集合打印每个员工的信息
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
