package JavaBean;

import java.awt.*;

public class Usagi extends GamePlayer{
    public Usagi(int x, int y, Image img, int height, int weight, int speed, int hp, int explodenum, int skillcount) {
        super(x, y, img, height, weight, speed, hp, explodenum, skillcount, 1);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }
}
