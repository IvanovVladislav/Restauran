package com.company;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    public static List<Dish> getListOfDish(Menu menu, Visitor visitor) {
         List<Dish> dishes = new ArrayList<>();
        List<Dish> dishesInMenu = menu.getDishes();
        List<Discount> discounts = menu.getDiscounts();
        for (Dish d: visitor.getWishes()) {
            if (dishesInMenu.contains(d) && visitor.getFreeTime() >= d.getCookingTime()
                    && canEat(visitor.getLimitations(), d.getLimitations())){
                int discountValue = getDiscountValue(discounts, dishes, d);
                if (visitor.getMoney() >= d.getPrice() - discountValue) {
                    dishes.add(d);
                    visitor.pay(d.getPrice() - discountValue);
                }
            }
        }
        return dishes;
    }
    private static boolean canEat(List<Limitation> l1, List<Limitation> l2) {
        for (Limitation limitation: l1){
            if (l2.contains(limitation)){
                return false;
            }
        }
        return true;
    }
    private static int getDiscountValue(List<Discount> discounts, List<Dish> dishes, Dish dish) {
        int discountValue = 0;
        for (Discount d: discounts) {
            List<Dish> dishes1 = d.getDishes();
            if (dishes1.contains(dish)) {
                boolean flag = true;
                for (Dish dish1 : dishes1) {
                    if (!(dishes.contains(dish1) || dish1 == dish)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (Dish dish1:dishes1) {
                        discountValue += dish1.getPrice() * d.getPercent() / 100;
                    }
                }
            }
        }
        return discountValue;
    }
    public static Visitor getVisitor(List<Dish> wishes, int freeTime, int money) {
        return new Visitor(wishes, freeTime, money);
    }
    public static void  addWish(Visitor visitor, Dish dish) {
        visitor.addWish(dish);
    }
    public static void  addLimitation(Visitor visitor, Limitation limitation) {
        visitor.addLimitation(limitation);
    }


}
