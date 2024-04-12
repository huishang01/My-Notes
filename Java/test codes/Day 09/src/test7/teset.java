package test7;

        /*定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号，姓名各不相同。
        学生的属性：学号，姓名，年龄。
        要求1：再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
        要求2：添加完毕之后，遍历所有学生信息。
        要求3：通过id删除学生信息
        如果存在，则删除，如果不存在，则提示删除失败。
        要求4：删除完毕之后，遍历所有学生信息。
        要求5：查询数组id为“2”的学生，如果存在，则将他的年龄+1岁*/

public class teset {
    public static void main(String[] args) {
        // 创建数组存储学生对象
        Student[] arr = new Student[3];
        // 创建学生对象
        Student std1 = new Student(1, "户山香澄", 16);
        Student std2 = new Student(2, "花园多惠", 16);
        Student std3 = new Student(3, "市谷有咲", 16);
        // 把学生对象添加到数组中
        arr[0] = std1;
        arr[1] = std2;
        arr[2] = std3;

        // 添加一个学生对象
        Student std4 = new Student(4, "牛込里美", 16);

        // 调用方法对 std4 进行唯一性判断，若不存在，则添加到数组中
        if (contains(arr, std4.getId())) {
            // 已存在，提示重新填写
            System.out.println("ID 重复，请重新填写！");
        } else {
            // 不存在，添加到数组中
            int count = getCount(arr);
            if (count == arr.length) {
                // 数组已存满，则把 std4 添加到新数组中
                Student[] newArr = getNewArr(arr);
                newArr[count] = std4;
                printArr(newArr);
            } else {
                // 数组未存满，则把 std4 添加到空索引的位置
                arr[count] = std4;
                printArr(arr);
            }
        }

        // 通过id删除学生信息
        delete(arr, 1);
        printArr(arr);

        // 查询数组id为“2”的学生，如果存在，则将他的年龄+1岁
        sumAgeOne(arr, 2);
        printArr(arr);
    }

    // 年龄+1的方法
    public static void sumAgeOne(Student[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            Student std = arr[i];
            if (std != null) {
                if (id == arr[i].getId()) {
                    int age = std.getAge() + 1;
                    std.setAge(age);
                    System.out.println();
                }
            }
        }
    }

    // 通过id删除学生信息的方法
    public static void delete(Student[] arr, int id) {
        // 获取每个学生信息
        for (int i = 0; i < arr.length; i++) {
            // 如果该学生的id和获得的id一样，则存在
            if (id == arr[i].getId()) {
                // 若存在，则删除
                arr[i] = null;
                System.out.println();
                System.out.println("删除成功");
                break;
            } else {
                // 若不存在，则提示删除失败
                System.out.println();
                System.out.println("删除失败");
            }
        }
    }

    // 遍历打印数组的方法
    public static void printArr(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i].toString());
            }
        }
    }

    // 创建一个把老数组的长度增加一个的新数组，然后把老数组添加到新数组中
    public static Student[] getNewArr(Student[] arr) {
        Student[] newArr = new Student[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    // 统计数组中元素的数量的方法，数量 = 空索引的位置
    public static int getCount(Student[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
        return count;
    }

    // 学号的唯一性判断的方法
    public static boolean contains(Student[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            Student std = arr[i];
            if (std != null){
                if (std.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }
}