package com.trattoria.service;

import com.trattoria.domain.Pizza;
import com.trattoria.domain.PizzaType;

import java.util.List;

public class PizzaService {

    public List<Pizza> createPizzaList() {

        for (PizzaType type: PizzaType.values()) {
            System.out.println("Pizza " + type.getName() + "   ::::   " + PizzaType.values().length);
        }
        return null;
    }
}
