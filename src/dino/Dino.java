package dino;

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
	public Dino(int x, int y, int width, int height, int jumpSpeed) {
		super();
		
            
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rect = new Rectangle(x, y, width, height); 
		JumpSpeed = jumpSpeed;
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
		this.setY((int)this.getY() - JumpSpeed); 
		this.JumpSpeed -= Dino.gravitation;
		this.rect.setLocation((int)this.getX(),(int)this.getY());
		if(this.getY() >= 165) 
		{
			this.setCount(0);
			this.setY(165);
			this.JumpSpeed = 0;
		}
	}
	public void jump() {
		count++;   
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	
	
	
}