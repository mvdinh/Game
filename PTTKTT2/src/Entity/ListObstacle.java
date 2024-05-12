package Entity;

import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ListObstacle {
    private ArrayList<Obstacle> obstacles;
    private BufferedImage img;
    Random random = new Random();
    public ListObstacle() {
        obstacles = new ArrayList<Obstacle>(); 
        for(int i=0;i<1;i++) {
        	 Obstacle o = new Obstacle();
        	 obstacles.add(o);
        }
    }

    public void Update() {
    	 for(Obstacle o : obstacles) {
         	o.Update();
         }
    	 Obstacle first = obstacles.get(0);
    	 if(first.getX()+ first.getWidth()<0) {
    		 obstacles.remove(first);
    		 obstacles.add(addOb());
    	 }
    }

    public void paint(Graphics g) {
    	for(Obstacle o : obstacles) {
         	o.paint(g);;
         }
    }
    public Obstacle addOb() {
    	Obstacle o = new Obstacle();
    	o.setX(700);
    	return o;
    }

	public Obstacle getObstacle(int i) {
		// TODO Auto-generated method stub
		;return obstacles.get(i);
	}
    
   
}