package controllerTest;

import model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.OrderService;
import controller.OrderController;

import static org.mockito.Mockito.*;

class OrderControllerTest {
    private OrderController orderController;
    private OrderService mockOrderService;

    @BeforeEach
    void setUp() {
        mockOrderService = mock(OrderService.class);
        orderController = new OrderController(mockOrderService);
    }

    @Test
    void testReceiveOrder() {
        Order order = new Order("1", "Pizza", "hot", 100);
        orderController.receiveOrder(order);

        verify(mockOrderService, times(1)).placeOrder(order);
    }

    @Test
    void testPrintActions() {
        orderController.printActions();
        verify(mockOrderService, times(1)).logActions();
    }
}