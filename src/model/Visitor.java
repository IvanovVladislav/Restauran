package model;

import model.Dish;
import model.Limitation;

import java.util.List;

public class Visitor {
    private List <Dish> wishes;
    private int freeTime;
    private int money;
    private List <Limitation> limitations;

    public Visitor(List<Dish> wishes, int money, int freeTime, List <Limitation> limitations) {
        this.wishes = wishes;
        this.freeTime = freeTime;
        this.money = money;
        this.limitations = limitations;
    }

    public List<Dish> getWishes() {
        return wishes;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getMoney() {
        return money;
    }

    public List<Limitation> getLimitations() {
        return limitations;
    }
    public void pay(int price) {
        money -= price;
    }
    public void addWish(Dish dish) {
        wishes.add(dish);
    }
    public void addLimitation(Limitation limitation) {
        limitations.add(limitation);
    }
    public void takeTime(int time) {
        freeTime -= time;
    }
    public void removeWish(int i) {
        wishes.remove(i);
    }
}
