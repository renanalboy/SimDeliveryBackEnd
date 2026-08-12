package util;

import java.util.ArrayList;
import java.util.List;

public class ActionLogger {
    private final List<String> actions;

    public ActionLogger() {
        this.actions = new ArrayList<>();
    }

    // Método para registrar uma nova ação
    public void logAction(String action, String orderId) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String logEntry = String.format("Timestamp: %s, Action: %s, Order ID: %s", timestamp, action, orderId);
        actions.add(logEntry);
    }

    // Método para obter todas as ações registradas
    public List<String> getActions() {
        return new ArrayList<>(actions);
    }

    // Método para imprimir todas as ações no console
    public void printActions() {
        if (actions.isEmpty()) {
            System.out.println("No actions logged.");
        } else {
            System.out.println("Action Log:");
            actions.forEach(System.out::println);
        }
    }
}