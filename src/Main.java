package rustam;

public class Main {
    public static void main(String[] args) {

        Product banana = new Product(124124, "Banana", 124.1, 5);
        Product apple = new Product(124124901, "Apple", 70.8, 10);

        Cart user1 = new Cart("Rustam", 12083.8);

        user1.addProduct(banana, 2);
        user1.addProduct(apple, 3);

        System.out.println("\n--- Cart ---");
        System.out.println(user1);

        System.out.println("\n--- Purchase ---");
        user1.buy();

        System.out.println("\n--- Products left ---");
        System.out.println(banana);
        System.out.println(apple);
    }
}
