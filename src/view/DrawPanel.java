package view;

import model.Restaurant;
import service.Waiter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel {
    private Service service = new Service();
    private Waiter waiter = new Waiter();
    private Restaurant restaurant = service.getRestaurant();


    private JButton menuButton, addMenuButton, visitorButton, addVisitorButton, getDishButton;
    private JLabel label;
    private JTextArea textArea;
    public DrawPanel() {

        this.setLayout(null);
        menuButton = new JButton("Меню");
        addMenuButton = new JButton("Добавить");
        visitorButton = new JButton("Посетитель");
        addVisitorButton = new JButton("Добавить");
        getDishButton = new JButton("Заказ");
        label = new JLabel();
        textArea = new JTextArea();
        menuButton.setBounds(50, 10, 100, 50);
        addMenuButton.setBounds(200, 10, 100, 50);
        visitorButton.setBounds(350, 10, 100, 50);
        addVisitorButton.setBounds(500, 10, 100, 50);
        getDishButton.setBounds(650, 10, 100, 50);
        textArea.setBounds(50, 70, 700, 50);
        label.setBounds(50, 130, 700, 410);
        textArea.setLineWrap(true);

        this.add(menuButton);
        this.add(addMenuButton);
        this.add(visitorButton);
        this.add(addVisitorButton);
        this.add(getDishButton);
        this.add(textArea);
        this.add(label);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(service.getMenu(restaurant.getMenu()));
            }
        });
        addMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                restaurant.getMenu().addDish(service.getDishFromString(textArea.getText()));
                label.setText(service.getMenu(restaurant.getMenu()));
            }
        });
        visitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(service.getVisitors(restaurant.getVisitors()));
            }
        });
        addVisitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                restaurant.addVisitor(service.getVisitorFromString(textArea.getText(), restaurant.getMenu().getDishes()));
                label.setText(service.getVisitors(restaurant.getVisitors()));
            }
        });
        getDishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText(service.getDishes(waiter.getListOfDish(restaurant.getMenu(),
                        restaurant.getVisitors().get(Integer.parseInt(textArea.getText()) -1))));
            }
        });
    }
}
