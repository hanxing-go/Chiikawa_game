package JavaBean.Enemy.Boss.Dragon;

import JavaBean.Enemy.Boss.Bird.Egg;
import JavaBean.Enemy.Boss.Boss;
import JavaBean.Prop.Meteorite;
import JavaBean.Prop.Shit;
import Utils.ImageUtils;
import Utils.ObjUtils;

import java.awt.*;
import java.util.Random;

public class DragonBoss extends Boss {
    private int second = 0;
    private int[] behavior_probability = {1,1,2,2,1,2,2,0,3,3};
    private Random r = new Random();
    private int crashflag = 0;//设置一个冲撞标记


    public DragonBoss(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(1000);
        super.setType(250);
        super.setSpeedy(5);
        super.setBosstype(2);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        g.drawImage(super.getImg(),super.getX(),super.getY(),null);
        behavior();

    }
    @Override
    protected void behavior() {
        second++;
        int behavior = r.nextInt(10);
        //一开始缓缓入场
        if (super.getX() > 950 ) {
            super.setX(super.getX() - 3);
        } else if (crashflag == 0){
            // boss的行为模式，为每种模式设置不同的概率
            if (second % 60 == 0) {
                if (behavior_probability[behavior] == 1) {
                    attack1(behavior);
                } else if (behavior_probability[behavior] == 2) {
                    // 行为2 : 召唤陨石
                    attack2(behavior);
                } else if (behavior_probability[behavior] == 3) {
                    //修改X的方向
                    attack3();
                }
            }
        }
        super.move();
        //判断是否冲撞结束
        if (super.getX() < -420 && crashflag == 1) {
            crashflag = crashflag ^ 1;
//            System.out.println("冲撞结束");
            super.setImg(ImageUtils.bossX);//回到原来的图像
            super.setX(1498);
            super.setSpeed(0);
        }
    }



    private void attack3() {
        super.setImg(ImageUtils.bossX1 );//设置为红温图片
        super.setSpeed(20);
        crashflag = crashflag ^ 1;
    }

    private void attack2(int behavior) {
        // 行为2: 召唤陨石
        int x = r.nextInt(500) + 500;
        int y = 0 - r.nextInt(100);
        if (behavior % 2 == 0) {
            ObjUtils.gameProps.add(new Meteorite(x, y, 72, 72, ImageUtils.meteorite));
        } else {
            ObjUtils.gameProps.add(new Meteorite(x, y, 20,20,ImageUtils.meteorite1));
            ObjUtils.gameProps.add(new Meteorite(x + 120, y - 150, 20,20,ImageUtils.meteorite1));
            ObjUtils.gameProps.add(new Meteorite(x, y - 230, 20,20,ImageUtils.meteorite1));
        }
    }
    private void attack1(int behavior) {
        // 行为1 : 召唤小弟乱冲
        // 就不写难了，就写召唤两个
        int x1 = r.nextInt(300) + 1200;
        int y1 = r.nextInt(500);
        int x2 = r.nextInt(300) + 1200;
        int y2 = r.nextInt(500);
        int speed = r.nextInt(5) + 8;
        int speedY = r.nextInt(5) + 8;
        if (behavior % 2 ==  0) {
            ObjUtils.enemies.add(new Brother(x1, y1, ImageUtils.brother,100,65, speed, speedY, 10));
            ObjUtils.enemies.add(new Brother(x2, y2, ImageUtils.brother,100,65, speed, speedY, 10));
        } else {
            ObjUtils.enemies.add(new Brother(x1, y1, ImageUtils.brother1,100,65, speed, speedY, 20));
            ObjUtils.enemies.add(new Brother(x2, y2, ImageUtils.brother1,100,65, speed, speedY, 20));
        }
    }

    @Override
    public Rectangle getRectangle() {
        //由于龙的图片比较特殊，所以这个得专门修改一下
        return new Rectangle(super.getX() + 146, super.getY(), super.getWeight(), super.getHeight());
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
