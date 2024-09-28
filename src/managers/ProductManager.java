package managers;

import entities.Product;
import test.DemoProducts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {

    private static ProductManager instance;

    private final List<Product> products;

    private ProductManager() {
        this.products = new ArrayList<>();

        // Add products for testing purpose
        DemoProducts.addProducts(products);
    }

    public void addProductInPrompt() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Product name: ");
                String name = scanner.nextLine();

                System.out.print("Product price: ");
                double price = Double.parseDouble(scanner.nextLine());

                Product product = new Product(name, price);
                this.products.add(product);
                System.out.println("Added a new product!");

                break;
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public void displayProducts() {
        for (Product product : products) {
            product.displayInfo();
        }
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }
}
