package be.intecbrussel.webpizzaturtlemolowayi.services.pizza_services;

import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Pizza;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.toppings.Topping;

import java.util.List;

public interface PizzaToppingService {
    void addToppings(Pizza pizza, List<Topping> toppings);
}
