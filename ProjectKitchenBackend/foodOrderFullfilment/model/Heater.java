package model;

import java.util.ArrayList;
import java.util.List;

public class Heater implements Storage {
    private final List<Order> orders = new ArrayList<>();
    private final int capacity = 6;

    @Override
    public boolean store(Order order) {
        if (isFull()) {
            System.out.println("WARNING: capacity exceeded on Heater (id=" + order.getId() + ", temp=" + order.getTemperature() + ")");
            return false;
        }

        if (!order.getTemperature().equals("hot")) return false;
        orders.add(order);
        return true;
    }

    @Override
    public boolean isFull() {
        return orders.size() >= capacity;
    }

    @Override
    public Order retrieve(String id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void remove(String id) {
        orders.removeIf(order -> order.getId().equals(id));
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }
}