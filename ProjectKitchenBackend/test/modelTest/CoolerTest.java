package modelTest;

import model.Cooler;
import model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoolerTest {
    private Cooler cooler;

    @BeforeEach
    void setUp() {
        cooler = new Cooler();
    }

    @Test
    void testStoreColdOrder() {
        Order order = new Order("1", "Ice Cream", "cold", 100);
        assertTrue(cooler.store(order));
        assertEquals(1, cooler.getOrders().size());
    }

    @Test
    void testRejectHotOrder() {
        Order order = new Order("2", "Pizza", "hot", 100);
        assertFalse(cooler.store(order));
        assertEquals(0, cooler.getOrders().size());
    }

    @Test
    void testIsFull() {
        for (int i = 0; i < 6; i++) {
            cooler.store(new Order("cold-" + i, "Ice Cream", "cold", 100));
        }
        assertTrue(cooler.isFull());
    }
}