import JavaBean.Background;
import JavaBean.Explode;
import JavaBean.Usagi;
import Utils.ImageUtils;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;
import java.util.LinkedList;

public class GameFrame extends JFrame{


    private int flag = 1;
    private ImageUtils imageUtils = new ImageUtils();
    private Background background = new Background(0,0, imageUtils.getBackgroundImg2(),0,0,5);
    private Background background1 = new Background(2400,0, imageUtils.getBackgroundImg2(),1,1,5);
    private Usagi usagi = new Usagi(100,250,imageUtils.getUsagi(),
            120,114,0);
    private Explode explode = new Explode(usagi.getX() + usagi.getWeight() + 5, usagi.getY() + usagi.getWeight() - 45,imageUtils.getExplode(),
            10,10, 20);

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
    // 这里要实现双缓冲技术
    @Override
    public void paint(Graphics g) {

        if (iBuffer == null) {
            //如果没有缓冲对象，则先创立一个缓冲对象
            iBuffer = createImage(this.getSize().width, this.getSize().height);
            gBuffer = iBuffer.getGraphics();
        }

        if (flag == 0) {

            background.paintSelf(gBuffer);
            background1.paintSelf(gBuffer);
            usagi.paintSelf(gBuffer);
            explode.paintSelf(gBuffer);

        } else if (flag == 1) {

            gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
            gBuffer.drawImage(background.getImg(), background.getX(), background.getY(),null);
            gBuffer.drawImage(background1.getImg(), background1.getX(), background1.getY(),null);
            gBuffer.drawImage(imageUtils.getCoverImg(),445,110,null);
            gBuffer.drawImage(imageUtils.getTitleImg(),435,390,null);
        }
        g.drawImage(iBuffer, 0, 0, this);
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
