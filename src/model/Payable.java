package model;
public interface Payable {
    boolean canPay();
    Receipt pay();
}
