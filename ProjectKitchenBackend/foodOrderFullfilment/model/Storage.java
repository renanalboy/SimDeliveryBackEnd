package model;

import java.util.List;

public interface Storage {
    boolean store(Order order);
    boolean isFull();
    Order retrieve(String id);
    void remove(String id);
    List<Order> getOrders();
}