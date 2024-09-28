package managers;

import entities.Bill;
import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillManager {

    private static BillManager billManager;

    private final List<Bill> bills;

    private BillManager() {
        this.bills = new ArrayList<>();
    }

    public void createBillInPrompt() {
        List<Product> cart = new ArrayList<>();
        Bill bill = new Bill(cart);
        int mode;

        do {
            printModes();
            System.out.print("Mode: ");
            Scanner scanner = new Scanner(System.in);
            mode = Integer.parseInt(scanner.nextLine());

            switch (mode) {
                case 1:
                    this.addProductToCartInPrompt(cart);
                    break;
                case 2:
                    break;
                case 3:
                    bill.print();
                    break;
                default:
                    System.out.println("Please provide a mode between 1..3");
                    System.out.print("Re-entering: ");
                    break;
            }
        } while (mode != 3);

        this.bills.add(bill);
    }

    private void addProductToCartInPrompt(List<Product> cart) {
        ProductManager productManager = ProductManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        Product product;

        do {
            productManager.displayProducts();
            System.out.println("Please type in id: ");
            int id = Integer.parseInt(scanner.nextLine());
            product = productManager.getProductById(id);

            if (product == null) {
                System.out.println("Product is no valid, please try again");
            }
        } while (product == null);

        cart.add(product);
    }

    public void printModes() {
        System.out.println("Please choose a mode:");
        System.out.println("1) Add product");
        System.out.println("2) Remove product");
        System.out.println("3) Print out the bill");
    }

    public void printBills() {
        for(Bill b : bills) {
            b.print();
        }
    }

    public static BillManager getInstance() {
        if (billManager == null) {
            billManager = new BillManager();
        }
        return billManager;
    }
}
