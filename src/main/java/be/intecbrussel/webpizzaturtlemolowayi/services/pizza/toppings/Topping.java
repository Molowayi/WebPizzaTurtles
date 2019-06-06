package be.intecbrussel.webpizzaturtlemolowayi.services.pizza.toppings;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public interface Topping {
    void introduceTopping();
}
