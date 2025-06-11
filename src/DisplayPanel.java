import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    private BufferedImage background;
    private Player player;
    private boolean[] pressedKeys;
    private Timer timer;
    private String area;
    private Background b;
    private Furniture shelves;
    private Furniture shelves2;
    private Furniture fruits;
    private Furniture fruits2;
    private Furniture fridge;
    private BufferedImage register;
    private BufferedImage sideShelf;
    private BufferedImage sideShelf2;
    private BufferedImage books;
    private BufferedImage couch;
    private BufferedImage plant;
    private BufferedImage rug;
    private Enemy cloudHorizontal1S;
    private Enemy cloudHorizontal2S;
    private Enemy cloudHorizontal3S;
    private Enemy cloud1S;
    private Enemy cloud2S;
    private Enemy cloud3S;
    private int cloud1XS;
    private int cloud2XS;
    private int cloud3XS;
    private int cloudYS;
    private int cloudY2S;
    private int cloudY3S;
    private int map;
    private BufferedImage cover;
    private Furniture cabbage;
    private Furniture bellPepper;
    private Furniture grapes;
    private Furniture beef;
    private Furniture strawberryIceCream;
    private Furniture eggs;
    private Furniture milk;
    private Furniture hotCocoa;
    private Furniture strawberryJam;
    private Furniture potatoChips;
    private Portal teleport1;
    private Boolean[] isCollected;


    public DisplayPanel() {
        b = new Background();
        b.setBack(1);
        background = b.getBack();
        player = new Player();
        pressedKeys = new boolean[128];
        timer = new Timer(10, this);
        timer.start();
        area = "Store";
        map = 0;
        cloudHorizontal1S = new Enemy(3,90,90);
        cloudHorizontal2S = new Enemy(5,220,180);
        cloudHorizontal3S = new Enemy(4,150,300);
        cloud1S = new Enemy(3,40, 230);
        cloud2S = new Enemy(4,220, 0);
        cloud3S = new Enemy(5,320, 0);
        cloud1XS = cloudHorizontal1S.getxCoord();
        cloud2XS = cloudHorizontal2S.getxCoord();
        cloud3XS = cloudHorizontal3S.getxCoord();
        cloudYS = cloud1S.getyCoord();
        cloudY2S = cloud2S.getyCoord();
        cloudY3S = cloud3S.getyCoord();

        teleport1 = new Portal(550,170);

        shelves = new Furniture(0,45,1);
        shelves2 = new Furniture(145, shelves.getyCoord(),1);
        fruits = new Furniture(20, 300, 2);
        fruits2 = new Furniture(100,300,2);
        fridge = new Furniture(430,60,3);
        cabbage = new Furniture(40,80,4);
        bellPepper = new Furniture(50,80,5);
        grapes = new Furniture(60,80,6);
        beef = new Furniture(70,80,7);
        strawberryIceCream = new Furniture(80,80,8);
        eggs = new Furniture(90,80,9);
        milk = new Furniture(100,80,10);
        hotCocoa = new Furniture(110,80,11);
        strawberryJam = new Furniture(120,80,12);
        potatoChips = new Furniture(130,80,13);

        player.formList();
        isCollected = new Boolean[10];
        for (int i = 0; i < 10; i++) {
            isCollected[i] = false;
        }

        try {
            cover = ImageIO.read(new File("src/StartCover.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            register = ImageIO.read(new File("src/register1.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            sideShelf = ImageIO.read(new File("src/sideShelf1.png"));
            sideShelf2 = ImageIO.read(new File("src/sideShelf1.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            books = ImageIO.read(new File("src/books.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            couch = ImageIO.read(new File("src/couch.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            plant = ImageIO.read(new File("src/plant.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            rug = ImageIO.read(new File("src/rug.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g.setColor(Color.black);

        if (map == 0) {
            g.drawImage(shelves.getImage(), shelves.getxCoord(), shelves.getyCoord(), null);
            g.drawImage(shelves2.getImage(), 145, shelves2.getyCoord(), null);
            g.drawImage(shelves2.getImage(), 274, shelves2.getyCoord(), null);
            g.drawImage(fruits.getImage(), 20, 300, null);
            g.drawImage(fruits2.getImage(), 100, 300, null);
            g.drawImage(fridge.getImage(), 430, 60, null);
            g.drawImage(fridge.getImage(), 485, 60, null);
            g.drawImage(plant, 555,110, null);
            g.drawImage(couch, 545,145,null);
            g.drawImage(register, 520, 200, null);
            g.drawImage(rug, 420,260,null);
            g.drawImage(books, 390, 305, null);
            g.drawImage(sideShelf, 125, 60, null);
            g.drawImage(sideShelf2, 125, 110, null);

            g.drawString(area,540,50);

            if (player.playerRect().intersects(fruits2.box())) {
                background = b.setBack(2);
                player.teleported(true);
                map = 2;
            }
            if (player.playerRect().intersects(shelves.box())) {
                background = b.setBack(3);
                player.teleported(true);
                area = "Snacks";
                //fix sign placement ^
                map = 1;
                player.spawnPoint(490,170);
                player.respawn();
            }
            if (player.playerRect().intersects(fridge.box())) {
                background = b.setBack(4);
                player.teleported(true);
                map = 3;
            }
        } else if (map == 1){
            g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            g.setColor(Color.white);
            g.drawString(area,520,50);
            g.drawImage(cloudHorizontal1S.getPlayerImage(), cloud1XS, cloudHorizontal1S.getyCoord(), null);
            g.drawImage(cloudHorizontal2S.getPlayerImage(), cloud2XS, cloudHorizontal2S.getyCoord(), null);
            g.drawImage(cloudHorizontal3S.getPlayerImage(), cloud3XS, cloudHorizontal3S.getyCoord(), null);
            g.drawImage(cloud1S.getPlayerImage(), cloud1S.getxCoord(), cloudYS, null);
            g.drawImage(cloud2S.getPlayerImage(), cloud2S.getxCoord(), cloudY2S, null);
            g.drawImage(cloud3S.getPlayerImage(), cloud3S.getxCoord(), cloudY3S, null);
            g.drawImage(teleport1.getPortalImage(), teleport1.getxCoord(), teleport1.getyCoord(),null );
            if (!isCollected[9]) {
                g.drawImage(hotCocoa.getImage(), 50,70,null);
            }
            g.drawImage(strawberryJam.getImage(), 230,270,null);
            g.drawImage(potatoChips.getImage(), 350,50,null);

//            g.drawRect(cloud2XS, cloudHorizontal2S.getyCoord(),cloudHorizontal2S.getPlayerImage().getWidth(), cloudHorizontal2S.getPlayerImage().getHeight());
//            g.drawRect(cloud3XS, cloudHorizontal3S.getyCoord(),cloudHorizontal3S.getPlayerImage().getWidth(), cloudHorizontal3S.getPlayerImage().getHeight());
            g.drawRect(cloudHorizontal3S.getxCoord(), cloudY3S,cloudHorizontal3S.getPlayerImage().getWidth(), cloudHorizontal3S.getPlayerImage().getHeight());
            g.drawRect(cloudHorizontal2S.getxCoord(), cloudY2S,cloudHorizontal2S.getPlayerImage().getWidth(), cloudHorizontal2S.getPlayerImage().getHeight());
            g.drawRect(cloudHorizontal1S.getxCoord(), cloudYS,cloudHorizontal1S.getPlayerImage().getWidth(), cloudHorizontal1S.getPlayerImage().getHeight());


            if (player.playerRect().intersects(cloudHorizontal1S.enemyRect(cloud1XS))) {
                    player.respawn();
            }
            if (player.playerRect().intersects(cloudHorizontal2S.enemyRect(cloud1XS))) {
                player.respawn();
            }
            if (player.playerRect().intersects(cloud1S.enemyRect2(cloudYS))) {
                player.respawn();
            }
            if (player.playerRect().intersects(cloud2S.enemyRect2(cloudY2S))) {
                player.respawn();
            }
            if (player.playerRect().intersects(cloud3S.enemyRect2(cloudY2S))) {
                player.respawn();
            }
            if (player.playerRect().intersects(teleport1.PortalRect())) {
                map = 0;
                background = b.setBack(1);
                player.spawnPoint(300,220);
                player.respawn();
            }
            if (player.playerRect().intersects(strawberryJam.box())) {
                isCollected[9] = true;
            }

        } else if (map == 2) {
//            g.drawImage(cabbage.getImage(), 40,80,null);
//            g.drawImage(bellPepper.getImage(), 140,80,null);
//            g.drawImage(grapes.getImage(), 240,80,null);

        } else if (map == 3) {
//            g.drawImage(beef.getImage(), 70,80,null);
//            g.drawImage(strawberryIceCream.getImage(), 170,80,null);
//            g.drawImage(eggs.getImage(), 270,80,null);
//            g.drawImage(milk.getImage(), 370,80,null);

        }

        g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);
        if (pressedKeys[81]) {
            g.drawImage(cover,380,90,null);
            g.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 13));
            g.setColor(Color.white);
            int a = 0;
            for (String s: player.getGroceries()) {
                g.drawString(s, 400,110+a);
                a+=20;
            }
        }

        if (pressedKeys[65]) {
            player.setIdle(false);
            player.faceLeft();
            player.moveLeft();

        }
        if (pressedKeys[68]) {
            player.setIdle(false);
            player.faceRight();
            player.moveRight();
        }
        if (pressedKeys[87]) {
            player.setIdle(false);
            player.moveUp();
        }
        if (pressedKeys[83]) {
            player.setIdle(false);
            player.moveDown();
        }
        if (!pressedKeys[65] && !pressedKeys[68] && !pressedKeys[87] && !pressedKeys[83] && !pressedKeys[32]) {
            player.setIdle(true);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == timer) {
            cloud1XS++;
            cloud2XS++;
            cloud3XS++;
            if (cloud1XS > 520) {
                cloud1XS = 0;
            }
            if (cloud3XS > 520) {
                cloud3XS = 0;
            }
            if (cloud2XS > 300) {
                cloud2XS = 0;
            }
            cloudYS++;
            cloudY2S++;
            cloudY3S++;
            if (cloudYS > 390) {
                cloudYS = 0;
            }
            if (cloudY2S > 390) {
                cloudY2S = 0;
            }
            if (cloudY3S > 390) {
                cloudY3S = 0;
            }

        }
        repaint();
    }

    // KeyListener interface methods
    @Override
    public void keyTyped(KeyEvent e) { } // unimplemented



    @Override
    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
        // A = 65, D = 68, S = 83, W = 87, left = 37, up = 38, right = 39, down = 40, space = 32, enter = 10
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;

    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
