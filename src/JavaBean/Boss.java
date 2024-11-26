package JavaBean;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Boss extends Enemy{
    //创建一个boss的攻击道具集合
    public List<GameProp> fightProp = new ArrayList<>();


    public Boss(int x, int y, Image img, int height, int weight, int speed) {
        super(x, y, img, height, weight, speed);
    }
}
