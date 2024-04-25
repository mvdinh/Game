
package Animation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class Animation {
	private List<AFrame> frames;
    private long timeDelay;
    private long beginTime = 0;
    private int currentFrame = 0;
    
    public Animation(long m){ //Thời gian tồn tại của mỗi khung hình
    	frames = new ArrayList<>();
        this.timeDelay = m;
    }
    
    public void Update(){
            if(System.currentTimeMillis() - beginTime > timeDelay) {
                currentFrame++;
                beginTime = System.currentTimeMillis();
                if(currentFrame == frames.size()) {
                    currentFrame = 0;
                }
            }
     }
    
    public void addFrame(AFrame frame) {
    		this.frames.add(frame);
    	
    }
    public void paintAnimation(int x, int y, BufferedImage image, Graphics g) {
        frames.get(currentFrame).Paint(x, y, image, g);
    }

}