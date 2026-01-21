package service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private ArrayList<Product> products = new ArrayList<>();
    private Cart cart = new Cart("Rustam", 12000);
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
        // test data
        products.add(new FoodProduct(1, "Milk", 80, 5, "2026-01-15"));
        products.add(new FoodProduct(2, "Banana", 120, 10, "2026-01-20"));
    }

    public void start() {
        boolean running = true;

        while (running) {
            showMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addProduct();
                    case 2 -> viewProducts();
                    case 3 -> addToCart();
                    case 4 -> buy();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Add product");
        System.out.println("2. View products");
        System.out.println("3. Add to cart");
        System.out.println("4. Buy");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    private void addProduct() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Expiration date: ");
            String date = scanner.nextLine();

            products.add(new FoodProduct(id, name, price, qty, date));
            System.out.println("Product added");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            scanner.nextLine();
        }
    }

    private void viewProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private void addToCart() {
        System.out.print("Product ID: ");
        int id = scanner.nextInt();

        System.out.print("Amount: ");
        int amount = scanner.nextInt();

        for (Product p : products) {
            if (p.getId() == id) {
                cart.addProduct(p, amount);
                return;
            }
        }
        System.out.println("Product not found");
    }

    private void buy() {
        Receipt receipt = cart.buyWithReceipt();
        if (receipt != null) {
            System.out.println(receipt);
        }
    }
}
