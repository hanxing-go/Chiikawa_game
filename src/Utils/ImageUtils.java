package Utils;

public class ImageUtils {
    private static String iconUrl = ".\\img\\icon.png";
    private static String backgroundImgUrl = ".\\img\\backgroundimg.png";
    private static String coverImgUrl = ".\\img\\coverimg.png";


    public ImageUtils() {
    }

    public ImageUtils(String iconUrl, String backgroundImgUrl, String coverImgUrl) {
        this.iconUrl = iconUrl;
        this.backgroundImgUrl = backgroundImgUrl;
        this.coverImgUrl = coverImgUrl;
    }

    /**
     * 获取
     * @return iconUrl
     */
    public static String getIconUrl() {
        return iconUrl;
    }

    /**
     * 设置
     * @param iconUrl
     */
    public static void setIconUrl(String iconUrl) {
        ImageUtils.iconUrl = iconUrl;
    }

    /**
     * 获取
     * @return backgroundImgUrl
     */
    public static String getBackgroundImgUrl() {
        return backgroundImgUrl;
    }

    /**
     * 设置
     * @param backgroundImgUrl
     */
    public static void setBackgroundImgUrl(String backgroundImgUrl) {
        ImageUtils.backgroundImgUrl = backgroundImgUrl;
    }

    /**
     * 获取
     * @return coverImgUrl
     */
    public static String getCoverImgUrl() {
        return coverImgUrl;
    }

    /**
     * 设置
     * @param coverImgUrl
     */
    public static void setCoverImgUrl(String coverImgUrl) {
        ImageUtils.coverImgUrl = coverImgUrl;
    }

    public String toString() {
        return "ImageUtils{iconUrl = " + iconUrl + ", backgroundImgUrl = " + backgroundImgUrl + ", coverImgUrl = " + coverImgUrl + "}";
    }
}
