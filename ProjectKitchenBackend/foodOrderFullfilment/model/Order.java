package model;

public class Order {
    private String id;
    private String name;
    private String temperature;
    private int freshness;

    public Order(String id, String name, String temperature, int freshness) {
        this.id = id;
        this.name = name;
        this.temperature = temperature;
        this.freshness = freshness;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getTemperature() { return temperature; }
    public int getFreshness() { return freshness; }
}