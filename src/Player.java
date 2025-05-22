import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
    private final int MOVE_AMT = 3;
    private BufferedImage right;
    private boolean facingRight;
    private boolean isIdle;
    private int xCoord;
    private int yCoord;
    private Animation walking;
    private Animation idling;

    public Player() {
        facingRight = true;
        isIdle = false;
        xCoord = 100;
        yCoord = 300;

//        ArrayList<BufferedImage> images = new ArrayList<>();
//        for (int i = 1; i < 9; i++) {
////            String filename = "src/tile00" + i + ".png";
//            try {
//                images.add(ImageIO.read(new File(filename)));
//            }
//            catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        walking = new Animation(images,80);
//
//
//        ArrayList<BufferedImage> idle = new ArrayList<>();
//        for (int i = 1; i < 7; i++) {
////            String filename = "src/idle00" + i + ".png";
//            try {
//                idle.add(ImageIO.read(new File(filename)));
//            }
//            catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        idling = new Animation(idle,80);

    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void faceRight() {
        facingRight = true;
    }

    public void faceLeft() {
        facingRight = false;
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 347) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 347) {
            yCoord += MOVE_AMT;
        }
    }


    public BufferedImage getPlayerImage() {
//        if (facingRight) {
//            return right;
//        } else {
//            return left;
//        }

        return null;
    }




    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }


}
