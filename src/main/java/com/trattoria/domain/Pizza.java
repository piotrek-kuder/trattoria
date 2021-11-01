package com.trattoria.domain;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private PizzaType pizzaType;
    private String base;
    private List<String> ingredients = new ArrayList<>();

    private Pizza(PizzaType pizzaType, String base, List<String> ingredients) {
        this.pizzaType = pizzaType;
        this.base = base;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static class PizzaBuilder {
        private PizzaType pizzaType;
        private String base;
        private List<String> ingredients = new ArrayList<>();

        public PizzaBuilder pizzaType(PizzaType pizzaType) {
            this.pizzaType = pizzaType;
            return this;
        }

        public PizzaBuilder base(String base) {
            this.base = base;
            return this;
        }

        public PizzaBuilder ingredients(List<String> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Pizza build() {
            return new Pizza(pizzaType, base, ingredients);
        }
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        String ingr = "";
        for (String s: ingredients) {
            ingr = ingr + ", " + s;
        }
        return "name: " + pizzaType.getName()
                + "   base: " + base
                + "   ingredients: " + ingr.substring(2);
    }
}
