package model;

import java.util.List;

public class Restaurant {
    private Menu menu;
    private List <Visitor> visitors;
    public Restaurant(Menu menu, List<Visitor> visitors) {
        this.menu = menu;
        this.visitors = visitors;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public Menu getMenu() {
        return menu;
    }
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }
}
