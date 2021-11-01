package com.trattoria.domain;

public enum PizzaType {
    MARGHERITA("Margherita"), CAPRICCIOSA("Capricciosa"), CALZONE("Calzone");

    private String name;

    PizzaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
