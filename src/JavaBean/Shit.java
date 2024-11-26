package JavaBean;

import java.awt.*;

public class Shit extends GameProp {

    public Shit(int x, int y, int weight, int height, Image img, int type, int speed, int impacthp, int impctspeed, int impactNum) {
        super(x, y, weight, height, img, type, speed, impacthp, impctspeed, impactNum);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        super.setX(super.getX() - super.getSpeed());//屎肯定都是往左边移动，并且出现在左边的，所以是减去速度


    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
