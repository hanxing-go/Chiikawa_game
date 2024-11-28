package JavaBean.Prop;

import Utils.ImageUtils;

import java.awt.*;

public class Mushroom extends GameProp{
    public Mushroom(int x, int y, Image underImg) {
        super(x, y, 101, 50, ImageUtils.box, underImg, 12, 5,
                1, 0, 0, 1);
    }

    public Mushroom(int x, int y, int weight, int height, Image img, Image underImg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underImg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }
}
