package JavaBean;

import java.awt.*;

public class GamePlayer extends GameObj{
    //相比GameObj应该多如下属性
    //1. HP
    private int hp;
    //2. 子弹数量
    private int explodenum;
    //3. 技能次数
    private int skillcount;

    public GamePlayer(int x, int y, Image img, int height, int weight, int speed, int hp, int explodenum, int skillcount) {
        super(x, y, img, height, weight, speed);
        this.hp = hp;
        this.explodenum = explodenum;
        this.skillcount = skillcount;
    }
}
