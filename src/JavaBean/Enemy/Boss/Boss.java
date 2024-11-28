package JavaBean.Enemy.Boss;

import JavaBean.Enemy.Enemy;

import javax.management.relation.RelationNotFoundException;
import java.awt.*;
import java.util.Random;

public abstract class Boss extends Enemy {
    private int speedy;
    private Random r = new Random();
    private int bosstype;

    public Boss(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
    }


    protected abstract void behavior();

    public void move() {
        // Boss应该随机上下移动
        if (super.getY() > 300) {
            this.setSpeedy( 5 + r.nextInt(10) );
            this.setSpeedy(-this.getSpeedy());
        }
        if (super.getY() < -100) {
            this.setSpeedy( 5 + r.nextInt(10) );
        }
        super.setY(super.getY() + this.getSpeedy());
    };
    /**
     * 获取
     * @return speedy
     */
    public int getSpeedy() {
        return speedy;
    }

    /**
     * 设置
     * @param speedy
     */
    public void setSpeedy(int speedy) {
        this.speedy = speedy;
    }

    public String toString() {
        return "Boss{speedy = " + speedy + "}";
    }

    /**
     * 获取
     * @return r
     */
    public Random getR() {
        return r;
    }

    /**
     * 设置
     * @param r
     */
    public void setR(Random r) {
        this.r = r;
    }

    /**
     * 获取
     * @return bosstype
     */
    public int getBosstype() {
        return bosstype;
    }

    /**
     * 设置
     * @param bosstype
     */
    public void setBosstype(int bosstype) {
        this.bosstype = bosstype;
    }
}
