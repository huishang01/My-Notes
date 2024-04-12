package test3;

public class Item {
    private int itemID;
    private String itemName;
    private int itemPrise;
    private int itemStock;

    public Item() {

    }

    public Item(int itemID, String itemName, int itemPrise, int itemStock) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrise = itemPrise;
        this.itemStock = itemStock;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrise() {
        return itemPrise;
    }

    public void setItemPrise() {
        this.itemPrise = itemPrise;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock() {
        this.itemStock = itemStock;
    }
}
