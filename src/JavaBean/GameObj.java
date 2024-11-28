package JavaBean;

import java.awt.*;

public class GameObj {
    //对于每一个游戏物体都有如下属性
//      - 物体所在的x轴
//      - 物体所在的y轴
//      - 物体本身的图片
    private int x;
    private int y;
    private Image img;
    private int height;
    private int weight;
    private int speed;


    public GameObj() {
    }


    public GameObj(int x, int y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    public GameObj(int x, int y, Image img, int height, int weight, int speed) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
    }



    public void paintSelf(Graphics g) {

        //重绘自己
        g.drawImage(this.img,this.x,this.y,null);
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
        System.out.println("换图");
    }

    public String toString() {
        return "GameObj{x = " + x + ", y = " + y + ", img = " + img + "}";
    }

    /**
     * 获取
     * @return Height
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
}
