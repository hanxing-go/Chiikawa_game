package JavaBean.Enemy.Worm;

import JavaBean.Enemy.Enemy;

import java.awt.*;

public class UprightWorm extends Enemy {
    public UprightWorm(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(2);
        super.setType(2);
    }
}
