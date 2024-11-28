package JavaBean.Prop;

import Utils.ImageUtils;

import java.awt.*;

public class Book extends GameProp{
    public Book(int x, int y, Image underImg) {
        super(x, y, 60, 33, ImageUtils.box, underImg, 7, 5,
                10, 0, 1, 0);
    }

    public Book(int x, int y, int weight, int height, Image img, Image underImg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underImg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }
}
