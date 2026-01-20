

import model.FoodProduct;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<Product> products = new ArrayList<>();
    private static Cart cart = new Cart("Rustam", 12000);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        products.add(new FoodProduct(1, "Milk", 80.0, 5, "2026-01-15"));
        products.add(new FoodProduct(2, "Cheese", 450.0, 3, "2026-02-10"));

        boolean running = true;

        while (running) {
            showMenu();

            try {
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

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a number!");
                scanner.nextLine();
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    //  Меню
    private static void showMenu() {
        System.out.println("\n=== GROCERY STORE SYSTEM ===");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Add Product to Cart");
        System.out.println("4. Buy");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    //  Товар косу
    private static void addProduct() {
        try {
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
            scanner.nextLine();

            System.out.print("Expiration date: ");
            String date = scanner.nextLine();

            products.add(new FoodProduct(id, name, price, quantity, date));
            System.out.println("Product added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Product not added.");
            scanner.nextLine();
        }
    }

    // Букил затты кору
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

    // Корзинага косу
    private static void addToCart() {
        try {
            viewAllProducts();

            System.out.print("\nEnter product ID: ");
            int id = scanner.nextInt();

            System.out.print("Enter amount: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            for (Product p : products) {
                if (p.getId() == id) {
                    cart.addProduct(p, amount);
                    return;
                }
            }

            System.out.println("Product not found!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input!");
            scanner.nextLine();
        }
    }

    // Сатып алу
    private static void buy() {
        Receipt receipt = cart.pay();
        if (receipt != null) {
            System.out.println(receipt);
        }
    }
}
