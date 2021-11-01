package com.trattoria.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Pizza> pizzaList;

    public Order() {
        this.pizzaList = new ArrayList<>();
    }

    public void printOrder() {

        int counter = 0;

        System.out.println("You ordered the following pizzas:");
        for (Pizza pizza: pizzaList) {
            counter++;
            System.out.println("nr: " + counter + "  " + pizza.toString());
        }
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }
}
