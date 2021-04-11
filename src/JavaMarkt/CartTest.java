package JavaMarkt;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    public void testAdd() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        cart.add(smartphone);
        assertEquals(smartphone, cart.getProducts()[0]);
    }

    @Test
    public void testDelete() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        cart.delete(smartphone);
        assertEquals(1, cart.getProducts().length);
    }

    @Test
    public void testGetTheCheapest() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        assertEquals(tablet, cart.getTheCheapest());
    }

    @Test
    public void testGetTheMostExpensive() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        assertEquals(smartphone, cart.getTheMostExpensive());
    }

    @Test
    public void testGetTheCheapestN() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        Product headphones = new Product("Headphones", 150);
        cart.add(smartphone);
        cart.add(tablet);
        cart.add(headphones);
        assertEquals(2, cart.getTheCheapest(2).length);
    }

    @Test
    public void testGetTheMostExpensiveN() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        Product headphones = new Product("Headphones", 500);
        cart.add(smartphone);
        cart.add(tablet);
        cart.add(headphones);
        assertEquals(2, cart.getTheMostExpensive(2).length);
    }

    @Test
    public void testSortPriceAscending() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2000);
        Product tablet = new Product("Tablet", 1500);
        Product headphones = new Product("Headphones", 150);
        cart.add(smartphone);
        cart.add(tablet);
        cart.add(headphones);
        assertEquals(headphones, cart.sort(cart.priceAsc)[0]);
    }

    @Test
    public void testSortPriceDescending() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1000);
        Product headphones = new Product("Headphones", 150);
        cart.add(smartphone);
        cart.add(tablet);
        cart.add(headphones);
        assertEquals(smartphone, cart.sort(cart.priceDesc)[0]);
    }

    @Test
    public void testSortNameAscending() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        Product headphones = new Product("Headphones", 100);
        cart.add(smartphone);
        cart.add(tablet);
        cart.add(headphones);
        assertEquals(headphones, cart.sort(cart.nameAsc)[0]);
    }

    @Test
    public void testSortNameDescending() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2200);
        Product tablet = new Product("Tablet", 1500);
        Product headphones = new Product("Headphones", 150);
        cart.add(smartphone);
        cart.add(tablet);
        cart.add(headphones);
        assertEquals(tablet, cart.sort(cart.nameDesc)[0]);
    }

    @Test
    public void testSortPriceDescendingNameAscending() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 1500);
        Product tablet = new Product("Tablet", 1500);
        Product headphones = new Product("Headphones", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        cart.add(headphones);
        assertEquals(headphones, cart.sort(cart.priceDescNameAsc)[0]);
    }

    @Test
    public void testTotal() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        assertEquals(4000, cart.total());
    }

    @Test
    public void testTotalWithDiscounts() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        cart.addDiscount(new discount5PercentOff300());
        cart.applyDiscounts();
        assertEquals(3800, cart.totalWithDiscounts());
    }

    @Test
    public void testSummary() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1000);
        cart.add(smartphone);
        cart.add(tablet);
        cart.summary();
        assertEquals(3500, cart.totalWithDiscounts());
    }

    @Test
    public void testSummaryWithSort() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 1500);
        Product tablet = new Product("Tablet", 1000);
        cart.add(smartphone);
        cart.add(tablet);
        cart.summary(cart.priceAsc);
        assertEquals(2500, cart.totalWithDiscounts());
    }

    @Test
    public void testAddDiscount() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1000);
        cart.add(smartphone);
        cart.add(tablet);
        cart.addDiscount(new discount5PercentOff300());
        cart.applyDiscounts();
        assertEquals(3325, cart.totalWithDiscounts());
    }

    @Test
    public void testDeleteDiscount() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        IDiscount discountMug = new discountGetFreeMugOver200();
        cart.addDiscount(new discount5PercentOff300());
        cart.addDiscount(discountMug);
        cart.deleteDiscount(discountMug);
        cart.applyDiscounts();
        assertEquals(3800, cart.totalWithDiscounts());
    }

    @Test
    public void testApplyDiscounts() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2000);
        Product tablet = new Product("Tablet", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        cart.addDiscount(new discount5PercentOff300());
        cart.applyDiscounts();
        assertEquals(3325, cart.totalWithDiscounts());
    }

    @Test
    public void testGetProducts() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        Product headphones = new Product("Headphones", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        cart.add(headphones);
        assertEquals(3, cart.getProducts().length);
    }

    @Test
    public void testSetProducts() {
        Cart cart = new Cart();
        Product smartphone = new Product("Smartphone", 2500);
        Product tablet = new Product("Tablet", 1500);
        cart.add(smartphone);
        cart.add(tablet);
        cart.setProducts(cart.getProducts());
        assertEquals(2, cart.getProducts().length);
    }

}
