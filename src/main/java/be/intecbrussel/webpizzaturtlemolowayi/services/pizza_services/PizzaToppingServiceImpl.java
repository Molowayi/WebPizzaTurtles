package be.intecbrussel.webpizzaturtlemolowayi.services.pizza_services;

import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Pizza;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.PizzaState;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.toppings.Topping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PizzaToppingServiceImpl implements PizzaToppingService {

    private int totalProducedPizzas = 0;

    public int getTotalProducedPizzas() {
        return totalProducedPizzas;
    }

    public void setTotalProducedPizzas(int totalProducedPizzas) {
        this.totalProducedPizzas = totalProducedPizzas;
    }

    @Override
    public void addToppings(Pizza pizza, List<Topping> toppings) {
        pizza.setToppings(toppings);
        pizza.setState(PizzaState.READY);
        totalProducedPizzas++;
    }
}
