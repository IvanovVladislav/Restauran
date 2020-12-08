package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Waiter {
    public  List<Dish> getListOfDish(Menu menu, Visitor visitor) {
         List<Dish> dishes = new ArrayList<>();
        List<Dish> dishesInMenu = menu.getDishes();
        List<Discount> discounts = menu.getDiscounts();
        int time = 0;
        int counter = 0;
        Stack<Integer> stack = new Stack<>();
        for (Dish d: visitor.getWishes()) {
            if (dishesInMenu.contains(d) && visitor.getFreeTime() >= d.getCookingTime()
                    && canEat(visitor.getLimitations(), d.getLimitations())){
                int discountValue = getDiscountValue(discounts, dishes, d);
                if (visitor.getMoney() >= d.getPrice() - discountValue) {
                    dishes.add(d);
                    stack.add(counter);
                    visitor.pay(d.getPrice() - discountValue);
                    time = Math.max(time, d.getCookingTime());
                }
            }
            counter++;
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            visitor.removeWish(stack.pop());
        }
        visitor.takeTime(time);
        return dishes;
    }
    private boolean canEat(List<Limitation> l1, List<Limitation> l2) {
        for (Limitation limitation: l1){
            if (l2.contains(limitation)){
                return false;
            }
        }
        return true;
    }
    private int getDiscountValue(List<Discount> discounts, List<Dish> dishes, Dish dish) {
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
    public Visitor getVisitor(List<Dish> wishes, int money, int freeTime, List <Limitation> limitations) {
        return new Visitor(wishes, money, freeTime, limitations);
    }
    public void  addWish(Visitor visitor, Dish dish) {
        visitor.addWish(dish);
    }
    public void  addLimitation(Visitor visitor, Limitation limitation) {
        visitor.addLimitation(limitation);
    }


}
