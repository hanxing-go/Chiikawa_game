package JavaBean;

import java.awt.*;
import java.util.Random;

public class BigWorm extends Enemy {
    private int speedY = 8;
    public BigWorm(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        Random random = new Random();
        this.speedY = random.nextInt(10);
        super.setHP(5);
        super.setType(5);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        //加上横坐标移动
        if (super.getY() < 0 || super.getY() > 404) {
            this.speedY = - speedY;
        }
        super.setY(super.getY() + speedY);
    }
}