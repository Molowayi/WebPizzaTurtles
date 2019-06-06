package be.intecbrussel.webpizzaturtlemolowayi.services.pizza;

import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.toppings.Topping;

import java.util.List;

public interface Pizza {

    void listTopping();

    public void setBase(Base base);

    public void setSauce(Sauce sauce);

    public void setToppings(List<Topping> toppings);

    public void setState(PizzaState state);

    public int getId();
}
