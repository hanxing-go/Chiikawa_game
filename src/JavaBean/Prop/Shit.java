package JavaBean.Prop;

import JavaBean.Prop.GameProp;

import java.awt.*;

public class Shit extends GameProp {

    private int liveBegin = 0;//可以理解为生命周期
    private int liveCount = 0;
    private int liveLong = 100;

    public Shit(int x, int y, int weight, int height, Image img, int type, int speed, int impacthp, int impctspeed, int impactNum) {
        super(x, y, weight, height, img, img, type, speed, impacthp, impctspeed, impactNum, -1);
        super.setVis(1);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if (super.getType() == 0) {
            super.setX(super.getX() - super.getSpeed());
            //屎肯定都是往左边移动，并且出现在左边的，所以是减去速度
        } else {
            liveCount++;
            if (liveCount - liveBegin >= 100) {
                super.setX(-1200);
            }
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
