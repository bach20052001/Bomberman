package com.project.bomberman.gui;

import javax.swing.*;


public class Start extends JFrame{
    public JButton btn = new JButton("Start");

    public Start(){
        setTitle("Start");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(btn);

        btn.addActionListener(e -> {
            setVisible(false);
            Frame frame = new Frame();
        });
    }
}
