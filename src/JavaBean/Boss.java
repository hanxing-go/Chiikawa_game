package JavaBean;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Boss extends Enemy{
    private int speedy;

    public Boss(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
    }

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
}
