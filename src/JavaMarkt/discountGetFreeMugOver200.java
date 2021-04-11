package JavaMarkt;

public class discountGetFreeMugOver200 implements IDiscount {
    @Override
    public void applyDiscount(Cart cart) {
        if (cart.total() >= 200) {
            cart.add(new Product("Mug", 0));
        }
    }
}
