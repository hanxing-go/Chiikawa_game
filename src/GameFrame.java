import JavaBean.*;
import Utils.ImageUtils;
import Utils.ObjUtils;
import Utils.PaintUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.util.List;


public class GameFrame extends JFrame{
    private int flag = 1;
    public GameFrame () {
        super("Chiikawa");
    }

    public void initFrame () {

        this.setSize(1200,580);                         //设定好高宽
        this.setResizable(false);                                    //设置窗口大小不可变
        this.setLocationRelativeTo(null);                            //设置窗口初始居中
        this.setIconImage(ImageUtils.iconImg);                       //设置窗口图标
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         //添加窗口关闭
        this.setVisible(true);                                       //窗口可视化
        this.addMouse();                                            //添加鼠标监听事件
        this.addKey();                                              //添加键盘监听


        while (true) {
            if (flag == 0) {
                gameStart();
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
    @Override
    public void paint(Graphics g) {

        if (iBuffer == null) {
            //如果没有缓冲对象，则先创立一个缓冲对象
            iBuffer = createImage(this.getSize().width, this.getSize().height);
            gBuffer = iBuffer.getGraphics();
        }
        gBuffer.setColor(Color.white);//设置初始界面为白色
        //为了让界面看上去更好看，用一个线程休眠
        if (ObjUtils.count == 1) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
}
        if (flag == 0) {

            PaintUtils.paintBackground(gBuffer,ObjUtils.background, ObjUtils.background1);//绘制地图
            PaintUtils.paintPlayer(gBuffer, ObjUtils.usagi);//绘制游戏角色
            PaintUtils.paintEnemies(gBuffer);//绘制敌人
            PaintUtils.paintExplode(gBuffer);//绘制子弹
            PaintUtils.paintGameObj(gBuffer);//绘制道具

            //如果得分大于500 那么boss降临
            if (ObjUtils.gameScore >= 0) {
                ObjUtils.birdBoss.paintSelf(gBuffer);
            }

        } else if (flag == 1) {

            gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
            gBuffer.drawImage(ObjUtils.background.getImg(), ObjUtils.background.getX(), ObjUtils.background.getY(),null);
            gBuffer.drawImage(ObjUtils.background1.getImg(), ObjUtils.background1.getX(), ObjUtils.background1.getY(),null);

            gBuffer.drawImage(ImageUtils.coverImg,445,110,null);
            gBuffer.drawImage(ImageUtils.titleImg,435,390,null);
        } else if (flag == 2) {
            System.out.println("游戏失败");
        }
        g.drawImage(iBuffer, 0, 0, this);


        ObjUtils.count++;//每重绘一次，就自增
        if (ObjUtils.count == Integer.MAX_VALUE) {
            ObjUtils.count = 0;
        }

    }
    //绘制窗口，使用双缓存技术
    private void checkGame() {
        for (int i = 0; i < ObjUtils.enemies.size(); i++) {
            if (ObjUtils.enemies.get(i).getRectangle().intersects(ObjUtils.usagi.getRectangle())) {
//                flag = 2;//修改为游戏失败状态
//                System.out.println("游戏失败");
            }
        }
    }

    private void gameStart() {
        ObjUtils.addExplode();
        ObjUtils.addEnemy();
        ObjUtils.removeObj();
    }
    //游戏开始


    private void addKey() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int speed = 10;
                if (e.getKeyChar() == ' ') {
                    flag = flag ^ 1;
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
//                System.out.println(e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    // 向左边移动，但是你得要判断角色是否超出边界
                    if (ObjUtils.usagi.getX() >= 0) {
                        ObjUtils.usagi.setX(ObjUtils.usagi.getX() - speed);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (ObjUtils.usagi.getX() < 1080) {
                        ObjUtils.usagi.setX(ObjUtils.usagi.getX() + speed);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
//                    System.out.println(1);
                    if (ObjUtils.usagi.getY() >= 10) {
                        ObjUtils.usagi.setY(ObjUtils.usagi.getY() - speed);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (ObjUtils.usagi.getY() <= 470) {
                        ObjUtils.usagi.setY(ObjUtils.usagi.getY() + speed);
                    }
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
                //个人觉得跟着鼠标移动不太好，改为键盘移动
                int x = e.getX();
                int y = e.getY();
                if (x >= ObjUtils.usagi.getWeight() /2  && x <= 1200 - ObjUtils.usagi.getWeight() / 2 && flag == 0) {
                    ObjUtils.usagi.setX(e.getX() - ObjUtils.usagi.getWeight() / 2);

                }
                if (y >= ObjUtils.usagi.getHeight() && flag == 0) {
                    ObjUtils.usagi.setY(e.getY() - ObjUtils.usagi.getHeight());
                }
            }
        });
    }
    // 键鼠监听事件
}
