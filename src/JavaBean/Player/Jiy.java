package JavaBean.Player;

import Utils.ImageUtils;

import java.awt.*;

public class Jiy extends GamePlayer{
    private Image explode = ImageUtils.explode2;
    public Jiy(int x, int y, Image img, int height, int weight, int speed, int hp, int explodenum, int skillcount) {
        super(x, y, img, height, weight, speed, hp, explodenum, skillcount, 2);
        super.setType(0);
        super.setMaxexplodenum(2);
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
        return "Jiy{explode = " + explode + "}";
    }


}
