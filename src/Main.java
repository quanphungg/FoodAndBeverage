import managers.BillManager;
import managers.ProductManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int mode;
        ProductManager productManager = ProductManager.getInstance();
        BillManager billManager = BillManager.getInstance();
        do {
            printMenu();
            System.out.print("Entering mode: ");
            Scanner scanner = new Scanner(System.in);
            mode = scanner.nextInt();

            switch (mode) {
                case 1:
                    billManager.createBillInPrompt();
                    break;
                case 2:
                    billManager.printBills();
                    break;
                case 3:
                    productManager.addProductInPrompt();
                    break;
                case 4:
                    productManager.displayProducts();
                    break;
                default:
                    break;
            }
        } while (mode != 7);
    }

    private static void printMenu() {
        System.out.println("PLEASE CHOOSE A MODE TO CONTINUE");

        System.out.println("1) Make a bill");
        System.out.println("2) Print all bills");
        System.out.println("3) Add new product");
        System.out.println("4) Display products");
        System.out.println("7) Exit");
    }
}