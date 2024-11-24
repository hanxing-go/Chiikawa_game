import Utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.ImageGraphicAttribute;

public class GameFrame extends JFrame{


    private int flag = 1;
    private ImageUtils imageUtils = null;

    public GameFrame () {
        super("Chiikawa");
        imageUtils = new ImageUtils();
    }



    public void initFrame () {
        //创建一个窗口，并且设置名字
        this.setSize(1200,596);
        //设定好高宽
//        this.setResizable(false);

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
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);


        if (flag == 0) {
            this.setSize(1203,600);
            g.drawImage(imageUtils.getBackgroundImg(), 0, 0,null);
//            g.drawImage(imageUtils.getCoverImg(),600,250,null);

            System.out.println(0);

        } else if (flag == 1) {
            System.out.println(1);
            this.setSize(1203,600);
            g.drawImage(imageUtils.getBackgroundImg(), 0, 0,null);
            g.drawImage(imageUtils.getCoverImg(),460,110,null);
            g.drawImage(imageUtils.getTitleImg(),450,390,null);
//            g.drawImage(imageUtils.getTitleImg1(),450,400,null);
        }
    }




    private void addKey() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == ' ') {
                    flag = flag ^ 1;
                    System.out.println(flag);
                    System.out.println("按下了");
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
                System.out.println("点击了");
                System.out.println(flag);
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
//                System.out.println(e.getX() + " " + e.getY());
            }
        });
    }
}
