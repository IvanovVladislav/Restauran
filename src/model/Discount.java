package model;

import java.util.List;

public class Discount {
    private List<Dish> dishes;
    private int percent;

    public Discount(List<Dish> dishes, int percent) {
        this.dishes = dishes;
        this.percent = percent;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getPercent() {
        return percent;
    }
}
