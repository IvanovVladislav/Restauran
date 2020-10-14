package com.company;

import java.util.List;

public class Menu {
    private List<Dish> dishes;
    private List<Discount> discounts;

    public Menu(List<Dish> dishes, List<Discount> discounts) {
        this.dishes = dishes;
        this.discounts = discounts;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
