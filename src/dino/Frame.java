package dino;

import java.awt.Color;

import javax.swing.JFrame;

public class Frame extends JFrame {
   GameScreen gamescreen;

    public Frame() {
        gamescreen = new GameScreen();
        add(gamescreen);
        gamescreen.requestFocus();
    }

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(1000, 500);
    }
}
