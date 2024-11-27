package JavaBean.Player;

import Utils.ImageUtils;

import java.awt.*;

public class Eight extends GamePlayer{
    private Image explode = ImageUtils.explode;

    public Eight(int x, int y, Image img, int height, int weight, int speed, int hp, int explodenum, int skillcount) {
        super(x, y, img, height, weight, speed, hp, explodenum, skillcount, 1);
        super.setType(1);
    }

    /**
     * 获取
     * @return explode
     */
    public Image getExplode() {
        return explode;
    }

    /**
     * 设置
     * @param explode
     */
    public void setExplode(Image explode) {
        this.explode = explode;
    }

    public String toString() {
        return "Eight{explode = " + explode + "}";
    }

    /**
     * 获取
     * @return type
     */

}
