package JavaBean.Prop;

import Utils.ImageUtils;

import java.awt.*;

public class Pajams extends GameProp{
    public Pajams(int x, int y, Image underimg) {
        super(x, y, 100, 120, ImageUtils.box, underimg, 3, 5,
                5, 0, 1, 1);
    }
    public Pajams(int x, int y, int weight, int height, Image img, Image underimg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underimg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }

}
