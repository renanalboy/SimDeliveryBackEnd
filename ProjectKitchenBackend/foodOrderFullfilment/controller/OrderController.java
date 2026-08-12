package controller;

import model.Order;
import service.OrderService;

import java.util.Random;

public class OrderController {
    private final OrderService orderService;
    private final Random random = new Random();

    public OrderController() {
        this(new OrderService());
    }

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void receiveOrder(Order order) {
        orderService.placeOrder(order);
        simulatePickup(order.getId());
    }

    public void printActions() {
        orderService.logActions();
    }

    private void simulatePickup(String orderId) {
        try {
            Thread.sleep(random.nextInt(4000) + 5000); // Simulate pickup within 4-8 seconds
            orderService.pickupOrder(orderId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /*public void printActions() {
        orderService.logActions();
    }*/

}
