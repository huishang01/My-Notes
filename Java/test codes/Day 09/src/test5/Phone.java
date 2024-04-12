package test5;

public class Phone {
    private String phoneBrand;
    private int phonePrice;
    private String phoneColor;

    public Phone() {

    }

    public Phone(String phoneBrand, int phonePrice, String phoneColor) {
        this.phoneBrand = phoneBrand;
        this.phonePrice = phonePrice;
        this.phoneColor = phoneColor;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public int getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(int phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getPhoneColor() {
        return phoneColor;
    }

    public void setPhoneColor(String phoneColor) {
        this.phoneColor = phoneColor;
    }
}
