package rustam;

public class Product {
    public int id, quantity;
    public String name;
    public double price;


    public String getInfo() {
        return "Id: " + id +
                " Name: " + name +
                " Price: " + price +
                " Quantity: " + quantity ;

    }

    public boolean updateQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            return true;
        } else {
            return false;
        }
    }
}