package dino;

import javax.imageio.ImageIO;
import javax.swing.*;

import Animation.AFrame;
import Animation.Animation;
import DAO.dao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameScreen extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
	private Animation a ;
    private int Point;
    private Dino dino;
    private Road road;
    private ListObstacle obstacles;
    private int begin = 1;
    private int play=2;
    private int end=3;
    private int current = begin;
    private int currentFrameIndex=0;
    private int down =1;
	private BufferedImage Image =null;
    BufferedImage img;
    dao dao;
    
    public int getPoint() {
		return Point;
	}

	public void setPoint(int point) {
		Point = point;
	}

	public GameScreen() {
        setPoint(0);
        dao = new dao();
        dino = new Dino(100,165, 10, 10, 10);
        road = new Road();
        obstacles = new ListObstacle();
        try {
	         Image = ImageIO.read(new File("src/img/anh_cuoi_ngua.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	        int x= Image.getWidth()/3;
	        a = new Animation(100);
	        AFrame f;
	        f = new AFrame(0 ,0, x, 35);
	        a.addFrame(f);
	        f = new AFrame(x,0,x, 35 );
	        a.addFrame(f);
	        f = new AFrame(x*2 ,0, x, 35);
	        a.addFrame(f);

       
        timer = new Timer(40, this); 
        timer.start(); 

        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (current == play) {
            if (dino.isLive()) {
            	a.Update();
                dino.update();
                road.Update();
                obstacles.Update();
                repaint(); 
                Point++;
                for (int i = 0; i < 6; i++) {
                    Obstacle o = obstacles.getObstacle(i);
                    if ( dino.getRect().intersects(o.getRect())) {
                    	
                        dino.setLive(false);
                        if(Point > dao.getMaxPoint()) {
                    		dao.setMaxPoint(Point);
                    	}
                        current = end;
                        return;
                    }
                }
                    for (int i = 0; i < 6; i++) {
                    	if (Point > 1000000*(i+1)) {
                    		obstacles.getObstacle(i).setSpeed(6+i);
                    }
                }
            }  
            else {
            	
                current = end;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        road.paint(g);
        obstacles.paint(g);
        a.paintAnimation((int)dino.getX(), (int)dino.getY(), Image ,g);
        g.setColor(Color.blue);
        g.drawString("Score:" + Point+ "  " + dao.getMaxPoint() ,100,50);
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
    	 dino = new Dino(130, 155, 10, 10, 30);
         road = new Road();
         obstacles = new ListObstacle();
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (current == begin) {
                current = play;
            }
            if(current ==end) {
            	current = begin;
            	reset();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP  || e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (current == play && down == 1) {
                   dino.jump();
            }
            if (dino.getCount() < 2) {
            	if(dino.getY() == 165  ) 
            	{
                dino.jump();
                dino.setJumpSpeed(25);
            	}
            }
            
        }
    }

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}  

   