package JavaBean;

import java.awt.*;

public class Egg extends Enemy{
    public Egg(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(10);
        super.setType(5);
    }
}
