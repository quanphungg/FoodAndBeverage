package entities;

import java.util.Date;
import java.util.List;

public class Bill {

    private final long id;
    private final Date createdDateTime;

    // Has-a relationship, this bill consists of products
    private final List<Product> products;

    public Bill(List<Product> products) {
        this.id = System.currentTimeMillis();
        this.createdDateTime = new Date();

        this.products = products;
    }

    public long getId() {
        return id;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void print() {
        double total = products.stream().mapToDouble(Product::getPrice).sum();

        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("Invoice information:");
        System.out.println("ID: " + this.id);
        System.out.println("Created: " + this.createdDateTime.toString());
        System.out.println("Customer: Unknown");
        System.out.println("Products:");

        for (Product product : products) {
            System.out.print("\t");
            product.displayInfo();
        }

        System.out.println("Total: " + total);
        System.out.println("Goodbye, see you later!");
        System.out.println("--------------------------------------------");
        System.out.println();
    }
}
