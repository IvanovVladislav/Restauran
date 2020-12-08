package com.company;

import view.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.setBounds(200, 200, 800,600);
        mf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mf.setVisible(true);
    }
}
