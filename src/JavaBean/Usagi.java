package JavaBean;

import java.awt.*;

public class Usagi extends GameObj{



    public Usagi() {
    }

    public Usagi(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }
}
