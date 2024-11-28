package JavaBean.Prop;

import Utils.ImageUtils;

import java.awt.*;

public class Camera extends GameProp{
    public Camera(int x, int y, Image underImg) {
        super(x, y, 60, 42, ImageUtils.box, underImg, 8, 5,
                +10, 0, 1, 0);
    }

    public Camera(int x, int y, int weight, int height, Image img, Image underImg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underImg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }
}
