package serviceTest;

import model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.OrderService;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @Test
    void testPlaceOrderInCooler() {
        Order order = new Order("1", "Ice Cream", "cold", 100);
        orderService.placeOrder(order);
        assertEquals(1, orderService.getCooler().getOrders().size());
    }

    @Test
    void testPlaceOrderInHeater() {
        Order order = new Order("2", "Pizza", "hot", 100);
        orderService.placeOrder(order);
        assertEquals(1, orderService.getHeater().getOrders().size());
    }

    @Test
    void testPlaceOrderInShelf() {
        Order order = new Order("3", "Room Temp Food", "neutral", 100);
        orderService.placeOrder(order);
        assertEquals(1, orderService.getShelf().getOrders().size());
    }

    @Test
    void testDiscardOrderWhenAllStorageIsFull() {
        // Fill all storages
        for (int i = 0; i < 6; i++) {
            orderService.placeOrder(new Order("cold-" + i, "Ice Cream", "cold", 100));
            orderService.placeOrder(new Order("hot-" + i, "Pizza", "hot", 100));
        }
        for (int i = 0; i < 12; i++) {
            orderService.placeOrder(new Order("neutral-" + i, "Room Temp Food", "neutral", 100));
        }

        // Attempt to place another order
        Order extraOrder = new Order("extra", "Extra Food", "neutral", 100);
        orderService.placeOrder(extraOrder);

        // Verify the extra order was discarded
        assertFalse(orderService.getShelf().getOrders().contains(extraOrder));
    }
}