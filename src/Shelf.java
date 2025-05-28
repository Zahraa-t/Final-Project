import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Shelf {
    private int xCoord;
    private int yCoord;
    private BufferedImage image;

    public Shelf(int x, int y) {
        xCoord = x;
        yCoord = y;
        try {
            image = ImageIO.read(new File("src/shelves.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    public int getxCoord() {
//        return xCoord;
//    }
//
//    public int getyCoord() {
//        return yCoord;
//    }

    public BufferedImage getImage() {
        return image;
    }

    public Rectangle shelfRect() {
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
}
