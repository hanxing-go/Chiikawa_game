package Utils;

import java.awt.*;
import java.util.Timer;

public class ImageUtils {

    private static Image iconImg;
    private static Image backgroundImg;
    private static Image backgroundImg2;
    private static Image coverImg;
    private static Image titleImg;
    private static Image Usagi;
    private static Image explode;
    private static Image enemy;
    private static Image uprightWorm;
    private static Image CreepWorm;
    private static Image bigWorm;
    private static Image birdBoss;


    public ImageUtils() {
        iconImg = Toolkit.getDefaultToolkit().getImage(".\\img\\icon.png");
        backgroundImg = Toolkit.getDefaultToolkit().getImage(".\\img\\backimg.png");
        backgroundImg2 = Toolkit.getDefaultToolkit().getImage(".\\img\\backimg2.png");
        coverImg = Toolkit.getDefaultToolkit().getImage(".\\img\\coverimg.png");
        titleImg = Toolkit.getDefaultToolkit().getImage(".\\img\\Title1.png");

        Usagi = Toolkit.getDefaultToolkit().getImage(".\\img\\Usaqi.png");
        explode = Toolkit.getDefaultToolkit().getImage(".\\img\\explode.png");
        enemy = Toolkit.getDefaultToolkit().getImage(".\\img\\enemy.png");

        uprightWorm = Toolkit.getDefaultToolkit().getImage(".\\img\\uprightWorm.png");
        CreepWorm = Toolkit.getDefaultToolkit().getImage(".\\img\\creepworm.png");
        bigWorm = Toolkit.getDefaultToolkit().getImage(".\\img\\bigworm.png");

        birdBoss = Toolkit.getDefaultToolkit().getImage(".\\img\\bossbird.png");
    }

    public ImageUtils(Image iconImg, Image backgroundImg, Image backgroundImg2, Image coverImg, Image titleImg, Image Usagi, Image explode, Image enemy, Image uprightWorm, Image CreepWorm, Image bigWorm, Image birdBoss) {
        this.iconImg = iconImg;
        this.backgroundImg = backgroundImg;
        this.backgroundImg2 = backgroundImg2;
        this.coverImg = coverImg;
        this.titleImg = titleImg;
        this.Usagi = Usagi;
        this.explode = explode;
        this.enemy = enemy;
        this.uprightWorm = uprightWorm;
        this.CreepWorm = CreepWorm;
        this.bigWorm = bigWorm;
        this.birdBoss = birdBoss;
    }


    /**
     * 获取
     * @return iconImg
     */
    public static Image getIconImg() {
        return iconImg;
    }

    /**
     * 设置
     * @param iconImg
     */
    public static void setIconImg(Image iconImg) {
        ImageUtils.iconImg = iconImg;
    }

    /**
     * 获取
     * @return backgroundImg
     */
    public static Image getBackgroundImg() {
        return backgroundImg;
    }

    /**
     * 设置
     * @param backgroundImg
     */
    public static void setBackgroundImg(Image backgroundImg) {
        ImageUtils.backgroundImg = backgroundImg;
    }

    /**
     * 获取
     * @return coverImg
     */
    public static Image getCoverImg() {
        return coverImg;
    }

    /**
     * 设置
     * @param coverImg
     */
    public static void setCoverImg(Image coverImg) {
        ImageUtils.coverImg = coverImg;
    }

    /**
     * 获取
     * @return titleImg
     */
    public static Image getTitleImg() {
        return titleImg;
    }

    /**
     * 设置
     * @param titleImg
     */
    public static void setTitleImg(Image titleImg) {
        ImageUtils.titleImg = titleImg;
    }

    /**
     * 获取
     * @return Usagi
     */
    public static Image getUsagi() {
        return Usagi;
    }

    /**
     * 设置
     * @param Usagi
     */
    public static void setUsagi(Image Usagi) {
        ImageUtils.Usagi = Usagi;
    }

    /**
     * 获取
     * @return backgroundImg2
     */
    public static Image getBackgroundImg2() {
        return backgroundImg2;
    }

    /**
     * 设置
     * @param backgroundImg2
     */
    public static void setBackgroundImg2(Image backgroundImg2) {
        ImageUtils.backgroundImg2 = backgroundImg2;
    }

    /**
     * 获取
     * @return explode
     */
    public static Image getExplode() {
        return explode;
    }

    /**
     * 设置
     * @param explode
     */
    public static void setExplode(Image explode) {
        ImageUtils.explode = explode;
    }

    /**
     * 获取
     * @return Enemy
     */
    public static Image getEnemy() {
        return enemy;
    }

    /**
     * 设置
     * @param Enemy
     */
    public static void setEnemy(Image Enemy) {
        ImageUtils.enemy = Enemy;
    }

    /**
     * 获取
     * @return uprightWorm
     */
    public static Image getUprightWorm() {
        return uprightWorm;
    }

    /**
     * 设置
     * @param uprightWorm
     */
    public static void setUprightWorm(Image uprightWorm) {
        ImageUtils.uprightWorm = uprightWorm;
    }

    /**
     * 获取
     * @return CreepWorm
     */
    public static Image getCreepWorm() {
        return CreepWorm;
    }

    /**
     * 设置
     * @param CreepWorm
     */
    public static void setCreepWorm(Image CreepWorm) {
        ImageUtils.CreepWorm = CreepWorm;
    }

    /**
     * 获取
     * @return bigWorm
     */
    public static Image getBigWorm() {
        return bigWorm;
    }

    /**
     * 设置
     * @param bigWorm
     */
    public static void setBigWorm(Image bigWorm) {
        ImageUtils.bigWorm = bigWorm;
    }

    /**
     * 获取
     * @return birdBoss
     */
    public static Image getBirdBoss() {
        return birdBoss;
    }

    /**
     * 设置
     * @param birdBoss
     */
    public static void setBirdBoss(Image birdBoss) {
        ImageUtils.birdBoss = birdBoss;
    }

    /**
     * 获取
     * @return worm
     */

    public String toString() {
        return "ImageUtils{iconImg = " + iconImg + ", backgroundImg = " + backgroundImg + ", coverImg = " + coverImg + "}";
    }
}
