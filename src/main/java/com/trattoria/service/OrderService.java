package com.trattoria.service;

import com.trattoria.domain.Order;
import com.trattoria.domain.Pizza;
import com.trattoria.domain.User;
import com.trattoria.repository.OrderRepository;

import java.util.List;

public class OrderService {

    private OrderRepository orderRepository = new OrderRepository();

    private Order createOrder(List<Pizza> pizzaList) {
        return new Order(pizzaList);
    }

    private boolean isOrderValid(Order order) {

        return order.getPizzaList().size() > 0;
    }

    public void saveOrder(User user, List<Pizza> pizzaList) {

        Order order = createOrder(pizzaList);

        if (isOrderValid(order)) {
            orderRepository.saveOrderToFile(user, order);
            System.out.println("Checking if order saved correctly");
            orderRepository.readOrderFromFile();
        } else {
            System.out.println("Problem occurred, no pizza on the list, exiting program");
        }
    }
}
