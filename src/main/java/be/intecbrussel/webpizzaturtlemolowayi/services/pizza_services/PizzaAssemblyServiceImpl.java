package be.intecbrussel.webpizzaturtlemolowayi.services.pizza_services;

import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Base;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Pizza;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Sauce;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.toppings.*;
import be.intecbrussel.webpizzaturtlemolowayi.services.tortoise.Tortoise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaAssemblyServiceImpl implements PizzaAssemblyService, PizzaFinishedListener {

    @Autowired
    private ApplicationContext applicationContext;

    private PizzaBaseService pizzaBaseService;
    private PizzaSauceService pizzaSauceService;
    private PizzaToppingService pizzaToppingService;

    public PizzaBaseService getPizzaBaseService() {
        return pizzaBaseService;
    }

    @Autowired
    public void setPizzaBaseService(PizzaBaseService pizzaBaseService) {
        this.pizzaBaseService = pizzaBaseService;
    }

    public PizzaSauceService getPizzaSauceService() {
        return pizzaSauceService;
    }

    @Autowired
    public void setPizzaSauceService(PizzaSauceService pizzaSauceService) {
        this.pizzaSauceService = pizzaSauceService;
    }

    public PizzaToppingService getPizzaToppingService() {
        return pizzaToppingService;
    }

    @Autowired
    public void setPizzaToppingService(PizzaToppingService pizzaToppingService) {
        this.pizzaToppingService = pizzaToppingService;
    }

    @Override
    public void makePizza(String tortoiseName) {

        Pizza pizza = applicationContext.getBean("makeEmptyPizza", Pizza.class);

        Base base = applicationContext.getBean(Base.class);
        pizzaBaseService.addBase(pizza, base);

        Sauce sauce = applicationContext.getBean(Sauce.class);
        pizzaSauceService.addSauce(pizza, sauce);

        List<Topping> toppings = makeTopping(tortoiseName);
        pizzaToppingService.addToppings(pizza, toppings);

        Tortoise tortoise = applicationContext.getBean(tortoiseName.toLowerCase(), Tortoise.class);
        tortoise.setPizza(pizza);

    }

    @Override
    public void onPizzaFinishedEvent(PizzaFinishedEvent e) {
        makePizza(e.getName());
    }

    private List<Topping> makeTopping(String tortoiseName) {

        List<Topping> toppings = new ArrayList<>();

        switch (tortoiseName) {
            case "Michelangelo":
                toppings.add(applicationContext.getBean(Pepperoni.class));
                toppings.add(applicationContext.getBean(SmokedHam.class));
                toppings.add(applicationContext.getBean(Pineapple.class));
                toppings.add(applicationContext.getBean(Jalepenos.class));
                break;
            case "Donatello":
                toppings.add(applicationContext.getBean(Chicken.class));
                toppings.add(applicationContext.getBean(Mushrooms.class));
                toppings.add(applicationContext.getBean(GreenPeppers.class));
                toppings.add(applicationContext.getBean(Tomatoes.class));
                break;
            case "Leonardo":
                toppings.add(applicationContext.getBean(SweedRedOnions.class));
                toppings.add(applicationContext.getBean(BlackOlives.class));
                toppings.add(applicationContext.getBean(Mushrooms.class));
                toppings.add(applicationContext.getBean(GreenPeppers.class));
                break;
            case "Raphael":
                toppings.add(applicationContext.getBean(Pepperoni.class));
                toppings.add(applicationContext.getBean(Sausage.class));
                toppings.add(applicationContext.getBean(Backon.class));
                toppings.add(applicationContext.getBean(Beef.class));
                break;
        }

        return toppings;
    }

}
