package com.trattoria.domain;

public enum PizzaType {
    MARGHERITA("Margherita", "bun,mozarella,tomato sauce", "onion"),
    CAPRICCIOSA("Capricciosa", "bun,mozarella,tomato sauce", "ham,mushrooms"),
    CALZONE("Calzone", "bun", "cheese,corn,garlic sauce,ham,tomato,salami");

    private final String name;
    private String base;
    private String ingredients;

    PizzaType(String name, String base, String ingredients) {
        this.name = name;
        this.base = base;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getBase() {
        return base;
    }

    public String getIngredients() {
        return ingredients;
    }
}
