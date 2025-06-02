import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Future;

public class Player {
    private final int MOVE_AMT = 6;
    private BufferedImage image;
    private boolean facingRight;
    private boolean isIdle;
    private boolean isJump;
    private int xCoord;
    private int yCoord;
    private Animation walking;
    private Animation idling;
    private boolean isTeleported;
    //^ will use to change movements to 2D screen

    public Player() {
        facingRight = true;
        isIdle = false;
        xCoord = 310;
        yCoord = 320;
        isTeleported = false;

        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            String filename = "src/walk00" + i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        walking = new Animation(images,80);


        ArrayList<BufferedImage> idle = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            String filename = "src/tile00" + i + "k.png";
            try {
                idle.add(ImageIO.read(new File(filename)));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        idling = new Animation(idle,80);
    }

    public int getxCoord() {
        if (facingRight) {
            return xCoord;
        } else {
            return (xCoord + (getPlayerImage().getWidth()));
        }
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getHeight() {
        return getPlayerImage().getHeight();
    }

    public int getWidth() {
        if (facingRight) {
            return getPlayerImage().getWidth();
        } else {
            return getPlayerImage().getWidth() * -1;
        }
    }

    public void faceRight() {
        facingRight = true;
    }

    public void faceLeft() {
        facingRight = false;
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 580) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 96) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (((xCoord + MOVE_AMT <= 370 && xCoord + MOVE_AMT >= 160) && yCoord + MOVE_AMT <= 340) || (xCoord + MOVE_AMT >= 370 && yCoord + MOVE_AMT <= 260) || (xCoord + MOVE_AMT <= 160 && yCoord + MOVE_AMT <= 270)) {
            yCoord += MOVE_AMT;
        }
    }

    public BufferedImage getPlayerImage() {
        if (isIdle) {
            return idling.getActiveFrame();  // updated
        } else {
            return walking.getActiveFrame();  // updated
        }
    }

    public void setIdle(boolean idle) {
        isIdle = idle;
    }

    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }


    public boolean isTeleported() {
        return isTeleported;
    }

    public void teleported() {
        isTeleported = !isTeleported;
    }
}
