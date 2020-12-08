package view;

import model.*;

import javax.swing.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public String getMenu(Menu menu) {
        StringBuilder sb = new StringBuilder();
        sb.append(getDishes(menu.getDishes()));
        return sb.toString();
    }
    public String getDishes(List<Dish> dishes) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (Dish dish: dishes) {
            sb.append(counter++).append(") ").append(getDish(dish)).append("\n");
        }
        return sb.toString();
    }
    private String getDish(Dish dish) {
        StringBuilder sb = new StringBuilder();
        sb.append(dish.getName()).append(", цена: ").append(dish.getPrice());
        return sb.toString();
    }
    public Dish getDishFromString(String s) {
        String[] array = s.split(" *[,;] *");
        List<Limitation> limitations = new ArrayList<>();
        for (int i = 4; i < array.length; i++) {
            for (Limitation limitation : Limitation.values()) {
                if (limitation.toString().equals(array[i])) {
                    limitations.add(limitation);
                    break;
                }
            }
        }
        Type t = Type.ANOTHER;
        for (Type type: Type.values()) {
            if (type.toString().equals(array[1])) {
                t = type;
                break;
            }
        }
        return new Dish(array[0], t, Integer.parseInt(array[2]), Integer.parseInt(array[3]), limitations);
    }
    public String getVisitors(List<Visitor> visitors) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (Visitor visitor: visitors) {
            sb.append(counter++).append(") ");
            for (Dish dish: visitor.getWishes()) {
                sb.append(dish.getName()).append(", ");
            }
            sb.append(visitor.getMoney()).append("; ").append(visitor.getFreeTime()).append("; ").append("\n");
        }
        return sb.toString();
    }
    public Visitor getVisitorFromString(String s, List<Dish> list) {
        String[] array = s.split(" *[,;] *");
        List<Dish> dishes = new ArrayList<>();
        int i = 0;
        for ( ; !isDigit(array[i]); i++) {
            for (Dish dish: list) {
                if (dish.getName().equals(array[i])) {
                    dishes.add(dish);
                }
            }
        }
        int money = Integer.parseInt(array[i++]);
        int time = Integer.parseInt(array[i++]);
        List<Limitation> limitations = new ArrayList<>();
        for (; i < array.length; i++) {
            for (Limitation limitation : Limitation.values()) {
                if (limitation.toString().equals(array[i])) {
                    limitations.add(limitation);
                    break;
                }
            }
        }
        return new Visitor(dishes, money, time, limitations);
    }
    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    public Restaurant getRestaurant() {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(getDishFromString("Суп; SOUP; 150; 10;  PEPPER_ALLERGY"));
        dishes.add(getDishFromString("Пирожное; DESSERT; 50; 10; HONEY_ALLERGY"));
        Menu menu = new Menu(dishes, new ArrayList<>());
       List<Visitor> visitors = new ArrayList<>();
       visitors.add(getVisitorFromString("Суп; 300; 20; PEANUT_ALLERGY", dishes));
        visitors.add(getVisitorFromString("Пирожное; 50; 20; HONEY_ALLERGY", dishes));
       return new Restaurant(menu, visitors);
    }

}
