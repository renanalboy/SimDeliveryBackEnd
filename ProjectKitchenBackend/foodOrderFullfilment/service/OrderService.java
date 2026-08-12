package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.*;
import util.ActionLogger;

//import java.util.concurrent.ConcurrentLinkedQueue;

public class OrderService {
    private final Cooler cooler = new Cooler();
    private final Heater heater = new Heater();
    private final Shelf shelf = new Shelf();
    private final ActionLogger actionLogger = new ActionLogger();

    // Impement pickup order logic. This code is already include discart action.
    public void pickupOrder(String id) {
        model.Order order = cooler.retrieve(id);
        if (order != null) {
            cooler.remove(id);
            logWithTimestamp("Pickup Order: " + id + " | temp: " + order.getTemperature() + " | " + freshnessLabel(order.getFreshness()));
            //actionLogger.logAction("pickup", id);
            return;
        }

        order = heater.retrieve(id);
        if (order != null) {
            heater.remove(id);
            logWithTimestamp("Pickup Order: " + id + " | temp: " + order.getTemperature() + " | " + freshnessLabel(order.getFreshness()));
            //actionLogger.logAction("pickup", id);
            return;
        }

        order = shelf.retrieve(id);
        if (order != null) {
            shelf.remove(id);
            logWithTimestamp("Pickup Order: " + id + " | temp: " + order.getTemperature() + " | " + freshnessLabel(order.getFreshness()));
            //actionLogger.logAction("pickup", id);
            return;
        }

        logWithTimestamp("Discard Order: " + id + " | not found in storage");
        //actionLogger.logAction("discard", id);
    }

    // Implement place order logic. This code is already include discart action.
    public void placeOrder(Order order) {
        boolean stored = false;
        if (cooler.store(order)) {
            logWithTimestamp("Placing order: " + order.getId() + " | temp: " + order.getTemperature() + " | " + freshnessLabel(order.getFreshness()));
            //actionLogger.logAction("place", order.getId());
            stored = true;
        } else if (heater.store(order)) {
            logWithTimestamp("Placing order: " + order.getId() + " | temp: " + order.getTemperature() + " | " + freshnessLabel(order.getFreshness()));
            //actionLogger.logAction("place", order.getId());
            stored = true;
        } else if (shelf.store(order)) {
            logWithTimestamp("Placing order: " + order.getId() + " | temp: " + order.getTemperature() + " | " + freshnessLabel(order.getFreshness()));
            //actionLogger.logAction("place", order.getId());
            stored = true;
        } else if (!stored) {
            logWithTimestamp("Discard order: " + order.getId() + " | temp: " + order.getTemperature() + " | " + freshnessLabel(order.getFreshness()));
            //actionLogger.logAction("discard", order.getId());
        }
    }
    //Register log to indentify how orders a process in system
    public void logActions() {
        actionLogger.printActions();
    }

    public Cooler getCooler() {
        return cooler;
    }

    public Heater getHeater() {
        return heater;
    }

    public Shelf getShelf() {
        return shelf;
    }

    //Get detail timestemp
    private void logWithTimestamp(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + timestamp + "] " + message);
    }

    private String freshnessLabel(int freshness) {
        // Consider freshness > 50 as "fresco", otherwise "não fresco"
        return (freshness > 50) ? "fresco" : "não fresco";
    }
}