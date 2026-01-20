package rustam;

public interface Payable {
    boolean canPay();
    Receipt pay();
}
