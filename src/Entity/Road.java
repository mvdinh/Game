package Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Road {
	private int x, y, width, height;
	private int x1,y1;
	
	public Road() {
		width=1000;
		height=1;
		x=0;
		y=200;
		x1= x + width;
		y1=200;	
	}
	public void Update() {
        x -= 8;
        x1 -= 8;
        
       
        if (x < -width) {
            x = x1 + width;
        }
        if (x1 < -width) {
            x1 = x + width;
        }
        
    }

	
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
		g.fillRect(x1, y1, width, height);
	}

}
