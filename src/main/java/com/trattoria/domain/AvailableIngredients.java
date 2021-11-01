package com.trattoria.domain;

public enum AvailableIngredients {
    ONION("onion"),
    HAM("ham"),
    TOMATO("tomato"),
    MUSHROOMS("mushrooms"),
    SALAMI("salami"),
    GARLIC_SAUCE("garlic sauce"),
    CHEESE("cheese"),
    CORN("corn"),
    BASIL("basil"),
    CUCUMBER("cucumber");

    private String name;

    AvailableIngredients(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
