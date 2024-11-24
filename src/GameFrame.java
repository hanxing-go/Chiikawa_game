import JavaBean.Background;
import JavaBean.Usagi;
import Utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.ImageGraphicAttribute;

public class GameFrame extends JFrame{


    private int flag = 1;
    private ImageUtils imageUtils = new ImageUtils();
    private Background background = new Background(0,0, imageUtils.getBackgroundImg2(),0,0,5);
    private Background background1 = new Background(2400,0, imageUtils.getBackgroundImg2(),1,1,5);
    private Usagi usagi = new Usagi(100,250,imageUtils.getUsagi(),
            120,114,0);
    public GameFrame () {
        super("Chiikawa");
    }



    public void initFrame () {
        //创建一个窗口，并且设置名字
        this.setSize(1200,580);
        //设定好高宽
        this.setResizable(false);

        //设置窗口大小不可变
        this.setLocationRelativeTo(null);
        //设置窗口初始居中
        Image icon = imageUtils.getIconImg();
        this.setIconImage(icon);

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


    @Override
    public void paint(Graphics g) {
        super.paint(g);


        if (flag == 0) {
//            this.setSize(1203,600);
//            g.drawImage(imageUtils.getBackgroundImg(), 0, 0,null);
//            Usagi usagi = new Usagi(imageUtils.getUsagi());
//            g.drawImage(usagi.getImg(),250,250,null);
            background.paintSelf(g);
            background1.paintSelf(g);
            usagi.paintSelf(g);
        } else if (flag == 1) {
//            System.out.println(1);
//            this.setSize(1203,600);
            g.drawImage(background.getImg(), background.getX(), background.getY(),null);
            g.drawImage(imageUtils.getCoverImg(),445,110,null);
            g.drawImage(imageUtils.getTitleImg(),435,390,null);
        }
    }




    private void addKey() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == ' ') {
                    flag = flag ^ 1;
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
                if (x >= usagi.getWeight() /2  && x <= 1200 - usagi.getWeight() / 2) {
                    usagi.setX(e.getX() - usagi.getWeight() / 2);

                }
                if (y >= usagi.getHeight()) {
                    usagi.setY(e.getY() - usagi.getHeight());
                    System.out.println(y);
                }
            }
        });
    }
}
