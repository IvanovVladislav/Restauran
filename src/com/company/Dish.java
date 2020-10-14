package com.company;

import java.util.List;

public class Dish {
    private String name;
    private Type type;
    private int price;
    private int cookingTime;
    private List <Limitation> limitations;

    public Dish(String name, Type type, int price, int cookingTime, List<Limitation> limitations) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.cookingTime = cookingTime;
        this.limitations = limitations;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
    public int getCookingTime() {
        return cookingTime;
    }

    public List<Limitation> getLimitations() {
        return limitations;
    }


}
