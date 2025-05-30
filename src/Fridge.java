import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fridge {
    private int xCoord;
    private int yCoord;
    private BufferedImage image;

    public Fridge(int x, int y) {
        xCoord = x;
        yCoord = y;

    }

    public BufferedImage getImage() {
        return image;
    }

    public Rectangle fridgeRect() {
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
}
