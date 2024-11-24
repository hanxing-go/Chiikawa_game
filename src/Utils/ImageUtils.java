package Utils;

import java.awt.*;

public class ImageUtils {

    private static Image iconImg;
    private static Image backgroundImg;
    private static Image coverImg;


    public ImageUtils() {
        iconImg = Toolkit.getDefaultToolkit().getImage(".\\img\\icon.png");
        backgroundImg = Toolkit.getDefaultToolkit().getImage(".\\img\\coverimage.png");
        coverImg = Toolkit.getDefaultToolkit().getImage(".\\img\\coverimg.png");
    }

    public ImageUtils(Image iconImg, Image backgroundImg, Image coverImg) {
        this.iconImg = iconImg;
        this.backgroundImg = backgroundImg;
        this.coverImg = coverImg;
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

    public String toString() {
        return "ImageUtils{iconImg = " + iconImg + ", backgroundImg = " + backgroundImg + ", coverImg = " + coverImg + "}";
    }
}
