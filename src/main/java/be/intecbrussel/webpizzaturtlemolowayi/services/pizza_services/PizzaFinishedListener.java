package be.intecbrussel.webpizzaturtlemolowayi.services.pizza_services;

import org.springframework.context.event.EventListener;

public interface PizzaFinishedListener {
    @EventListener
    void onPizzaFinishedEvent(PizzaFinishedEvent e);
}
