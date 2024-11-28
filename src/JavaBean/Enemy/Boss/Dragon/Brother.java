package JavaBean.Enemy.Boss.Dragon;

import JavaBean.Enemy.Enemy;

import java.awt.*;

public class Brother extends Enemy {
    private int speedY;
    public Brother(int x, int y, Image img, int height, int weight, int speed, int speedY, int HP) {
        super(x, y, img, height, weight, speed);
        super.setHP(HP);
        super.setType(HP);
        this.speedY = speedY;
    }

    public Brother() {
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        //加上横坐标移动
        if (super.getY() < 0 || super.getY() > 410) {
            this.speedY = - speedY;
        }
        super.setY(super.getY() + speedY);
    }
}
