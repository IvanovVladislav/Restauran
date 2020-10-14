package com.company;

import java.util.List;

public class Visitors {
    private List <Dish> wishes;
    private int freeTime;
    private int money;
    private List <Limitation> limitations;

    public Visitors(List<Dish> wishes, int freeTime, int money) {
        this.wishes = wishes;
        this.freeTime = freeTime;
        this.money = money;

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
}
