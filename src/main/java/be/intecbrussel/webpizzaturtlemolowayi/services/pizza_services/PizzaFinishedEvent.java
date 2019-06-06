package be.intecbrussel.webpizzaturtlemolowayi.services.pizza_services;

public class PizzaFinishedEvent {
    private String name;

    public PizzaFinishedEvent() {
    }

    public PizzaFinishedEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
