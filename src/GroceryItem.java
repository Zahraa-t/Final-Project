import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GroceryItem {
    private BufferedImage image;
    private boolean isCollected;
    private int xCoord;
    private int yCoord;

    public GroceryItem(int identify, boolean isCollected, int x , int y) {
        xCoord = x;
        yCoord = y;
        if (identify == 1) {
            try {
                image = ImageIO.read(new File("src/cabbage_p.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 2) {
            try {
                image = ImageIO.read(new File("src/bell_pepper_p.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 3) {
            try {
                image = ImageIO.read(new File("src/Grapes.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 4) {
            try {
                image = ImageIO.read(new File("src/beef.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 5) {
            try {
                image = ImageIO.read(new File("src/strawberryIceCream.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 6) {
            try {
                image = ImageIO.read(new File("src/eggCarton.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 7) {
            try {
                image = ImageIO.read(new File("src/milk_pack.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 8) {
            try {
                image = ImageIO.read(new File("src/hotCocoa.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 9) {
            try {
                image = ImageIO.read(new File("src/jamStrawberry.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 10) {
            try {
                image = ImageIO.read(new File("src/potatoChips.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
       this.isCollected = isCollected;
    }

    public BufferedImage getImage() {
        return image;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public Rectangle box() {
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
}
