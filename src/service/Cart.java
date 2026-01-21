package rustam;
public class Cart implements Payable {

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

    public void addProduct(Product product, int amount) {
        if (product.updateQuantity(amount)) {
            quantity += amount;
            totalPrice += product.getPrice() * amount;
            System.out.println(amount + " " + product.getName() + " added to cart");
        } else {
            System.out.println("Not enough " + product.getName());
        }
    }
    public boolean canBuy() {
        return balance >= totalPrice;
    }
    public Receipt buyWithReceipt() {
        if (canBuy()) {
            balance -= totalPrice;

            Receipt receipt = new Receipt(
                    name,
                    quantity,
                    totalPrice,
                    balance
            );

            System.out.println("Purchase successful!");
            totalPrice = 0;
            quantity = 0;

            return receipt;
        } else {
            System.out.println("Not enough money!");
            return null;
        }
    }


    @Override
    public boolean canPay() {
        return balance >= totalPrice;
    }

    @Override
    public Receipt pay() {
        if (!canPay()) {
            System.out.println("Not enough money!");
            return null;
        }

        balance -= totalPrice;

        Receipt receipt = new Receipt(
                name,
                quantity,
                totalPrice,
                balance
        );

        totalPrice = 0;
        quantity = 0;

        return receipt;
    }
}
