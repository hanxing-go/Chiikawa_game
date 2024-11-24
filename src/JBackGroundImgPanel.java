import javax.swing.*;
import java.awt.*;

public class JBackGroundImgPanel extends JPanel {
    private Image backgroundImg;
    public JBackGroundImgPanel(Image img) {
        this.backgroundImg = img;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(backgroundImg, 0, 0, getWidth)
    }
}
