package com.trattoria.domain;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private PizzaType pizzaType;
    private List<String> ingredients = new ArrayList<>();

    private Pizza(PizzaType pizzaType, List<String> ingredients) {
        this.pizzaType = pizzaType;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static class PizzaBuilder {
        private PizzaType pizzaType;
        private List<String> ingredients = new ArrayList<>();

        public PizzaBuilder pizzaType(PizzaType pizzaType) {
            this.pizzaType = pizzaType;
            return this;
        }

        public PizzaBuilder ingredienst(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Pizza build() {
            return new Pizza(pizzaType, ingredients);
        }
    }

    @Override
    public String toString() {
        return null;              //todo
    }
}
