  package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Animation.AFrame;
import Animation.Animation;

public class Dino {
	private Animation a ;
	private BufferedImage Image =null;
	private int x, y, width, height;
	
	
	private int JumpSpeed;
	private Rectangle rect;
	private static int gravitation =3;
	private boolean isLive = true;
	private double count;
	
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	public Dino() {
		try {
	         Image = ImageIO.read(new File("src/img/anh_cuoi_ngua.png"));
		} catch (IOException e) {
				e.printStackTrace();
		}
		int x1= Image.getWidth()/3;
	    a = new Animation(100);
	    AFrame f;
	    f = new AFrame(0 ,0, x1, 35);
	    a.addFrame(f);
	    f = new AFrame(x1,0,x1, 35 );
	    a.addFrame(f);
	    f = new AFrame(x1*2 ,0, x1, 35);
	    a.addFrame(f);
	    x=100;
	    y=265;
	    width=x1;
	    height=Image.getHeight();
	    JumpSpeed=10;
	    rect = new Rectangle(x, y, width, height);
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
	public int getJumpSpeed() {
		return JumpSpeed;
	}
	public void setJumpSpeed(int jumpSpeed) {
		JumpSpeed = jumpSpeed;
	}
	public static int getGravitation() {
		return gravitation;
	}
	public static void setGravitation(int gravitation) {
		Dino.gravitation = gravitation;
	}
	
	public void update() {
		a.Update();
		this.setY((int)this.getY() - JumpSpeed); 
		this.JumpSpeed -= Dino.gravitation;
		
		if(this.getY() >= 265) 
		{
			this.setCount(0);
			this.setY(265);
			this.JumpSpeed = 0;
		}
		int x1= Image.getWidth()/3;
		this.rect.x = getX();
        this.rect.y = getY();
        this.rect.width= x1;
        this.rect.height= getHeight();
	}
	public void jump() {
		count++;   
	}

	
	public void Paint(Graphics g) {
		 a.paintAnimation((int)getX(), (int)getY(), Image ,g);
	}
	public Rectangle getRect() {
		return rect;
	}
	
}