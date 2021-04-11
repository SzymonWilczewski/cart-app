package JavaMarkt;

import java.util.Arrays;

public class discountBuy3Get1ForFree implements IDiscount {
    @Override
    public void applyDiscount(Cart cart) {
        int len = cart.getProducts().length;
        if (len > 2) {
            Arrays.stream(cart.getTheCheapest(len / 3))
                    .forEach(p -> p.setDiscountPrice(0));
//            cart.getTheCheapest().setDiscountPrice(0);
        }
    }
}
