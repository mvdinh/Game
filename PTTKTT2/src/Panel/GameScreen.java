package Panel;

import javax.imageio.ImageIO;
import javax.swing.*;

import Animation.AFrame;
import Animation.Animation;
import Entity.*;
import Frame.SignupForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameScreen extends JPanel implements ActionListener {
    private Timer timer;
    private int Point;
    private Dino dino;
    private Road road;
    private ListObstacle obstacles;
    JButton pauseButton= new JButton();
    private BufferedImage img;
    private int begin = 1;
    private int play=2;
    private int end=3;
    private int current = begin;
    private int currentFrameIndex=0;
    private int down =1;
    private boolean check=true;
    private boolean isPause= false;
    private BufferedImage backgroundImage;
    public int getPoint() {
		return Point;
	}

	public void setPoint(int point) {
		Point = point;
	}

	public GameScreen() {
	    setPoint(0);
	    dino = new Dino();
	    road = new Road();
	    obstacles = new ListObstacle();
	    
	 // Load ảnh nền
        try {
            backgroundImage = ImageIO.read(new File("src/img/backgroud.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
	    
	    pauseButton = new JButton("Pause"); 
//	    add(pauseButton);
	    timer = new Timer(40, this);
	    timer.start();
	    
	    addKeyListener(new KeyAdapter() {
	        public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	                if (current == begin) {
	                    current = play;
	                }
	                if (current == end) {
	                    current = begin;
	                    reset();
	                }
	            }
	            if(check) {
	                if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) && current == play) {
	                    if (dino.getCount() < 2 && dino.getY() == 265) {
	                        dino.jump();
	                        dino.setJumpSpeed(25);
	                    }
	                }
	            }
	        }
	    });

	    setFocusable(true);
	}

    public void Pause() {
    	isPause = !isPause;
        if (isPause) {
            timer.stop();
        } else {
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	if (e.getSource() == pauseButton) {
            isPause = !isPause;
            if (isPause) {
                timer.stop();
            } else {
                timer.start();
            }
        }

        if (current == play) {
            if (dino.isLive()) {
            	
                dino.update();
                road.Update();
                obstacles.Update();
                repaint();
                for(int i=0;i<1;i++) {
                	Obstacle o = obstacles.getObstacle(i);
                    if (dino.getRect().intersects(o.getRect())) {
                        dino.setLive(false);
                        current = end;
                        return;
                       }
                   }
                }
            }
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this);
        } else {
            // Nếu không tìm thấy hình ảnh nền, vẽ một màu trắng
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        
        road.paint(g);
        obstacles.paint(g);
        dino.Paint(g);
        g.setColor(Color.blue);
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("BÀI TẬP LỚN CÔNG NGHỆ JAVA", 250, 30);
//        g.drawString("Score:" + Point+ "  " + dao.getMaxPoint() ,100,50);
        if (current == begin) {
            g.setColor(Color.red);
            g.drawString("NHẤN PHÍM CÁCH ĐỂ BẮT ĐẦU", 250, 100);
        }
        if (current == end) {
            g.setColor(Color.red);
            g.drawString("GAME OVER", 320, 90);
            try {
                img = ImageIO.read(new File("src/img/gameover.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void reset() {
    	setPoint(0);
    	 dino = new Dino();
         road = new Road();
         obstacles = new ListObstacle();
    }
    
}  

   