package JavaBean.Enemy.Worm;

import JavaBean.Enemy.Enemy;

import java.awt.*;

public class CreepWorm extends Enemy {
    public CreepWorm(int x, int y, Image img, int height, int weight, int speed, int blood) {
        super(x, y, img, height, weight, speed);
        super.setHP(1 * blood);
        super.setType(1);
    }
}
