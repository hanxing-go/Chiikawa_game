import JavaBean.*;
import Utils.ImageUtils;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;

import java.util.*;
import java.util.List;


public class GameFrame extends JFrame{


    private int flag = 1;
    private ImageUtils imageUtils = new ImageUtils();
    private Background background = new Background(0,0, imageUtils.getBackgroundImg2(),0,0,5);
    private Background background1 = new Background(2400,0, imageUtils.getBackgroundImg2(),1,1,5);
    private Usagi usagi = new Usagi(100,250,imageUtils.getUsagi(),
            120,114,0);

//    private Explode explode = new Explode(usagi.getX() + usagi.getWeight() + 5, usagi.getY() + usagi.getWeight() - 45,imageUtils.getExplode(),
//            10,10, 2);

    private List<Explode> explodeList = new ArrayList<>();// 批量添加子弹，创建队列集合

//    private Enemy enemy = new Enemy(1200,250,imageUtils.getEnemy(),50,51, 5);
    private List<Enemy> enemies = new ArrayList<>();

    private Robot robot;
    public GameFrame () {
        super("Chiikawa");
    }



    public void initFrame () {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //创建一个窗口，并且设置名字
        this.setSize(1200,580);
        //设定好高宽
        this.setResizable(false);
        //设置窗口大小不可变
        this.setLocationRelativeTo(null);
        //设置窗口初始居中

        Image icon = imageUtils.getIconImg();
        this.setIconImage(icon);
        //设置窗口图标
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //添加窗口关闭
        this.setVisible(true);


        //添加鼠标监听事件
        this.addMouse();
        this.addKey();

//        repaint();

        while (true) {

            if (flag == 0) {
                addExplode();
                addEnemy();
                removeObj();
                // 如果游戏失败，修改flag = 2
                checkGame();
            }
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Image iBuffer;
    private Graphics gBuffer;
    private long count = 1;
    // 这里要实现双缓冲技术
    @Override
    public void paint(Graphics g) {

        if (iBuffer == null) {
            //如果没有缓冲对象，则先创立一个缓冲对象
            iBuffer = createImage(this.getSize().width, this.getSize().height);
            gBuffer = iBuffer.getGraphics();
        }
        gBuffer.setColor(Color.white);//设置初始界面为白色
        //为了让界面看上去更好看，用一个线程休眠
        if (count == 1) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
}
        if (flag == 0) {

            background.paintSelf(gBuffer);
            background1.paintSelf(gBuffer);
            usagi.paintSelf(gBuffer);
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).paintSelf(gBuffer);
            }

            for (int i = 0; i < explodeList.size(); i++) {
                explodeList.get(i).paintSelf(gBuffer);
            }
        } else if (flag == 1) {

            gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
            gBuffer.drawImage(background.getImg(), background.getX(), background.getY(),null);
            gBuffer.drawImage(background1.getImg(), background1.getX(), background1.getY(),null);
            gBuffer.drawImage(imageUtils.getCoverImg(),445,110,null);
            gBuffer.drawImage(imageUtils.getTitleImg(),435,390,null);
        } else if (flag == 2) {
            System.out.println("游戏失败");
        }
        g.drawImage(iBuffer, 0, 0, this);
        count++;//每重绘一次，就自增

    }

    private void checkGame() {
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getRectangle().intersects(usagi.getRectangle())) {
//                flag = 2;//修改为游戏失败状态
//                System.out.println("游戏失败");
            }
        }
    }

    private void removeObj() {
        //两种情况删除
        //1. 超出边界的时候删除
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getX() < -60) {
                enemies.remove(i);
            }
        }

        for (int j = 0; j < explodeList.size(); j++) {

            if (explodeList.get(j).getX() > 1200) {
                explodeList.remove(j);//判断是否出界
            }
        }
        for (int i = 0; i < explodeList.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
//
                if (enemies.get(j).getRectangle().intersects(explodeList.get(i).getRectangle())) {
                    explodeList.get(i).setX(1400);
                    enemies.get(j).setX(-500);
                    //将子弹与敌人的坐标修改出去，后面再统一删除，不知道为啥直接删会越界
                }

            }

        }
    }



    private void addExplode() {
        if (count % 8 == 1) {
            explodeList.add(new Explode(usagi.getX() + usagi.getWeight() + 5, usagi.getY() + usagi.getWeight() - 45, imageUtils.getExplode(),
                    10, 10, 20));
        }
    }

    private void addEnemy() {
        Random random = new Random();
        if (count % 20 == 1) {
            // 对每一个敌人的纵坐标应该是要随机的
            int y = 60 + random.nextInt(460);
//            System.out.println(y);
            enemies.add(new UprightWorm(1200,y,imageUtils.getUprightWorm(),61,60, 6));
        } else if (count % 40 == 2) {
            int y = 60 + random.nextInt(470);
            enemies.add(new CreepWorm(1200, y, imageUtils.getCreepWorm(),61,45,5));
        } else if (count % 500 == 3) {
            int y = 0 + random.nextInt(400);
            System.out.println(y);
            enemies.add(new BigWorm(1200, y, imageUtils.getBigWorm(), 177, 200, 15));
        }
    }


    private void addKey() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == ' ') {
                    flag = flag ^ 1;

//                    if (flag == 0) {
//                        Point p = getLocationOnScreen();
//                        System.out.println(p.x + " " + p.y);
//                        System.out.println(usagi.getX() + " " + usagi.getY());
//                        System.out.println(p.x + usagi.getX());
//                        System.out.println(p.y + usagi.getY());
//
//                        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//                        Point mousePoint = pointerInfo.getLocation();
//                        System.out.println(mousePoint.getX() +" "+ mousePoint.getY());
////                        while (!(mousePoint.getX() == (p.x + usagi.getY()) * 1.0) && !(mousePoint.getY() == (p.x + usagi.getY()) * 1.0)) {
////                            robot.mouseMove(p.x, p.y);
//                        //非常危险的代码，慎用
////                        }
//                    }

                    repaint();
                }
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
    }


    private void addMouse() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                flag = 0;
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                int x = e.getX();
                int y = e.getY();
                if (x >= usagi.getWeight() /2  && x <= 1200 - usagi.getWeight() / 2 && flag == 0) {
                    usagi.setX(e.getX() - usagi.getWeight() / 2);

                }
                if (y >= usagi.getHeight() && flag == 0) {
                    usagi.setY(e.getY() - usagi.getHeight());
                }
            }
        });
    }
}
