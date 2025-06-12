import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Furniture {
    private int xCoord;
    private int yCoord;
    private BufferedImage image;

    public Furniture(int x, int y, int identify) {
        xCoord = x;
        yCoord = y;
        if (identify == 1) {
            try {
                image = ImageIO.read(new File("src/shelves.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 2) {
            try {
                image = ImageIO.read(new File("src/fruits1.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 3) {
            try {
                image = ImageIO.read(new File("src/fridge.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Rectangle box() {
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
}
