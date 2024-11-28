package JavaBean.Prop;

import java.awt.*;

public class Meteorite extends GameProp{
    public Meteorite(int x, int y, int weight, int height, Image underImg) {
        super(x, y, weight, height, underImg, underImg, 20, 0,
                -30, 0, 0, 0);
    }

    public Meteorite(int x, int y, int weight, int height, Image img, Image underImg, int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        super(x, y, weight, height, img, underImg, type, speed, impacthp, impctspeed, impactNum, impactDamage);
    }

    @Override
    public void paintSelf(Graphics g) {
//        super.paintSelf(g);
        g.drawImage(super.getImg(),super.getX(),super.getY(),null);
        super.setX(super.getX() - 15);
        super.setY(super.getY() + 15);
    }

    @Override
    public Rectangle getRectangle() {
        // 因为陨石大小不一样所以要重判断
        if (super.getHeight() > 30) {
            return new Rectangle(super.getX(), super.getY() + 100, 80, 80);
        } else {
            return new Rectangle(super.getX(), super.getY() + 60, 20, 20);
        }
    }
}
