package JavaBean.Prop;

import Utils.ImageUtils;

import java.awt.*;

public class Noodles extends GameProp{
    public Noodles(int x, int y, Image underImg) {
        super(x, y, 60, 54, ImageUtils.box, underImg, 11, 5,
                10, 0, 0, 0);
    }
    public Noodles(int x, int y, int weight, int height, Image img, Image underImg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underImg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }
}
