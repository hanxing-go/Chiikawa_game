package JavaBean;

import java.awt.*;

public class Background extends GameObj{
    public Background(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);

        setX(getX() - getSpeed());
//        if (getHeight() == 1)
//        System.out.println(getX() + " " + getY());
        if (getX() == -2400) {
            setX(2400);
            //达到地图无缝衔接的办法
        }
    }
}
