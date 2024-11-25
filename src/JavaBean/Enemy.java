package JavaBean;

import java.awt.*;

public class Enemy extends GameObj{
    public Enemy(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        super.setX(super.getX() - super.getSpeed());
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
