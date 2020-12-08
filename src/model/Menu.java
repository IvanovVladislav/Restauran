package model;

import model.Discount;
import model.Dish;

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
    public void addDish(Dish dish) {
        dishes.add(dish);
    }
    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }
}
