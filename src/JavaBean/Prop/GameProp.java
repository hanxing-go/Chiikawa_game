package JavaBean.Prop;

import java.awt.*;
import java.awt.font.ImageGraphicAttribute;

public class GameProp {
    //游戏道具类
    // 游戏道具应该有如下属性:
    /*
     - 对HP的改变，可能是加，也可能是减，也可能不变
     - 对角色速度的改变，可能是加，也可能是减，也可能是暂时加减
     - 对角色子弹速度的改变，可能是减，也可能是加，也可能是暂时加减
     - 对角色子弹数量的改变，单发，双发，三发等等
     - 对角色子弹伤害的改变，*1 *2等等
     */
    // 道具坐标：x,y ;   道具宽高: height, weight;   道具种类:type;  道具本身的速度: speed;     道具图片
    // 道具对HP的影响:impacthp;    道具对子弹速度的影响: impactSpeed;   道具对子弹数量的改变: impactNum
    private int x;
    private int y;
    private int weight;
    private int height;
    private Image img;
    private Image underImg;
    private int type;
    private int speed;
    private int impacthp;
    private int impctspeed;
    private int impactNum;
    private int impactDamage;
    private int vis = 0;

    public GameProp() {
    }

    public GameProp(int x, int y, int weight, int height, Image img, Image underImg,
                    int type, int speed, int impacthp, int impctspeed, int impactNum, int impactDamage) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
        this.img = img;
        this.type = type;
        this.speed = speed;
        this.impacthp = impacthp;
        this.impctspeed = impctspeed;//这个是一个倍率
        this.impactNum = impactNum;
        this.impactDamage = impactDamage;
        this.underImg = underImg;
    }



    public void paintSelf(Graphics g) {

        //重绘自己
        g.drawImage(this.img,this.x,this.y,null);
        this.setX(this.getX() - this.getSpeed());
    }

    public Rectangle getRectangle() {
        return new Rectangle(x,y,weight,height);
    }

    /**
     * 获取
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * 设置
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * 设置
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获取
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * 获取
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * 获取
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * 设置
     * @param speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * 获取
     * @return impacthp
     */
    public int getImpacthp() {
        return impacthp;
    }

    /**
     * 设置
     * @param impacthp
     */
    public void setImpacthp(int impacthp) {
        this.impacthp = impacthp;
    }

    /**
     * 获取
     * @return impctspeed
     */
    public int getImpctspeed() {
        return impctspeed;
    }

    /**
     * 设置
     * @param impctspeed
     */
    public void setImpctspeed(int impctspeed) {
        this.impctspeed = impctspeed;
    }

    /**
     * 获取
     * @return impactNum
     */
    public int getImpactNum() {
        return impactNum;
    }

    /**
     * 设置
     * @param impactNum
     */
    public void setImpactNum(int impactNum) {
        this.impactNum = impactNum;
    }

    public String toString() {
        return "GameProp{x = " + x + ", y = " + y + ", weight = " + weight + ", height = " + height + ", type = " + type + ", speed = " + speed + ", impacthp = " + impacthp + ", impctspeed = " + impctspeed + ", impactNum = " + impactNum + "}";
    }

    /**
     * 获取
     * @return img
     */
    public Image getImg() {
        return img;
    }

    /**
     * 设置
     * @param img
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * 获取
     * @return impactDamage
     */
    public int getImpactDamage() {
        return impactDamage;
    }

    /**
     * 设置
     * @param impactDamage
     */
    public void setImpactDamage(int impactDamage) {
        this.impactDamage = impactDamage;
    }

    public void setVis(int vis) {
        this.vis = vis;
    }

    public int getVis() {
        return vis;
    }

    /**
     * 获取
     * @return underImg
     */
    public Image getUnderImg() {
        return underImg;
    }

    /**
     * 设置
     * @param underImg
     */
    public void setUnderImg(Image underImg) {
        this.underImg = underImg;
    }
}
