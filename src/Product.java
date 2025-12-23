package rustam;

public class Product {

    private int id;
    private String name;
    private double price;
    private int quantity;

    // Parameter constructor
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { if (price > 0) this.price = price; }
    public void setQuantity(int quantity) { if (quantity >= 0) this.quantity = quantity; }

    public boolean updateQuantity(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
