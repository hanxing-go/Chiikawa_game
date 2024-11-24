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


    public ImageUtils() {
        iconImg = Toolkit.getDefaultToolkit().getImage(".\\img\\icon.png");
        backgroundImg = Toolkit.getDefaultToolkit().getImage(".\\img\\backimg.png");
        backgroundImg2 = Toolkit.getDefaultToolkit().getImage(".\\img\\backimg2.png");
        coverImg = Toolkit.getDefaultToolkit().getImage(".\\img\\coverimg.png");
        titleImg = Toolkit.getDefaultToolkit().getImage(".\\img\\Title1.png");

        Usagi = Toolkit.getDefaultToolkit().getImage(".\\img\\Usaqi.png");
    }


    public ImageUtils(Image iconImg, Image backgroundImg, Image coverImg) {
        this.iconImg = iconImg;
        this.backgroundImg = backgroundImg;
        this.coverImg = coverImg;
    }

    public ImageUtils(Image iconImg, Image backgroundImg, Image coverImg, Image titleImg) {
        this.iconImg = iconImg;
        this.backgroundImg = backgroundImg;
        this.coverImg = coverImg;
        this.titleImg = titleImg;
    }

    public ImageUtils(Image iconImg, Image backgroundImg, Image coverImg, Image titleImg, Image Usagi) {
        this.iconImg = iconImg;
        this.backgroundImg = backgroundImg;
        this.coverImg = coverImg;
        this.titleImg = titleImg;
        this.Usagi = Usagi;
    }

    public ImageUtils(Image iconImg, Image backgroundImg, Image backgroundImg2, Image coverImg, Image titleImg, Image Usagi) {
        this.iconImg = iconImg;
        this.backgroundImg = backgroundImg;
        this.backgroundImg2 = backgroundImg2;
        this.coverImg = coverImg;
        this.titleImg = titleImg;
        this.Usagi = Usagi;
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

    public String toString() {
        return "ImageUtils{iconImg = " + iconImg + ", backgroundImg = " + backgroundImg + ", coverImg = " + coverImg + "}";
    }
}
