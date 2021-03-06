package com.trattoria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

    private List<Pizza> pizzaList = new ArrayList<>();

    public Order(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
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
