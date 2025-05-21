import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Avatar {
    private final int MOVE_AMT = 3;
    private BufferedImage right;
    private BufferedImage left;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;

    public Player2() {
        facingRight = true;
        xCoord = 100;
        yCoord = 435;
        score = 0;
        try {
            left = ImageIO.read(new File("src/luigileft.png"));
            right = ImageIO.read(new File("src/luigiright.png"));
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

    public int getScore() {
        return score;
    }

    public void faceRight() {
        facingRight = true;
    }

    public void faceLeft() {
        facingRight = false;
    }

    public void moveRight() {
//        if (xCoord + MOVE_AMT <= 920) {
//            xCoord += MOVE_AMT;
//        }
    }

    public void moveLeft() {
//        if (xCoord - MOVE_AMT >= 0) {
//            xCoord -= MOVE_AMT;
//        }
    }

    public void moveUp() {
//        if (yCoord - MOVE_AMT >= 0) {
//            yCoord -= MOVE_AMT;
//        }
    }

    public void moveDown() {
//        if (yCoord + MOVE_AMT <= 435) {
//            yCoord += MOVE_AMT;
//        }
    }


    public BufferedImage getPlayerImage() {
//        if (facingRight) {
//            return right;
//        } else {
//            return left;
//        }
    }




    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }


}
