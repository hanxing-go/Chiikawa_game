package Utils;

import JavaBean.*;
import JavaBean.Enemy.Worm.*;
import JavaBean.Enemy.Boss.BirdBoss;
import JavaBean.Enemy.Enemy;
import JavaBean.Explode.Explode;
import JavaBean.Player.Eight;
import JavaBean.Player.GamePlayer;
import JavaBean.Player.Jiy;
import JavaBean.Player.Usagi;
import JavaBean.Prop.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjUtils {
    public static List<Enemy> enemies = new ArrayList<>();
    public static List<GameProp> gameProps = new ArrayList<>();
    public static List<Explode> explodeList = new ArrayList<>();// 批量添加子弹，创建队列集合
    public static List<GamePlayer> gamePlayers = new ArrayList<>();
    public static List<Enemy> boss = new ArrayList<>();
    public static BirdBoss birdBoss = new BirdBoss(1498,170,ImageUtils.birdBoss,100,298,0);
//    public static

//    public static Usagi usagi = new Usagi(100,250,ImageUtils.Usagi,
//            100,100,0,5,1,3);



    public static Background background = new Background(0,0, ImageUtils.backgroundImg2,0,0,5);
    public static Background background1 = new Background(2400,0, ImageUtils.backgroundImg2,1,1,5);
    public static int numEnemy = 0;//统计生成的怪物的数量
    public static int STAGE = 10;//阶段，由简单到难
    public static long count = 0;
    public static int gameScore = 0;
    public static boolean bosstrue = false;


    public static int flag = 1;
    public static boolean checkGame() {
        //如果角色都阵亡了，显然游戏失败
        if (gamePlayers.size() == 0) {
            flag = 2;
            return true;
        }
        return false;
    }

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

        for (int i = 0; i < gamePlayers.size(); i++) {
            gamePlayers.remove(i);
        }
    }
    public static void addObj() {
        addEnemy();
        addExplode();
        addGamePlayer();
        addProp();
    }
    public static void removeObj() {
        removeEnemy();        // 删除敌人
        removeExplode();        // 删除子弹
        removePlayer();        // 删除角色
        removeProp();        // 删除道具
    }

    public static void addProp() {
        // 添加道具应该是随机的
        Random random = new Random();
        int type = random.nextInt(21);
        int[] proparry = new int[]{8, 8, 3, 2, 7, 7, 2, 2, 11, 5, 12, 12, 3, 2, 11, 2, 2, 11, 11, 5};

        int y = 45 + random.nextInt(500);


        if (count % 380 == 1) {
            switch(proparry[type]) {
                case 2:
                    gameProps.add(new Cookies(1400, y, ImageUtils.cooies));
                    break;
                case 3:
                    int pajamsindex = random.nextInt(gamePlayers.size());
                    int pajams = gamePlayers.get(pajamsindex).getType();
                    if (pajams == 0) {
                        gameProps.add(new Pajams(1400, y, ImageUtils.pajamsjiy));
                    } else if (pajams == 1) {
                        gameProps.add(new Pajams(1400, y, ImageUtils.pajamseight));
                    } else if (pajams == 2) {
                        gameProps.add(new Pajams(1400, y, ImageUtils.pajamsUsaqi));
                    }
                    break;
                case 5:
                    gameProps.add(new Wand(1400, y, ImageUtils.wand));
                    break;
                case 7:
                    gameProps.add(new Book(1400, y, ImageUtils.wand));
                case 8:
                    // 小八照相机，直接召唤小八，嘻嘻
                    gameProps.add(new Camera(1400, y, ImageUtils.camera));
                    break;
                case 11:
                    gameProps.add(new Noodles(1400, y, ImageUtils.noodles));
                    break;
                case 12:
                    gameProps.add(new Mushroom(1400, y, ImageUtils.mushroom));
                    break;
            }

        }
    }

    public static void removeProp() {
        // 执行碰撞逻辑
        for (int i = 0; i < gameProps.size(); i++) {
            for (int j = 0; j < gamePlayers.size(); j++) {
                if (checkIntersect(gameProps.get(i).getRectangle(),gamePlayers.get(j).getRectangle())) {
                    // 如果碰撞，就先把他移到屏幕外面
                    PropUtils.getBuff(gameProps.get(i));                // 对于不同的道具执行不同的功能
                }
            }
        }
        // 执行删除逻辑
        for (int i = 0; i < gameProps.size(); i++) {
            if (gameProps.get(i).getX() <= -1200) {
                gameProps.remove(i);
            }
        }
    }



    public static int flagusaqi1 = 1;
    public static int flagusaqi2 = 0;
    public static int flageight1 = 0;
    public static int flageight2 = 0;
    public static int flagjiy1 = 0;
    public static int flagjiy2 = 0;
    public static void addGamePlayer(){
//        System.out.println("调用了");
        //添加角色
        if (flagusaqi1 == 1 && flagusaqi2 == 0) {
            gamePlayers.add(new Usagi(-666,-666,ImageUtils.Usagi,
                    100,100,0,15,1,0));
            // 初始技能为0
            flagusaqi2 = 1;
        }
        //可以设置两个变量来判断是否添加小八
        if (flageight1 == 1 && flageight2 == 0) {
//            System.out.println("小八加入了战斗");
            //将小八的左边先设置到外边，然后追踪鼠标，修改他的坐标就可以了
            gamePlayers.add(new Eight(-666,-666,ImageUtils.Eight,116,120,0,15,1,3));
            flageight2 = 1;//添加过一次就不可以再添加了
        }
        if (flagjiy1 == 1 && flagjiy2 == 0) {
            gamePlayers.add(new Jiy(-666, -666, ImageUtils.Jiy, 101,95,0,15,1,3));
            flagjiy2 = 1;
        }
    }

    public static void removePlayer() {
        for (int i = 0; i < gamePlayers.size(); i++) {
            if (gamePlayers.get(i).getHp() <= 0) {
//                System.out.println("删除角色");
                gamePlayers.remove(i);
            }
        }
    }

    public static void addExplode() {
        addUsaqiExplode();
        //jiy每24次攻击一次
        addJiyExplode();
        addEightExplode();

    }
    private static void addEightExplode(){
        if (ObjUtils.count % 32 == 1) {
            for (int i = 0; i < gamePlayers.size(); i++) {

                if (gamePlayers.get(i).getType() == 1) {
                    //如果是小八，一共有两个模式
                    int mode = gamePlayers.get(i).getExplodenum();
                    switch (mode) {
                        case 2:
                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    ImageUtils.explode4,
                                    30, 30,
                                    20, -15,
                                    gamePlayers.get(i).getDamage()));

                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    ImageUtils.explode5,
                                    30, 30,
                                    20, 15,
                                    gamePlayers.get(i).getDamage()));


                        case 1:
                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    ImageUtils.explode3,
                                    30, 30,
                                    20, 0,
                                    gamePlayers.get(i).getDamage()));

                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    ImageUtils.explode6,
                                    30, 30,
                                    20, -10,
                                    gamePlayers.get(i).getDamage()));

                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    ImageUtils.explode7,
                                    30, 30,
                                    20, 10,
                                    gamePlayers.get(i).getDamage()));

                    }

                }
            }
        }
    }

    private static void addJiyExplode() {
        if (ObjUtils.count % 32 == 1 || ObjUtils.count % 32 == 3) {
            for (int i = 0; i < gamePlayers.size(); i++) {
                if (gamePlayers.get(i).getType() == 0 && ObjUtils.count % 32 == 1) {//如果是吉伊
                    ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                            gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                            gamePlayers.get(i).getExplode(),
                            30, 30,
                            20, 0,
                            gamePlayers.get(i).getDamage()));
                }
                if (gamePlayers.get(i).getType() == 0 && ObjUtils.count % 32 == 3 && gamePlayers.get(i).getExplodenum() == 2) {//如果是吉伊
                    ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                            gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                            gamePlayers.get(i).getExplode(),
                            30, 30,
                            20, 0,
                            gamePlayers.get(i).getDamage()));
                }
            }
        }

    }

    private static void addUsaqiExplode() {
        //usaqi每八次就攻击一次
        if (ObjUtils.count % 8 == 1) {
            for (int i = 0; i < gamePlayers.size(); i++) {
                if (gamePlayers.get(i).getType() == 2) {//如果是乌萨奇，子弹模式一共有三种
                    int mode = gamePlayers.get(i).getExplodenum();
                    switch (mode) {
                        case 1:
                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    gamePlayers.get(i).getExplode(),
                                    30, 30,
                                    20, 0,
                                    gamePlayers.get(i).getDamage()));//初始的单发模式
                            break;

                        case 2:
                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    gamePlayers.get(i).getExplode(),
                                    30, 30,
                                    20, 0,
                                    gamePlayers.get(i).getDamage()));
                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 40,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    gamePlayers.get(i).getExplode(),
                                    30, 30,
                                    20, 0,
                                    gamePlayers.get(i).getDamage()));//修改为双发模式
                            break;

                        case 3:
                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    gamePlayers.get(i).getExplode(),
                                    30, 30,
                                    20, 6,
                                    gamePlayers.get(i).getDamage()));
                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    gamePlayers.get(i).getExplode(),
                                    30, 30,
                                    20, 0,
                                    gamePlayers.get(i).getDamage()));
                            ObjUtils.explodeList.add(new Explode(gamePlayers.get(i).getX() + gamePlayers.get(i).getWeight() + 5,
                                    gamePlayers.get(i).getY() + gamePlayers.get(i).getHeight() / 2 + 20,
                                    gamePlayers.get(i).getExplode(),
                                    30, 30,
                                    20, -6,
                                    gamePlayers.get(i).getDamage()));
                    }

                }
            }
        }
    }

    public static void removeExplode() {
        // 先执行子弹相撞后移出外面的逻辑
        for (int i = 0; i < explodeList.size(); i++) {

            for (int j = 0; j < enemies.size(); j++) {
                if (checkIntersect(enemies.get(j).getRectangle(), explodeList.get(i).getRectangle())) {
                    explodeList.get(i).setX(1400);
                    enemies.get(j).setHP(enemies.get(j).getHP() - explodeList.get(i).getDamage());
                    //将子弹与敌人的坐标修改出去，后面再统一删除，不知道为啥直接删会越界
                    //如果生命值小于等于0则
                    if (enemies.get(j).getHP() < 0)
                    {
                        enemies.get(j).setX(-2000);
                        gameScore += enemies.get(j).getType();
                    }
                }
            }

            for (GameProp gameProp : gameProps) {
                if (checkIntersect(explodeList.get(i).getRectangle(), gameProp.getRectangle()) && gameProp.getVis() != 1) {
                    gameProp.setVis(1);//将箱子打开
                    gameProp.setImg(gameProp.getUnderImg());
                    explodeList.get(i).setX(1400);
                }
            }

            if (birdBoss.getX() <= 800 && checkIntersect(explodeList.get(i).getRectangle(), birdBoss.getRectangle())) {
                birdBoss.setHP(birdBoss.getHP() - explodeList.get(i).getDamage());
                explodeList.get(i).setX(1400);

                if (birdBoss.getHP() < 0) {
//                    System.out.println("boss死了");
                    //直接判断游戏胜利得了
//                    System.out.println("游戏胜利");
                    birdBoss.setImg(ImageUtils.birdBoss2);
                    System.out.println("设置成功");
                    flag = 3;
                }

            }
        }
        //再执行删除逻辑
        for (int i = 0; i < explodeList.size(); i++) {
            if (explodeList.get(i).getX() > 1200) {
                explodeList.remove(i);
            }
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
            if (y % 3 == 1){
                enemies.add(new CreepWorm(1200, y, ImageUtils.CreepWorm,45,61,5));
            } else if (y % 3 == 2){
                enemies.add(new RedWorm(1200,y,ImageUtils.redWorm,66,60, 6));
            } else {
                enemies.add(new RedWorm(1200,y,ImageUtils.greenWorm,66,60, 6));
            }
//            enemies.add(new BirdBoss(1498,250,ImageUtils.getBirdBoss(),200,298,5));
            numEnemy++;
        } else if (count % (5 * STAGE) == 3) {
            int y = 60 + random.nextInt(450);
            enemies.add(new FishWorm(1200, y, ImageUtils.FishWorm, 88,70,3));
            numEnemy++;
        }
        if (numEnemy % 20 == 0) {
            int y = 0 + random.nextInt(400);
//            System.out.println(numEnemy);
            enemies.add(new BigWorm(1200, y, ImageUtils.bigWorm, 175, 175, 15));
            numEnemy++;
        }
    }

    public static void removeEnemy() {
        //先执行相撞逻辑
        for (int i = 0; i < enemies.size(); i++) {
            //判断是否和boss相撞
            if (birdBoss.getX() <= 800 && checkIntersect(enemies.get(i).getRectangle(),birdBoss.getRectangle())
                    && enemies.get(i).getType() < 5 ) {
                enemies.get(i).setX(-2000);
            }
            //判断是否和角色相撞
            for (int j = 0; j < gamePlayers.size(); j++) {
                if (checkIntersect(enemies.get(i).getRectangle(), gamePlayers.get(j).getRectangle())) {
                    gamePlayers.get(j).setHp( gamePlayers.get(j).getHp() - enemies.get(i).getType() );
                    //角色要受到伤害
                    enemies.get(i).setX(-2000);
                }
            }
        }
        //再执行删除逻辑
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getX() < -2000) {
                enemies.remove(i);
            }
        }
    }

    // 写一个函数判断两个物体是否相撞，来提高代码可读性
    private static boolean checkIntersect(Rectangle r1, Rectangle r2) {
        return r1.intersects(r2);
    }

}
