package JavaBean;

import java.awt.*;

public class BirdBoss extends Enemy{
    public BirdBoss(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(250);
        super.setType(250);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(super.getImg(),super.getX(),super.getY(),null);
        //一开始缓缓入场
        if (super.getX() > 800) {
            super.setX(super.getX() - 3);
        } else {
            // boss的行为模式
        }
//        System.out.println(super.getX() + " " + super.getY());
    }

    @Override
    public Rectangle getRectangle() {
//        return super.getRectangle();
        //由于bossBird的图片比较特殊，所以这个得专门修改一下
        return new Rectangle(super.getX(), super.getY() + 150, super.getWeight(), super.getHeight());
    }

    @Override
    public int getHP() {
        return super.getHP();
    }

    @Override
    public void setHP(int HP) {
        super.setHP(HP);
    }
}
