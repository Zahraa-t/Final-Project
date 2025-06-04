import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Enemy {
    private final int MOVE_AMT = 3;
    private BufferedImage image;
    private int xCoord;
    private int yCoord;

    public Enemy() {
        xCoord = 100;
        yCoord = 100;
        try {
            image = ImageIO.read(new File("src/boxCat.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public BufferedImage getPlayerImage() {
        return image;
    }

    public Rectangle enemyRect(int x) {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(x, yCoord, imageWidth, imageHeight);
        return rect;
    }
}
