package JavaBean.Explode;

import JavaBean.GameObj;

import java.awt.*;

public class Explode extends GameObj {
    private int damage = 1;//设置子弹的伤害，一开始默认设置为1
    private int speedy = 0;
    public Explode(int x, int y, Image img, int height, int weight, int speed, int speedy, int damage) {
        super(x, y, img, height, weight, speed);
        this.damage = damage;
        this.speedy = speedy;
    }

    public Explode(int damage) {
        this.damage = damage;
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        super.setX(super.getX() + super.getSpeed());
        super.setY(super.getY() + speedy);
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }


    /**
     * 获取
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * 设置
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String toString() {
        return "Explode{damage = " + damage + "}";
    }
}
