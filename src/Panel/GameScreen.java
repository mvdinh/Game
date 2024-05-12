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
    
    private int begin = 1;
    private int play=2;
    private int end=3;
    private int current = begin;
    private int currentFrameIndex=0;
    private int down =1;
	private BufferedImage Image =null;
    BufferedImage img;
    private boolean check=true;
    private boolean isPause= false;
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
	    pauseButton = new JButton("Pause"); 
	    add(pauseButton);
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
	                    if (dino.getCount() < 2 && dino.getY() == 165) {
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
        road.paint(g);
        obstacles.paint(g);
       dino.Paint(g);
        g.setColor(Color.blue);
//        g.drawString("Score:" + Point+ "  " + dao.getMaxPoint() ,100,50);
        if (current == begin) {
            g.setColor(Color.red);
            g.drawString("NHẤN PHÍM CÁCH ĐỂ BẮT ĐẦU", 500, 100);
        }
        if (current == end) {
            g.setColor(Color.red);
            g.drawString("GAME OVER", 500, 80);
        }
    }
    public void reset() {
    	setPoint(0);
    	 dino = new Dino();
         road = new Road();
         obstacles = new ListObstacle();
    }
    
}  

   