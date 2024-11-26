package Utils;

import JavaBean.Background;
import JavaBean.GamePlayer;

import java.awt.*;

public class PaintUtils {
    public static void paintPlayer(Graphics g, GamePlayer player) {
        player.paintSelf(g);
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
}
