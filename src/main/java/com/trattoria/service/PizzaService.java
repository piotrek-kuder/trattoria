package com.trattoria.service;

import com.trattoria.domain.AvailableIngredients;
import com.trattoria.domain.Pizza;
import com.trattoria.domain.PizzaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PizzaService {

    Scanner scanner = new Scanner(System.in);
    String input;

    public List<Pizza> createPizzaList() {

        List<Pizza> pizzaList = new ArrayList<>();
        Pizza pizza = createPizza();

        while (pizza != null) {
            pizzaList.add(pizza);
            System.out.println("Pizzas on list >>> " + pizzaList.size());
            pizza = createPizza();
        }
        return pizzaList;
    }

    private Pizza createPizza() {

        PizzaType chosenPizzaType;
        Pizza pizza;
        List<String> ingredientsList;

        showAvailablePizzas();

        System.out.println("Type A to select a pizza and add to your order, \nanything else to stop adding items");
        input = scanner.nextLine();

        if (!"A".equals(input)) {
            return null;
        }

        chosenPizzaType = choosePizzaType();
        ingredientsList = Arrays.asList(chosenPizzaType.getIngredients().split(","));

        pizza = new Pizza.PizzaBuilder()
                .pizzaType(chosenPizzaType)
                .base(chosenPizzaType.getBase())
                .ingredients(ingredientsList)
                .build();

        System.out.println("Selected pizza:\n" + pizza.toString());
        System.out.println("Type E to edit suggested ingredients or anything else to save default");
        input = scanner.nextLine();

        if(input != null && input.equals("E")) {
            editPizza(pizza);
        }

        return pizza;
    }

    private void showAvailablePizzas() {

        System.out.println("We have " + PizzaType.values().length + " pizzas available:");

        for (PizzaType type: PizzaType.values()) {
            System.out.println("     Pizza nr " + (type.ordinal() + 1) + "   ::::   " + type.getName()
                    + "   base: " + type.getBase() + "   suggested ingredients: " + type.getIngredients());
        }
    }

    private PizzaType choosePizzaType() {

        int chosenPizzaNumber;
        int numberOfAvailablePizzas = PizzaType.values().length;

        System.out.println("Type number associated to the pizza you want to add");
        input = scanner.nextLine();

        while (input.equals("") || !input.matches("[0-9]*")
                || Integer.parseInt(input) <= 0
                || Integer.parseInt(input) > numberOfAvailablePizzas) {
            System.out.println("Value not accepted, type number between 1 and " + numberOfAvailablePizzas);
            input = scanner.nextLine();
        }

        chosenPizzaNumber = Integer.parseInt(input);

        System.out.println("You selected pizza nr " + chosenPizzaNumber + " ,you can add ANOTHER item later\n");

        return Arrays.stream(PizzaType.values())
                .filter(pizzaType -> pizzaType.ordinal() == (chosenPizzaNumber - 1))
                .collect(Collectors.toList())
                .get(0);
    }

    private Pizza editPizza(Pizza pizza) {

        String availIngr = "";
        String chosenIngr = "";
        boolean accepted = false;

        for (AvailableIngredients i: AvailableIngredients.values()) {
            availIngr = availIngr + ", " + i.getName();
        }

        System.out.println("There are available ingredients:\n" + availIngr.substring(2));

        while (!accepted) {
            System.out.println("Type coma separated ingredients selected from listed above,\n"
                    + "items out of the list are ignored during pizza cooking :)");
            chosenIngr = scanner.nextLine();
            System.out.println("You selected: " + chosenIngr + "\ntype A to confirm or anything other to correct");
            input = scanner.nextLine();

            if (input != null && input.equals("A")) {
                List<String> newIngr = Arrays.asList(chosenIngr.split(","));
                pizza.setIngredients(newIngr);
                System.out.println("Changed ingredients to " + pizza.getIngredients().toString());
                accepted = true;
            }
        }
        return pizza;
    }
}
