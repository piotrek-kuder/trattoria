package com.trattoria.controller;

import com.trattoria.domain.PizzaType;
import com.trattoria.service.OrderService;
import com.trattoria.service.PizzaService;
import com.trattoria.service.UserService;

import java.util.Scanner;

public class TrattoriaController {

    private UserService userService = new UserService();
    private PizzaService pizzaService = new PizzaService();
    private OrderService orderService = new OrderService();

    private boolean finish = false;
    private String input;
    private Scanner scanner = new Scanner(System.in);

    public void startPizzaOrder() {

        System.out.println("\nThis is the simple trattoria application\n"
                + "Type 'start' to start ordering a pizza or 'quit' to exit the program...");

        while (!finish) {

            for (PizzaType type: PizzaType.values()) {
                System.out.println("Pizza " + type.getName() + "   ::::   " + PizzaType.values().length);
            }

            finish = true;
        }
    }
}
