package rustam;

public class Cart {


    private String name;
    private int quantity;
    private double balance;
    private double totalPrice;

    public Cart(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.quantity = 0;
        this.totalPrice = 0.0;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getBalance() { return balance; }
    public double getTotalPrice() { return totalPrice; }

    public void setName(String name) { this.name = name; }
    public void setBalance(double balance) { if (balance >= 0) this.balance = balance; }

    public void addProduct(Product product, int amount) {
        if (product.updateQuantity(amount)) {
            quantity += amount;
            totalPrice += product.getPrice() * amount;
            System.out.println(amount + " " + product.getName() + " added to cart");
        } else {
            System.out.println("Not enough " + product.getName());
        }
    }

    public boolean canBuy() { return balance >= totalPrice; }

    // --- Buy ---
    public void buy() {
        if (canBuy()) {
            balance -= totalPrice;
            System.out.println("Purchase successful!");
            totalPrice = 0;
            quantity = 0;
        } else {
            System.out.println("Not enough money!");
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", balance=" + balance +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
