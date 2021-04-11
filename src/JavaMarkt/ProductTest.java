package JavaMarkt;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testGetCode() {
        Product smartphone = new Product("Smartphone", 2500);
        String code = smartphone.getCode();
        assertEquals(code, smartphone.getCode());
    }

    @Test
    public void testGetName() {
        Product smartphone = new Product("Smartphone", 2500);
        assertEquals("Smartphone", smartphone.getName());
    }

    @Test
    public void testGetPrice() {
        Product smartphone = new Product("Smartphone", 2500);
        assertEquals(2500, smartphone.getPrice());
    }

    @Test
    public void testGetDiscountPrice() {
        Product smartphone = new Product("Smartphone", 2500);
        assertEquals(2500, smartphone.getDiscountPrice());
    }

    @Test
    public void testSetName() {
        Product smartphone = new Product("Smartphone", 2500);
        smartphone.setName("Tablet");
        assertEquals("Tablet", smartphone.getName());
    }

    @Test
    public void testSetPrice() {
        Product smartphone = new Product("Smartphone", 2500);
        smartphone.setPrice(3000);
        assertEquals(3000, smartphone.getPrice());
    }

    @Test
    public void testSetDiscountPrice() {
        Product smartphone = new Product("Smartphone", 2500);
        smartphone.setDiscountPrice(2000);
        assertEquals(2000, smartphone.getDiscountPrice());
    }

}
