package JavaMarkt;

public class JavaMarkt {
    public static void main(String[] args) {
        Cart myCart = new Cart();

        myCart.add(new Product("Smartphone", 2500));
        myCart.add(new Product("Laptop", 3000));
        myCart.add(new Product("Iron", 150));
        myCart.add(new Product("Microwave", 400));
        myCart.add(new Product("Dishwasher", 1500));
        myCart.add(new Product("Headphones", 150));

        myCart.addDiscount(new discount5PercentOff300());
        myCart.addDiscount(new discountBuy3Get1ForFree());
        myCart.addDiscount(new discountGetFreeMugOver200());
        myCart.addDiscount(new discount30PercentOffSmartphone());

        myCart.summary();
    }
}
