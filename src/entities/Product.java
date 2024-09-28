package entities;

public class Product {

    private static long counter = 0;

    private final long id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = counter++;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " Name: " + name + " Price: " + price);
    }
}
