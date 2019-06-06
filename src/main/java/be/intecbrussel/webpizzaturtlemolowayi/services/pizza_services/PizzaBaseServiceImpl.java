package be.intecbrussel.webpizzaturtlemolowayi.services.pizza_services;

import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Base;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Pizza;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.PizzaState;
import org.springframework.stereotype.Component;

@Component
public class PizzaBaseServiceImpl implements PizzaBaseService {

    @Override
    public void addBase(Pizza pizza, Base base) {
        pizza.setBase(base);
        pizza.setState(PizzaState.ONLY_BASE);
    }
}
