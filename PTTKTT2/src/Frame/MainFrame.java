package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Panel.GameScreen;

public class MainFrame extends JFrame {
	JButton pauseButton;
	GameScreen gamescreen;
    public MainFrame() {
    	setBounds(420, 100, 500, 350);
    	setSize(800,450);
        gamescreen = new GameScreen();
        add(gamescreen);
        
        setVisible(true);
    }

    public static void main(String[] args) {
       MainFrame f= new MainFrame();
    }
}