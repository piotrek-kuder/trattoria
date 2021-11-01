package com.trattoria.repository;

import com.trattoria.domain.Order;
import com.trattoria.domain.User;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private Map<User, Order> orderMap = new HashMap<>();

    public void saveOrder(User user, Order order) {

    }
}
