package rustam;

public class Main {
    public static void main(String[] args) {

        Product banana = new Product();
        banana.setId(124124);
        banana.setName("Banana");
        banana.setPrice(124.1);
        banana.setQuantity(5);

        Product apple = new Product();
        apple.setId(124124901);
        apple.setName("Apple");
        apple.setPrice(70.8);
        apple.setQuantity(10);

        Cart user1 = new Cart();
        user1.setName("Rustam");
        user1.setBalance(12083.8);

        user1.addProduct(banana, 2);
        user1.addProduct(apple, 3);

        System.out.println("\n--- Cart ---");
        System.out.println(user1);

        user1.buy();

        System.out.println("\n--- Products left ---");
        System.out.println(banana);
        System.out.println(apple);
    }
}
