package JavaBean.Prop;

import Utils.ImageUtils;

import java.awt.*;

public class Cookies extends GameProp{
    public Cookies(int x, int y, Image underImg) {
        super(x, y, 40, 43, ImageUtils.box, underImg, 2, 5,
                +3, 0, 0, 0);
    }

    public Cookies(int x, int y, int weight, int height, Image img, Image underImg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underImg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }
}
