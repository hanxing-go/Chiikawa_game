package Utils;

import JavaBean.Background;
import JavaBean.Player.GamePlayer;

import java.awt.*;

public class PaintUtils {
    public static void paintAll(Graphics g, Background b1, Background b2) {
        paintBackground(g, b1, b2);
        paintBackground(g,ObjUtils.background, ObjUtils.background1);//绘制地图
        paintPlayer(g);//绘制游戏角色
        paintEnemies(g);//绘制敌人
        paintExplode(g);//绘制子弹
        paintGameProp(g);//绘制道具
    }

    public static void paintPlayer(Graphics g) {
//        player.paintSelf(g);

        //如果这个时候有协助角色加入，也要画出来
        for (int i = 0; i < ObjUtils.gamePlayers.size(); i++) {
            ObjUtils.gamePlayers.get(i).paintSelf(g);
        }
    }
    public static void paintExplode(Graphics g) {
        for (int i = 0; i < ObjUtils.explodeList.size(); i++) {
            ObjUtils.explodeList.get(i).paintSelf(g);
        }
    }

    public static void paintEnemies(Graphics g) {
        for (int i = 0; i < ObjUtils.enemies.size(); i++) {
            ObjUtils.enemies.get(i).paintSelf(g);
        }
    }

    public static void paintBackground(Graphics g, Background background, Background background1) {
        background.paintSelf(g);
        background1.paintSelf(g);
    }

    public static void paintGameProp(Graphics g) {
        for (int i = 0; i < ObjUtils.gameProps.size(); i++) {
            ObjUtils.gameProps.get(i).paintSelf(g);
        }
    }
}
