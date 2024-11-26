package Utils;

import JavaBean.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjUtils {
    public static List<Enemy> enemies = new ArrayList<>();
    public static List<GameProp> gameProps = new ArrayList<>();
    public static List<Explode> explodeList = new ArrayList<>();// 批量添加子弹，创建队列集合
    public static BirdBoss birdBoss = new BirdBoss(1498,170,ImageUtils.birdBoss,100,298,0);

    public static Usagi usagi = new Usagi(100,250,ImageUtils.Usagi,
            100,100,0,5,1,3);

    public static Background background = new Background(0,0, ImageUtils.backgroundImg2,0,0,5);
    public static Background background1 = new Background(2400,0, ImageUtils.backgroundImg2,1,1,5);
    public static int numEnemy = 0;//统计生成的怪物的数量
    public static int STAGE = 10;//阶段，由简单到难
    public static long count = 0;
    public static int gameScore = 0;
    public static boolean bosstrue = false;


    public static int flag = 1;

    public static void removeAll() {
        for (int i = 0; i < enemies.size(); i++) {
            enemies.remove(i);
        }

        for (int i = 0; i < explodeList.size(); i++) {
            explodeList.remove(i);
        }

        for (int i = 0; i < gameProps.size(); i++) {
            gameProps.remove(i);
        }
    }
    public static void removeObj() {
        //两种情况删除
        //1. 超出边界的时候删除
        for (int i = 0; i < enemies.size(); i++) {
            //判断是否和boss相撞
            if (birdBoss.getX() <= 800 && checkIntersect(enemies.get(i).getRectangle(),birdBoss.getRectangle())
            && enemies.get(i).getType() < 5 ) {
                enemies.get(i).setX(-2000);
            }

            if (checkIntersect(enemies.get(i).getRectangle(), usagi.getRectangle())) {
                flag = 2;//游戏失败
            }

            if (enemies.get(i).getX() < -60) {
                enemies.remove(i);
            }
        }

        for (int j = 0; j < explodeList.size(); j++) {

            //判断是否与boss相撞
            if (birdBoss.getX() <= 800 && checkIntersect(explodeList.get(j).getRectangle(), birdBoss.getRectangle())) {
                birdBoss.setHP(birdBoss.getHP() - usagi.getDamage());
                explodeList.get(j).setX(1400);
//                System.out.println(birdBoss.getHP());
                if (birdBoss.getHP() < 0) {
//                    System.out.println("boss死了");
                    //直接判断游戏胜利得了
//                    System.out.println("游戏胜利");
                    birdBoss.setImg(ImageUtils.birdBoss2);
                    System.out.println("设置成功");
                    flag = 3;
                }
            }
            if (explodeList.get(j).getX() > 1200) {
                explodeList.remove(j);//判断是否出界
            }
        }
        for (int i = 0; i < explodeList.size(); i++) {

            for (int j = 0; j < enemies.size(); j++) {
//
                if (checkIntersect(enemies.get(j).getRectangle(), explodeList.get(i).getRectangle())) {
                    explodeList.get(i).setX(1400);
                    enemies.get(j).setHP(enemies.get(j).getHP() - 1);
                    //将子弹与敌人的坐标修改出去，后面再统一删除，不知道为啥直接删会越界
                    //如果生命值小于等于0则
                    if (enemies.get(j).getHP() <= 0)
                    {
                        enemies.get(j).setX(-2000);
                        gameScore += enemies.get(j).getType();
//                        System.out.println(gameScore);

                    }
                }

            }

        }
    }

    public static boolean checkGame() {
        return checkIntersect(birdBoss.getRectangle(),usagi.getRectangle());
    }

    public static void addExplode() {
        if (ObjUtils.count % 8 == 1) {
            ObjUtils.explodeList.add(new Explode(usagi.getX() + usagi.getWeight() + 5, usagi.getY() + usagi.getWeight() - 45, ImageUtils.explode,
                    10, 10, 20));
        }
    }

    public static void addEnemy() {
        Random random = new Random();
        if (count % (3 * STAGE) == 1) {
            // 对每一个敌人的纵坐标应该是要随机的
            int y = 60 + random.nextInt(460);
//            System.out.println(y);
            enemies.add(new UprightWorm(1200,y,ImageUtils.uprightWorm,61,60, 6));
            numEnemy++;
        } else if (count % (2 * STAGE) == 2) {
            int y = 60 + random.nextInt(470);
            enemies.add(new CreepWorm(1200, y, ImageUtils.CreepWorm,61,45,5));
//            enemies.add(new BirdBoss(1498,250,ImageUtils.getBirdBoss(),200,298,5));
            numEnemy++;
//        } else if (numEnemy % (5 * STAGE) == 0 && numEnemy != 0) {
        }
        if (numEnemy % 20 == 0) {
            int y = 0 + random.nextInt(400);
//            System.out.println(numEnemy);
            enemies.add(new BigWorm(1200, y, ImageUtils.bigWorm, 175, 175, 15));
            numEnemy++;
        }


    }

    // 写一个函数判断两个物体是否相撞，来提高代码可读性
    private static boolean checkIntersect(Rectangle r1, Rectangle r2) {
        return r1.intersects(r2);
    }

}
