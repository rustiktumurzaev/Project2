
public interface Payable {
    boolean canPay();
    Receipt pay();
}
