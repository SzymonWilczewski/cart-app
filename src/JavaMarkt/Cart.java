package JavaMarkt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Cart {
    private Product[] products = new Product[0];
    private IDiscount[] discounts = new IDiscount[0];

    Comparator<Product> priceAsc = Comparator.comparing(Product::getDiscountPrice);
    Comparator<Product> priceDesc = Comparator.comparing(Product::getDiscountPrice).reversed();
    Comparator<Product> nameAsc = Comparator.comparing(Product::getName);
    Comparator<Product> nameDesc = Comparator.comparing(Product::getName).reversed();
    Comparator<Product> priceDescNameAsc = priceDesc.thenComparing(nameAsc);

    public void add(Product product) {
        products = Stream.concat(Stream.of(products), Stream.of(product))
                .toArray((IntFunction<Product[]>) Product[]::new);
    }

    public void delete(Product product) {
        products = Arrays.stream(products)
                .filter(p -> !p.equals(product))
                .toArray((IntFunction<Product[]>) Product[]::new);
    }

    public Product getTheCheapest() {
        return Arrays.stream(products)
                .min(priceAsc)
                .orElse(null);
    }

    public Product getTheMostExpensive() {
        return Arrays.stream(products)
                .max(priceAsc)
                .orElse(null);
    }

    public Product[] getTheCheapest(int n) {
        return Arrays.stream(products)
                .sorted(priceAsc)
                .limit(n)
                .toArray((IntFunction<Product[]>) Product[]::new);
    }

    public Product[] getTheMostExpensive(int n) {
        return Arrays.stream(products)
                .sorted(priceDesc)
                .limit(n)
                .toArray((IntFunction<Product[]>) Product[]::new);
    }

    public Product[] sort(Comparator<Product> comparator) {
        return Arrays.stream(products)
                .sorted(comparator)
                .toArray((IntFunction<Product[]>) Product[]::new);
    }

    public double total() {
        return Arrays.stream(products)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public double totalWithDiscounts() {
        return Arrays.stream(products)
                .mapToDouble(Product::getDiscountPrice)
                .sum();
    }

    public void summary() {
        this.applyDiscounts();
        Arrays.stream(products)
                .forEach(p -> System.out.println(p.getName() + " - " + p.getDiscountPrice()));
        System.out.println("Total: " + this.totalWithDiscounts());
    }

    public void summary(Comparator<Product> comparator) {
        this.applyDiscounts();
        Arrays.stream(sort(comparator))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getDiscountPrice()));
        System.out.println("Total: " + this.totalWithDiscounts());
    }

    public void addDiscount(IDiscount discount) {
        discounts = Stream.concat(Stream.of(discounts), Stream.of(discount))
                .toArray((IntFunction<IDiscount[]>) IDiscount[]::new);
    }

    public void deleteDiscount(IDiscount discount) {
        discounts = Arrays.stream(discounts)
                .filter(d -> !d.equals(discount))
                .toArray((IntFunction<IDiscount[]>) IDiscount[]::new);
    }

    public void applyDiscounts() {
        Arrays.stream(discounts).forEach(d -> d.applyDiscount(this));
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
