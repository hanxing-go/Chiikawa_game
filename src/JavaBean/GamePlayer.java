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
    //4. 子弹伤害
    private int damage;

    public GamePlayer(int x, int y, Image img, int height, int weight, int speed, int hp, int explodenum, int skillcount, int damage) {
        super(x, y, img, height, weight, speed);
        this.hp = hp;
        this.explodenum = explodenum;
        this.skillcount = skillcount;
        this.damage = damage;
    }


    /**
     * 获取
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * 设置
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * 获取
     * @return explodenum
     */
    public int getExplodenum() {
        return explodenum;
    }

    /**
     * 设置
     * @param explodenum
     */
    public void setExplodenum(int explodenum) {
        this.explodenum = explodenum;
    }

    /**
     * 获取
     * @return skillcount
     */
    public int getSkillcount() {
        return skillcount;
    }

    /**
     * 设置
     * @param skillcount
     */
    public void setSkillcount(int skillcount) {
        this.skillcount = skillcount;
    }

    /**
     * 获取
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * 设置
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String toString() {
        return "GamePlayer{hp = " + hp + ", explodenum = " + explodenum + ", skillcount = " + skillcount + ", damage = " + damage + "}";
    }
}
