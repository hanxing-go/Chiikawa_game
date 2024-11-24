import Utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.ImageGraphicAttribute;

public class GameFrame extends JFrame{


    private int flag = 0;
    private ImageUtils imageUtils = null;

    public GameFrame () {
        super("Chiikawa");
        imageUtils = new ImageUtils();

        //创建一个窗口，并且设置名字
        this.setSize(1200,596);
        //设定好高宽
        this.setResizable(false);
        //设置窗口大小不可变
        this.setLocationRelativeTo(null);
        //设置窗口初始居中
        Image icon = imageUtils.getIconImg();
        this.setIconImage(icon);
        //设置图标

//        ImageIcon backgroundImg = new ImageIcon(".\\img\\backgroundimg.png");
//        JLabel jlbackGroundImg = new JLabel(backgroundImg);
//        JPanel jbackGround = new JPanel();
//        jbackGround.setSize(1200,600);
//        jbackGround.add(jlbackGroundImg);
//        this.add(jbackGround);
        //设置窗口背景

//        ImageIcon coverImg = new ImageIcon(imageUtils.getCoverImgUrl());

        //设置游戏开始界面

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //添加窗口关闭
        this.setVisible(true);

        //添加鼠标监听事件
        this.addMouse();
        this.addKey();

        //设置游戏状态
        while (true) {
            if (flag == 0) {
//                System.out.println("启动");
            } else if (flag == 1) {
//                System.out.println("暂停");
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        Image img = Toolkit.getDefaultToolkit().getImage(imageUtils.getBackgroundImgUrl());
        System.out.println("绘制前");
        g.drawImage(imageUtils.getBackgroundImg(), 0, 0,null);
        System.out.println("绘制后");
        g.setColor(Color.black);
    }

//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//        System.out.println(1);
//        g.drawImage(ImageUtils.getBackgroundImg(),0,0, 1200, 600, null);
//        System.out.println(222);
//    }



    private void addKey() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == ' ') {
                    flag = flag ^ 1;
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
