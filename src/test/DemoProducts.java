package test;

import entities.Product;

import java.util.List;

public class DemoProducts {

    public static void addProducts(List<Product> productList) {
        Product bubbleTea = new Product("Bubble Tea", 20000);
        Product orangeJuice = new Product("Orange Juice", 15000);
        Product coffee = new Product("Coffee", 25000);

        productList.add(bubbleTea);
        productList.add(orangeJuice);
        productList.add(coffee);
    }
}
