
package Animation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class AFrame {
    
    
    private int []DimsBounds = new int[4];
    
    public AFrame(int x, int y, int width, int height){
        DimsBounds[0] = x;
        DimsBounds[1] = y;
        DimsBounds[2] = width;
        DimsBounds[3] = height;
    }
    
    public int[] GetBounds(){
        return DimsBounds;
    }
    public void Paint(int x, int y, BufferedImage image, Graphics g){

        BufferedImage imageDraw = image.getSubimage(DimsBounds[0], DimsBounds[1], DimsBounds[2], DimsBounds[3]);
        g.drawImage(imageDraw, x, y, null);
    }
}