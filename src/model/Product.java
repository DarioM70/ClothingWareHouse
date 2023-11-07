package model;

public abstract class Product {
    private String id;
    private int price;

    public Product(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getInfo() {
        return "Product{" +
                "id='" + id + '\n' +
                ", price=" + price;
    }

    abstract void calculatePrice();
}
