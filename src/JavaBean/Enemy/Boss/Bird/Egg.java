package JavaBean.Enemy.Boss.Bird;

import JavaBean.Enemy.Enemy;

import java.awt.*;

public class Egg extends Enemy {
    public Egg(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(50);
        super.setType(6);
    }
}
