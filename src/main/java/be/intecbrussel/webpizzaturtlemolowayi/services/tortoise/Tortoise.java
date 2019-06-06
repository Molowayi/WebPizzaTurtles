package be.intecbrussel.webpizzaturtlemolowayi.services.tortoise;

import be.intecbrussel.webpizzaturtlemolowayi.services.pizza.Pizza;
import be.intecbrussel.webpizzaturtlemolowayi.services.pizza_services.PizzaFinishedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tortoise extends Thread {

    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private ApplicationContext applicationContext;
    private String name;
    private Pizza pizza;
    private boolean pause = false;
    private List<Long> eatenPizzas = new ArrayList<>();

    public List<Long> getEatenPizzas() {
        return eatenPizzas;
    }

    public void setEatenPizzas(List<Long> eatenPizzas) {
        this.eatenPizzas = eatenPizzas;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public void takePizza() {
        if (pizza != null) {
        }
    }

    public void eatPizzaSlice() {
        if (pizza != null) {
            for (int i = 0; i < 8; i++) {
            }
            eatenPizzas.add((long) pizza.getId());
        }
    }

    public void warnPizzaFinished() {
        if (true) {
            publisher.publishEvent(new PizzaFinishedEvent(this.getName()));
        }
    }

    @Override
    public void run() {

        while (true) {
            if (!pause) {
                warnPizzaFinished();
                waitABit();
                takePizza();
                eatPizzaSlice();
            }
        }
    }

    public void waitABit() {
        try {
            Thread.sleep(new Random().nextInt(((100 + 1) - 10) + 10) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
