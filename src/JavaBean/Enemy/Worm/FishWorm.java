package JavaBean.Enemy.Worm;

import JavaBean.Enemy.Enemy;

import java.awt.*;

public class FishWorm extends Enemy {
    public FishWorm(int x, int y, Image img, int height, int weight, int speed, int blood) {
        super(x, y, img, height, weight, speed);
        super.setHP(3 * blood);
        super.setType(3);
    }
}
