package BookSystem;

public class Book {
    private String id;
    private String name;
    private String author;
    private String price;

    public Book() {
    }

    public Book(String id, String name, String author, String price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String number) {
        this.id = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String toString() {
        return id + "\t\t" + name + "\t" + author + "\t" + price;
    }
}
