package rustam;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Product> products = new ArrayList<>();
    private static Cart cart = new Cart("Rustam", 12000);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Initial test data
        products.add(new Product(1, "Banana", 124.1, 10));
        products.add(new FoodProduct(2, "Milk", 80.0, 5, "2026-01-15"));

        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    addToCart();
                    break;
                case 4:
                    buy();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // Жай меню
    private static void showMenu() {
        System.out.println("\n=== GROCERY STORE SYSTEM ===");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Add Product to Cart");
        System.out.println("4. Buy");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    // Товар косу
    private static void addProduct() {
        System.out.println("\n--- ADD PRODUCT ---");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        products.add(new Product(id, name, price, quantity));
        System.out.println("Product added successfully!");
    }

    // Барлык продукт
    private static void viewAllProducts() {
        System.out.println("\n--- ALL PRODUCTS ---");

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }

    //Корзинага косу
    private static void addToCart() {
        viewAllProducts();

        System.out.print("\nEnter product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter amount: ");
        int amount = scanner.nextInt();

        for (Product p : products) {
            if (p.getId() == id) {
                cart.addProduct(p, amount);
                return;
            }
        }

        System.out.println("Product not found!");
    }

    // Сатып алу
    private static void buy() {
        Receipt receipt = cart.buyWithReceipt();
        if (receipt != null) {
            System.out.println(receipt);
        }
    }
}
