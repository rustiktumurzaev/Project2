package rustam;

public class Cart {
    public int id;
    public String name;
    public int quantity;
    public double balance;
    public double allofprice;
    public String want;
    public String information(){
        return "Name: "+name+ " Balance: "+balance+" Want "+want +"Quantity  "+quantity;
    }

}
