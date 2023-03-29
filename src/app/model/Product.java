package app.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String productName;
    private String manufacture;
    private float price;
    private String description;

    public Product(int id, String productName, String manufacture, float price, String description) {
        this.id = id;
        this.productName = productName;
        this.manufacture = manufacture;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
