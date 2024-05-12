package Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Entity.Account;
import Frame.*;
import Frame.SignupForm;
import database.ConnectDB;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Load extends JPanel {

    private JButton playButton;
    private JButton logoutButton;
    private Image backgroundImage;

    public Load() {
        playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		setVisible(false);
            		MainFrame f = new MainFrame();
            		f.setVisible(true);
            		f.setSize(1000, 1000);
            	}
        });
        logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		setVisible(false);
            		LoginForm login = new LoginForm();
            		login.setVisible(true);
            		
            	}
        });
        add(playButton);
        add(logoutButton);
        try {
            File imageFile = new File("src/img/bg.jpg");
            backgroundImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        playButton.setBounds(280, 130, 80, 30);
        logoutButton.setBounds(500, 320, 80, 30);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}