package be.intecbrussel.webpizzaturtlemolowayi.services.pizza;


import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.toppings.Topping;

import java.util.List;

public class PizzaImpl implements Pizza {

    private PizzaState state = PizzaState.EMPTY;
    private  static int id = 0;
    private Base base;
    private Sauce sauce;
    private List<Topping> toppings;

    public PizzaImpl() {
        id++;
    }

    public synchronized int getId() {
        return id;
    }

    public static void setId(int id) {
    }

    public Base getBase() {
        return base;
    }

    public PizzaState getState() {
        return state;
    }

    public void setState(PizzaState state) {
        this.state = state;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public void listTopping() {
        System.out.println("This pizza has the following toppings:");
        toppings.stream().forEach(t -> System.out.println("\t" + t));
    }

    @Override
    public String toString() {
        return "Pizza " + getId() +
                ": state=" + state +
                ", id=" + id +
                ", base=" + base +
                ", sauce=" + sauce +
                ", toppings=" + toppings;
    }
}
