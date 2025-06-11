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
        } else if (identify == 4) {
            try {
                image = ImageIO.read(new File("src/cabbage_p.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 5) {
            try {
                image = ImageIO.read(new File("src/bell_pepper_p.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 6) {
            try {
                image = ImageIO.read(new File("src/Grapes.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 7) {
            try {
                image = ImageIO.read(new File("src/beef.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 8) {
            try {
                image = ImageIO.read(new File("src/strawberryIceCream.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 9) {
            try {
                image = ImageIO.read(new File("src/eggCarton.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 10) {
            try {
                image = ImageIO.read(new File("src/milk_pack.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 11) {
            try {
                image = ImageIO.read(new File("src/hotCocoa.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 12) {
            try {
                image = ImageIO.read(new File("src/jamStrawberry.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (identify == 13) {
            try {
                image = ImageIO.read(new File("src/potatoChips.png"));
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
