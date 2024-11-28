package JavaBean.Prop;

import java.awt.*;

public class Star extends GameProp{
    public Star(int x, int y, Image underImg) {
        super(x, y, 200, 200, underImg, underImg, 6, 5,
                20, 0, 0, 2);
    }

    public Star(int x, int y, int weight, int height, Image img, Image underImg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underImg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }
}
