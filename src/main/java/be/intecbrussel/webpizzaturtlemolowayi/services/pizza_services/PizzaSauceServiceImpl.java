package be.intecbrussel.webpizzaturtlemolowayi.services.pizza_services;

import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Pizza;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.PizzaState;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Sauce;
import org.springframework.stereotype.Component;

@Component
public class PizzaSauceServiceImpl implements PizzaSauceService {
    @Override
    public void addSauce(Pizza pizza, Sauce sauce) {
        pizza.setSauce(sauce);
        pizza.setState(PizzaState.ONLY_BASE_AND_SAUCE);
    }
}
