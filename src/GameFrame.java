import JavaBean.*;
import JavaBean.Player.GamePlayer;
import Utils.ImageUtils;
import Utils.ObjUtils;
import Utils.PaintUtils;
import Utils.SkillUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.util.*;
import java.util.List;


public class GameFrame extends JFrame{

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
        this.addMouse();                                             //添加鼠标监听事件
        this.addKey();                                               //添加键盘监听


        while (true) {
            if (ObjUtils.flag == 0) {
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
            gBuffer.setColor(Color.white);//设置初始界面为白色

        }
        //为了让界面看上去更好看，用一个线程休眠
        if (ObjUtils.count == 1) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
}
        if (ObjUtils.flag == 0) {// 游戏进行
            PaintUtils.paintAll(gBuffer, ObjUtils.background, ObjUtils.background1);
        } else if (ObjUtils.flag == 1) {//游戏还未开始
            gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
            gBuffer.drawImage(ObjUtils.background.getImg(), ObjUtils.background.getX(), ObjUtils.background.getY(),null);
            gBuffer.drawImage(ObjUtils.background1.getImg(), ObjUtils.background1.getX(), ObjUtils.background1.getY(),null);

            gBuffer.drawImage(ImageUtils.coverImg,445,110,null);
            gBuffer.drawImage(ImageUtils.titleImg,435,460,null);
        } else if (ObjUtils.flag == 2) {// 游戏失败

//            try {
//                Thread.sleep(800);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            newgame();
            gBuffer.drawImage(ImageUtils.lose,0,0,null);
            gBuffer.drawImage(ImageUtils.titleImg,435,460,null);

        } else if (ObjUtils.flag == 3) {//击败第一个boss

//            try {
//                Thread.sleep(800);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            continueGame();// 这里有清除所有敌人与子弹
            gBuffer.drawImage(ImageUtils.win,0,0,null);
            gBuffer.drawImage(ImageUtils.titleImg,435,460,null);

        } else if (ObjUtils.flag == 4) {//击败第二个boss
            gBuffer.drawImage(ImageUtils.win1, 0, 0, null);
            newgame();//重新开始游戏
        } else if (ObjUtils.flag == 5) {
            gBuffer.drawImage(ImageUtils.stopImg, 0, 0, null);
        }


        g.drawImage(iBuffer, 0, 0, this);

        ObjUtils.count++;//每重绘一次，就自增
        if (ObjUtils.count == Integer.MAX_VALUE) {
            ObjUtils.count = 0;
        }

    }
    //绘制窗口，使用双缓存技术



    private void gameStart() {

        ObjUtils.addObj();
        ObjUtils.removeObj();
        ObjUtils.checkGame();
    }
    //游戏开始
    private void continueGame() {
        ObjUtils.enemies.clear();
        ObjUtils.explodeList.clear();
    }

    private void newgame() {
        ObjUtils.removeAll();//清空所有
//        ObjUtils.flag = 2;
        ObjUtils.gameScore = 0;//分数要设置为0
        ObjUtils.numEnemy = 0;//怪物数量要设置为0
        ObjUtils.count = 0;//都设置为0;
        // 创建角色的标记要重新归0
        ObjUtils.flagjiy1 = 0;
        ObjUtils.flagjiy2 = 0;
        ObjUtils.flageight1 = 0;
        ObjUtils.flageight2 = 0;
        ObjUtils.flagusaqi1 = 0;
        ObjUtils.flagusaqi2 = 0;
        // boss要设置为0
        ObjUtils.flagBird = 0;
        ObjUtils.flagDragon = 0;
        ObjUtils.flagqimeila = 0;
    }


    private void addKey() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int speed = 10;
                if (e.getKeyChar() == ' ') {
                    if (ObjUtils.flag == 1) {// 如果游戏此时是还未开始，那么游戏开始
                        ObjUtils.flag = 0;
                    } else if (ObjUtils.flag == 2){//如果游戏失败，就回到开始界面
                        ObjUtils.flag = 1;
                    } else if (ObjUtils.flag == 5) {//如果游戏室暂停，则游戏继续
                      ObjUtils.flag = 0;
                    } else if (ObjUtils.flag == 4) {//打败了第二个boss，游戏结束
                        ObjUtils.flag = 1;
                    } else{
                        ObjUtils.flag = 5;//其他情况全都是变为暂停
                    }
                    repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
                if (e.getKeyChar() == 'h' || e.getKeyChar() == 'H') {
                    SkillUtils.redUsaqi();
                }

            }
        });
    }

    private void addMouse() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (ObjUtils.flag == 2) {//游戏失败回到开始界面
                    ObjUtils.flag = 1;
                } else if (ObjUtils.flag == 4){
                    //打败了第二个boss。游戏结束
                    ObjUtils.flag = 1;
                }else {
                    //其余情况全都是游戏继续
                    ObjUtils.flag = 0;
                }
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

                for (int i = 0; i < ObjUtils.gamePlayers.size(); i++) {
                    if (i == 0) {
                        if (x >= ObjUtils.gamePlayers.get(i).getWeight() /2
                                && x <= 1200 - ObjUtils.gamePlayers.get(i).getWeight() / 2 &&
                                ObjUtils.flag == 0) {
                            x = e.getX() - ObjUtils.gamePlayers.get(i).getWeight() / 2;
                            ObjUtils.gamePlayers.get(i).setX(x);
                        }
                        if (y >= ObjUtils.gamePlayers.get(i).getHeight() && ObjUtils.flag == 0) {
                            y = e.getY() - ObjUtils.gamePlayers.get(i).getHeight();
                            ObjUtils.gamePlayers.get(i).setY(y);
                        }
                    }

                    if (i == 1) {
                        x = ObjUtils.gamePlayers.get(0).getX();
                        y = ObjUtils.gamePlayers.get(0).getY();

                        ObjUtils.gamePlayers.get(1).setX(x - 60);
                        ObjUtils.gamePlayers.get(1).setY(y - 80);
                    }

                    if (i == 2) {
                        ObjUtils.gamePlayers.get(2).setX(x - 60);
                        ObjUtils.gamePlayers.get(2).setY(y + 80);
                    }
                }

            }
        });
    }
    // 键鼠监听事件
}
