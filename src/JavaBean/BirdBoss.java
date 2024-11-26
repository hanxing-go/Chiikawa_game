package JavaBean;

import Utils.ImageUtils;
import Utils.ObjUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BirdBoss extends Boss{
    private int second = 0;
    private int[] behavior_probability = {1,1,0,1,1,2,2,2,3,0};
    private Random r = new Random();
    private int crashflag = 0;//设置一个冲撞标记


    public BirdBoss(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(250);
        super.setType(250);
        super.setSpeedy(5);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        g.drawImage(super.getImg(),super.getX(),super.getY(),null);
        second++;
        int behavior = r.nextInt(10);

        //一开始缓缓入场
        if (super.getX() > 800 ) {
            super.setX(super.getX() - 3);
        } else if (crashflag == 0){
            // boss的行为模式，为每种模式设置不同的概率
            if (second % 60 == 0) {
                if (behavior_probability[behavior] == 1) {
                    attack1();
                } else if (behavior_probability[behavior] == 2) {
                    // 行为2 : 下蛋 设置为每隔一定时间就下蛋
                    attack2();
                } else if (behavior_probability[behavior] == 3) {
                    //修改鸟的方向
                    super.setImg(ImageUtils.birdBoss1 );//设置为红温图片
                    super.setSpeed(15);
                    crashflag = crashflag ^ 1;
                }
            }


        }

        // Boss应该随机上下移动
        if (super.getY() > 300) {
            super.setSpeedy( 5 + r.nextInt(10) );
            super.setSpeedy(-super.getSpeedy());
        }
        if (super.getY() < -100) {
            super.setSpeedy( 5 + r.nextInt(10) );
        }
        super.setY(super.getY() + super.getSpeedy());

        //判断是否冲撞结束
        if (super.getX() < -420 && crashflag == 1) {
            crashflag = crashflag ^ 1;
//            System.out.println("冲撞结束");
            super.setImg(ImageUtils.birdBoss);//回到原来的图像
            super.setX(1498);
            super.setSpeed(0);
        }

    }


    private void attack2() {
        ObjUtils.enemies.add(new Egg(super.getX(), super.getY() + 200, ImageUtils.egg,
                100,135,5));
        //
        System.out.println("下蛋了");
    }
    private void attack1() {
        // 行为1 : 拉屎 设置为每隔一定时间就拉一坨屎
        ObjUtils.gameProps.add(new Shit(super.getX(), super.getY() + 200, 121, 120, ImageUtils.shit,
                0, 5, -5, 3, 0));
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
