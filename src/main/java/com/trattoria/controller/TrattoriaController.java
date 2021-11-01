package com.trattoria.controller;

import com.trattoria.domain.Pizza;
import com.trattoria.domain.User;
import com.trattoria.service.OrderService;
import com.trattoria.service.PizzaService;
import com.trattoria.service.UserService;

import java.util.List;
import java.util.Scanner;

public class TrattoriaController {

    private UserService userService = new UserService();
    private PizzaService pizzaService = new PizzaService();
    private OrderService orderService = new OrderService();

    private boolean finish = false;
    private String input;
    private Scanner scanner = new Scanner(System.in);
    private List<Pizza> pizzaList;
    private User user;

    public void startPizzaOrder() {

        System.out.println("\nThis is the simple trattoria application\n"
                + "Type S to start ordering a pizza or anything else to exit the program...");
        input = scanner.nextLine();

        if (!input.equals("S")) {
            finish = true;
        }

        while (!finish) {  //todo - może if zamiast while?

            user = userService.createUser();

            if (userWantsContinue()) {
                pizzaList = pizzaService.createPizzaList();

                if (userWantsContinue()) {
                    orderService.createOrder(user, pizzaList);
                }
            }

            finish = true;
        }

        System.out.println("Closing application...");
    }

    private boolean userWantsContinue() {
        System.out.println("Continue your order? Type Y if yes, anything else to exit application");

        input = scanner.nextLine();

        if (input.equals("Y")) {
            return true;
        }
        return false;
    }
}
