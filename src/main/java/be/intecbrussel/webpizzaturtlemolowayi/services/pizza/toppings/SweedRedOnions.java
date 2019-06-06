package be.intecbrussel.webpizzaturtlemolowayi.services.pizza.toppings;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SweedRedOnions implements Topping {

    @Override
    public void introduceTopping() {
    }

    @Override
    public String toString() {
        return "SweedRedOnions";
    }
}
