package JavaBean;

import Utils.ImageUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BirdBoss extends Boss{
    private int second = 0;
    private int[] behavior_probability = {1,1,0,1,1,2,2,2,3,3};
    private Random r = new Random();
    public BirdBoss(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
        super.setHP(250);
        super.setType(250);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(super.getImg(),super.getX(),super.getY(),null);
        second++;
        int behavior = r.nextInt(10);
        //一开始缓缓入场
        if (super.getX() > 800) {
            super.setX(super.getX() - 3);
        } else {
            // boss的行为模式，为每种模式设置不同的概率

            if (second % 60 == 0) {
                if (behavior_probability[behavior] == 1) {
                    //从大鹅的屁股里面出来的屎
                    super.fightProp.add(new Shit(super.getX(), super.getY() + 200, 121, 120, ImageUtils.shit,
                            0, 5, -5, 3, 0));
                } else if (behavior_probability[behavior] == 2) {
                    //从大鹅屁股里面出来的蛋
                    // 行为1 : 拉屎 设置为每隔一定时间就拉一坨屎
                    // 行为2 : 下蛋 设置为每隔一定时间就下蛋

//                    GameFrame.(new Egg(super.getX(), super.getY() + 200, ImageUtils.egg,
//                            100,135,5));
                } else if (behavior_probability[behavior] == 3) {

                }
            }

        }

        // 遍历大鹅的攻击道具队列，进行重绘
        for (int i = 0; i < fightProp.size(); i++) {
            fightProp.get(i).paintSelf(g);
        }

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
