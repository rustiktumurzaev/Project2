package rustam;

public class FoodProduct extends Product {

    private String expirationDate;

    public FoodProduct(int id, String name, double price, int quantity, String expirationDate) {
        super(id, name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
