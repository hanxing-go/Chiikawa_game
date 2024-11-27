package JavaBean.Enemy;

import JavaBean.GameObj;

import java.awt.*;

public class Enemy extends GameObj {
    private int HP;
    private int Type;
    public Enemy(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
    }

    public Enemy() {
    }



    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        super.setX(super.getX() - super.getSpeed());
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * 获取
     * @return Type
     */
    public int getType() {
        return Type;
    }

    /**
     * 设置
     * @param Type
     */
    public void setType(int Type) {
        this.Type = Type;
    }

    public String toString() {
        return "Enemy{HP = " + HP + ", Type = " + Type + "}";
    }
}
