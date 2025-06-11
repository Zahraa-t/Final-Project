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

    public Enemy(int op,int x,int y) {
        xCoord = x;
        yCoord = y;
        if (op == 1) {
            try {
                image = ImageIO.read(new File("src/boxCat.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (op == 2){
            try {
                image = ImageIO.read(new File("src/boxCatBIG2.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (op == 3){
            try {
                image = ImageIO.read(new File("src/cloud1.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (op == 4){
            try {
                image = ImageIO.read(new File("src/cloud2.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else if (op == 5){
            try {
                image = ImageIO.read(new File("src/cloud3.png"));
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

    public BufferedImage getPlayerImage() {
        return image;
    }

    public Rectangle enemyRect(int theX) {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(theX, yCoord, imageWidth, imageHeight);
        return rect;
    }
    public Rectangle enemyRect2(int theY) {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, theY, imageWidth, imageHeight);
        return rect;
    }
}
