package JavaBean;

import java.awt.*;

public class CreepWorm extends Enemy{
    public CreepWorm(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(1);
        super.setType(1);
    }
}
