package JavaMarkt;

import java.util.UUID;

public class Product {
    private final String code = UUID.randomUUID().toString();
    private String name;
    private double price;
    private double discountPrice;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public String getCode() { return code; }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public double getDiscountPrice() { return discountPrice; }

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) { this.price = price; }

    public void setDiscountPrice(double discountPrice) { this.discountPrice = discountPrice; }
}
