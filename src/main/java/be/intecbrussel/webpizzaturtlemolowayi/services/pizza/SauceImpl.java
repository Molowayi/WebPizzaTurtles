package be.intecbrussel.webpizzaturtlemolowayi.services.pizza;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SauceImpl implements Sauce {
    @Override
    public String toString() {
        return "Standard sauce";
    }
}
