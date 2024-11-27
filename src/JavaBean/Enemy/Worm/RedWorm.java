package JavaBean.Enemy.Worm;

import JavaBean.Enemy.Enemy;

import java.awt.*;

public class RedWorm extends Enemy {
    public RedWorm(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(1);
        super.setType(1);
    }
}
