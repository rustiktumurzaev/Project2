package rustam;

public class Receipt {

    private String customerName;
    private int totalItems;
    private double totalPaid;
    private double balanceLeft;

    public Receipt(String customerName, int totalItems, double totalPaid, double balanceLeft) {
        this.customerName = customerName;
        this.totalItems = totalItems;
        this.totalPaid = totalPaid;
        this.balanceLeft = balanceLeft;
    }

    @Override
    public String toString() {
        return "\n--- RECEIPT ---\n" +
                "Customer: " + customerName + "\n" +
                "Items bought: " + totalItems + "\n" +
                "Total paid: " + totalPaid + "\n" +
                "Balance left: " + balanceLeft + "\n";
    }
}
