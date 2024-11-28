package JavaBean.Prop;

import Utils.ImageUtils;

import java.awt.*;

public class Wand extends GameProp{
    public Wand(int x, int y, Image underimg) {
        super(x, y, 100, 50, ImageUtils.box, underimg, 5, 5,
                0, 0, 0, 0);
    }

    public Wand(int x, int y, int weight, int height, Image img, Image underImg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underImg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }
}
