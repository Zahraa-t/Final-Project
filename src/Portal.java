import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Portal {
    private BufferedImage image;
    private int xCoord;
    private int yCoord;
    private Animation spin;


    public Portal(int x , int y) {
        xCoord = x;
        yCoord = y;
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            String filename = "src/teleport0" + i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        spin = new Animation(images, 80);
    }

    public BufferedImage getPortalImage() {
        return spin.getActiveFrame();  // updated
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public Rectangle PortalRect() {
        int imageHeight = getPortalImage().getHeight();
        int imageWidth = getPortalImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
}
