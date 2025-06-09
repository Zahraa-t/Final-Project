import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Future;

public class Player {
    private final int MOVE_AMT = 4;
    private BufferedImage image;
    private boolean facingRight;
    private boolean isIdle;
    private boolean isJump;
    private int xCoord;
    private int yCoord;
    private Animation walking;
    private Animation idling;
    private boolean isTeleported;
    private ArrayList<String> groceries;
    private ArrayList<String> options;
    private int xStarting;
    private int yStarting;


    public Player() {
        facingRight = true;
        isIdle = false;
        xCoord = 310;
        yCoord = 220;
        isTeleported = false;
        groceries = new ArrayList<>();
        options = new ArrayList<>();
        xStarting = 310;
        yStarting = 320;

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

    public void spawnPoint(int x, int y) {
        xStarting = x;
        yStarting = y;
    }

    public void respawn() {
        xCoord = xStarting;
        yCoord = yStarting;
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
        if (!isTeleported) {
            if ((xCoord + MOVE_AMT <= 100 && yCoord + MOVE_AMT <= 300) || (xCoord + MOVE_AMT > 100 && xCoord + MOVE_AMT <= 140 && yCoord + MOVE_AMT >= 190) || (xCoord + MOVE_AMT > 140 && xCoord + MOVE_AMT <= 365) || (xCoord + MOVE_AMT > 365 && xCoord + MOVE_AMT <= 490 && yCoord + MOVE_AMT <= 285)) {
                //add a new boundary for a new x coord
                xCoord += MOVE_AMT;
            }

        } else if (xCoord + MOVE_AMT <= 550) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (!isTeleported) {
            if ((xCoord - MOVE_AMT >= 155 && xCoord - MOVE_AMT <= 500) || (xCoord - MOVE_AMT < 155 && xCoord - MOVE_AMT >= 100 && yCoord + MOVE_AMT >= 200 && yCoord + MOVE_AMT <= 280) || (xCoord - MOVE_AMT < 100 &&xCoord - MOVE_AMT > 0 )) {
                xCoord -= MOVE_AMT;
            }
        } else if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (!isTeleported) {
            if (((xCoord + MOVE_AMT >= 0 && xCoord + MOVE_AMT <= 115) && yCoord - MOVE_AMT >= 100) || (xCoord + MOVE_AMT >= 115 && xCoord + MOVE_AMT <= 145 && yCoord - MOVE_AMT >= 185) || (xCoord + MOVE_AMT >= 145 && yCoord - MOVE_AMT >= 110)) {
                //
                yCoord -= MOVE_AMT;
            }
        } else if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (!isTeleported) {
            if (((xCoord + MOVE_AMT <= 370 && xCoord + MOVE_AMT >= 160) && yCoord + MOVE_AMT <= 330) || (xCoord + MOVE_AMT >= 370 && xCoord + MOVE_AMT < 500 && yCoord + MOVE_AMT <= 260) || (xCoord + MOVE_AMT <= 160 && yCoord + MOVE_AMT <= 270) || (xCoord + MOVE_AMT > 490 && xCoord + MOVE_AMT < 570 && yCoord + MOVE_AMT <= 190)) {
                yCoord += MOVE_AMT;
            }
        } else if (yCoord <= 320) {
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

//    public boolean isTeleported() {
//        return isTeleported;
//    }

    public void teleported(boolean t) {
        isTeleported = t;
    }

    public void formList() {
        options.add("Bell Peppers");
        options.add("Cabbage");
        options.add("Grapes");
        options.add("Strawberry Ice Cream");
        options.add("Eggs");
        options.add("Milk");
        options.add("Hot Cocoa");
        options.add("Strawberry Jam");
        options.add("Potato Chips");

        for (int i = 0; i <= 6; i++) {
            int itemNum = (int) (Math.random() * options.size()) + 1;
            //check if it generates correctly
            groceries.add(options.get(itemNum));
            options.remove(itemNum);
        }
    }
}
