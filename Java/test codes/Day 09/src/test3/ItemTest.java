package test3;

public class ItemTest {
    public static void main(String[] args) {
        // 创建一个动态数组以存储下面 3 个商品对象
        Item[] arr = new Item[3];

        // 创建 3 个商品对象
        Item i1 = new Item(001, "APEX", 0, 999);
        Item i2 = new Item(002, "CS2", 0, 999);
        Item i3 = new Item(003, "BATTLEFIELD 2042", 38, 999);

        // 把 3 个商品对象赋值给数组
        arr[0] = i1;
        arr[1] = i2;
        arr[2] = i3;

        // 把 arr 里的元素的地址值赋值给新建的对象 I，这样打印出来的就是具体数值而不是地址值
        for (int i = 0; i < arr.length; i++) {
            Item I = arr[i];
            System.out.println(I.getItemID() + ", " + I.getItemName() + ", " + I.getItemPrise() + ", " + I.getItemStock());
        }
    }
}
