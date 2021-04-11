package JavaMarkt;

import java.util.Arrays;

public class discount30PercentOffSmartphone implements IDiscount {
    @Override
    public void applyDiscount(Cart cart) {
        if (Arrays.stream(cart.getProducts())
                .anyMatch(p -> p.getName().equals("Smartphone"))) {
            Arrays.stream(cart.getProducts())
                    .forEach(p -> p.setDiscountPrice(p.getName().equals("Smartphone")
                            ? p.getDiscountPrice() - (p.getPrice() * 0.3)
                            : p.getDiscountPrice()));
        }
    }
}
