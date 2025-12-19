package rustam;

public class Main {
    public static void main(String[] args) {

        Product banana = new Product();
        banana.id = 124124;
        banana.name = "Banana";
        banana.price = 124.1;
        banana.quantity = 5;
        Product apple = new Product();
        apple.id = 124124901;
        apple.name = "Apple";
        apple.price = 70.8;
        apple.quantity = 10;
        if (banana.updateQuantity(3)) {
            System.out.println(banana.getInfo());

        } else {
            System.out.println("Error: not enough quantity");
        }
        if (apple.updateQuantity(8)) {
            System.out.println(apple.getInfo());

        } else {
            System.out.println("Error: not enough quantity");
        }
        Cart user1 = new Cart();
        user1.name="Rustam";
        user1.balance=12083.8;
        user1.want="Banana and Apple";
        user1.quantity=4;
        System.out.println(user1.information());

        System.out.println("Hou much do you want: " +user1.quantity);
        if(user1.balance >=(banana.price + apple.price)){
            System.out.println("You may buy");
        }else{
            System.out.println("You can't");
        }


    }
}