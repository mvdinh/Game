package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Obstacle {
	private BufferedImage img;
	private int x, y, width, height;
	private int speed;
	private Rectangle rect;
	

	public Obstacle() {
		try {
            img = ImageIO.read(new File("src/img/xr.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		x=700;
		y=267;
		width= img.getWidth();
		height= img.getHeight();
		speed= 8;
		rect = new Rectangle(x, y, width, height);
	}
	
	public void Update(){
		
        setX(this.getX()- speed);
        this.rect.x= getX();
        this.rect.y= getY();
        this.rect.width= getWidth();
        this.rect.height= getHeight();
        
    } 
	 public void paint(Graphics g) {
	     g.drawImage(img, getX(), getY(), null);
	    }
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public Rectangle getRect() {
		return rect;
	}
}