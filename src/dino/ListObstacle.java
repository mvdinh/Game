package dino;

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
    private int lastObstacleX; // Biến để lưu trữ vị trí của vật cản cuối cùng đã vượt qua
    Random random = new Random();
    public ListObstacle() {
        obstacles = new ArrayList<Obstacle>(); // Khởi tạo danh sách trước khi sử dụng
        try {
            img = ImageIO.read(new File("src/img/abc.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < 6; i++) {
        	int r = random.nextInt(10+1);
            Obstacle obs = new Obstacle(200 *i+50 *r , 150, 12, 40);
            obstacles.add(obs);
        }
    }

    public void Update() {
        for (int i = 0; i < 6; i++) {
            obstacles.get(i).Update();
        }
        int r = random.nextInt(10+1);
        if (obstacles.get(0).getX() < 10) {
            Obstacle o = obstacles.remove(0);
            o.setX(obstacles.get(4).getX() + 250 +50*r);
            obstacles.add(o);
        }
    }

    public void paint(Graphics g) {
        if (obstacles != null) {
            for (int i = 0; i < 6; i++) {
                g.drawImage(img, (int) obstacles.get(i).getX(), (int) obstacles.get(i).getY(), null);
            }
        }
    }

    
    public Obstacle getObstacle(int i) {
        return obstacles.get(i);
    }
}