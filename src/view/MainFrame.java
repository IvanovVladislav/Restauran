package view;

import model.Restaurant;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        this.add(new DrawPanel());
    }
}

