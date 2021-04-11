package JavaMarkt;

import java.util.Arrays;

public class discount5PercentOff300 implements IDiscount {
    @Override
    public void applyDiscount(Cart cart) {
        if (cart.total() >= 300) {
            Arrays.stream(cart.getProducts())
                    .forEach(p -> p.setDiscountPrice(p.getDiscountPrice() - (p.getPrice() * 0.05)));
        }
    }
}
