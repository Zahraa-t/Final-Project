import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DisplayPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    private boolean done;
    private BufferedImage background;
    private JButton button;
    private boolean showButton;
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
    private BufferedImage pointers;
    private BufferedImage trophy;
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
    private Enemy cloud1P;
    private int cloud1XP;
    private Enemy cloud2P;
    private int cloud2XP;
    private Enemy cloud1F;
    private int cloud1YF;
    private Enemy cloud2F;
    private int cloud2YF;
    private Enemy cloud3F;
    private int cloud3YF;
    private Enemy cloud4F;
    private int cloud4YF;
    private int map;
    private BufferedImage cover;
    private GroceryItem cabbage;
    private GroceryItem bellPepper;
    private GroceryItem grapes;
    private GroceryItem beef;
    private GroceryItem strawberryIceCream;
    private GroceryItem eggs;
    private GroceryItem milk;
    private GroceryItem hotCocoa;
    private GroceryItem strawberryJam;
    private GroceryItem potatoChips;
    private ArrayList<GroceryItem> items;
    private Portal teleport1;
    private Portal teleport2;
    private Portal teleport3;

    public DisplayPanel() {
        done = false;
        b = new Background();
        background = b.getBack();
        player = new Player();
        pressedKeys = new boolean[128];
        timer = new Timer(10, this);
        timer.start();
        area = "Store";
        map = 9;
        showButton = true;
        cloudHorizontal1S = new Enemy(3,90,90);
        cloudHorizontal2S = new Enemy(5,220,180);
        cloudHorizontal3S = new Enemy(4,150,300);
        cloud1XS = cloudHorizontal1S.getxCoord();
        cloud2XS = cloudHorizontal2S.getxCoord();
        cloud3XS = cloudHorizontal3S.getxCoord();
        cloud1S = new Enemy(3,40, 230);
        cloud2S = new Enemy(4,220, 0);
        cloud3S = new Enemy(5,320, 0);
        cloudYS = cloud1S.getyCoord();
        cloudY2S = cloud2S.getyCoord();
        cloudY3S = cloud3S.getyCoord();
        teleport1 = new Portal(550,300);

        cloud1P = new Enemy(5,20,60);
        cloud1XP = cloud1P.getxCoord();
        cloud2P = new Enemy(4,220,240);
        cloud2XP = cloud1P.getxCoord();
        teleport2 = new Portal(30,250);

        cloud1F = new Enemy(3, 20,170);
        cloud1YF = cloud1F.getyCoord();;
        cloud2F = new Enemy(4, 140,200);
        cloud2YF = cloud2F.getyCoord();
        cloud3F = new Enemy(5, 240,140);
        cloud3YF = cloud3F.getyCoord();;
        cloud4F = new Enemy(5, 370,40);
        cloud4YF = cloud4F.getyCoord();
        teleport3 = new Portal(550,320);

        shelves = new Furniture(0,45,1);
        shelves2 = new Furniture(145, shelves.getyCoord(),1);
        fruits = new Furniture(20, 300, 2);
        fruits2 = new Furniture(100,300,2);
        fridge = new Furniture(430,60,3);

        cabbage = new GroceryItem(1,false,540,50);
        bellPepper = new GroceryItem(2,false,50,50);
        grapes = new GroceryItem(3,false,540,320);
        beef = new GroceryItem(4,false,70,150);
        strawberryIceCream = new GroceryItem(5,false,500,250);
        eggs = new GroceryItem(6,false,300,20);
        milk = new GroceryItem(7,false,380,340);
        hotCocoa = new GroceryItem(8,false,50,80);
        strawberryJam = new GroceryItem(9,false,290,20);
        potatoChips = new GroceryItem(10,false,150,260);

        player.formList();
        items = new ArrayList<>(Arrays.asList(cabbage, bellPepper,grapes,beef,strawberryIceCream,eggs,milk,hotCocoa,strawberryJam,potatoChips));

        if (showButton) {
            button = new JButton("Start");
            button.addActionListener(this);
            add(button);
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
        try {
            pointers = ImageIO.read(new File("src/arrow.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            trophy = ImageIO.read(new File("src/trophy.png"));
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
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g.setColor(Color.black);

        if (!done) {
            g.drawImage(background, 0, 0, null);
            if (showButton) {
                background = b.setBack(6);
                button.setLocation(260,300);
                g.drawString("After a long day of fighting dragons, ", 30,40);
                g.drawString("knights also have to go... ", 30,80);
                g.setFont(new Font("Times New Roman", Font.BOLD, 30));
                g.drawString("\uD83C\uDD76\uD83C\uDD81\uD83C\uDD7E\uD83C\uDD72\uD83C\uDD74\uD83C\uDD81\uD83C\uDD88 \uD83C\uDD82\uD83C\uDD77\uD83C\uDD7E\uD83C\uDD7F\uD83C\uDD7F\uD83C\uDD78\uD83C\uDD7D\uD83C\uDD76", 80,150);
                g.drawString("\uD83D\uDED2", 260,256);
            } else {
                remove(button);
            }

            if (map == 0) {
                g.drawImage(shelves.getImage(), shelves.getxCoord(), shelves.getyCoord(), null);
                g.drawImage(shelves2.getImage(), 145, shelves2.getyCoord(), null);
                g.drawImage(shelves2.getImage(), 274, shelves2.getyCoord(), null);
                g.drawImage(pointers, 10,80,null);
                g.drawImage(pointers, 80,220,null);
                g.drawImage(fruits.getImage(), 20, 300, null);
                g.drawImage(fruits2.getImage(), 100, 300, null);
                g.drawImage(fridge.getImage(), 430, 60, null);
                g.drawImage(fridge.getImage(), 485, 60, null);
                g.drawImage(pointers, 405,80,null);
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
                    map = 2;
                    player.teleported(true);
                    area = "\"Produce\"";
                    player.spawnPoint(70,300);
                    player.respawn();
                }
                if (player.playerRect().intersects(shelves.box())) {
                    background = b.setBack(3);
                    map = 1;
                    player.teleported(true);
                    area = "\"Snacks\"";
                    player.spawnPoint(500,190);
                    player.respawn();
                }
                if (player.playerRect().intersects(fridge.box())) {
                    background = b.setBack(4);
                    map = 3;
                    player.teleported(true);
                    area = "\"Freezer\"";
                    player.spawnPoint(480,100);
                    player.respawn();
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
                g.drawImage(teleport1.getPortalImage(), teleport1.getxCoord(), teleport1.getyCoord(),null);

                if (!hotCocoa.isCollected()) {
                    g.drawImage(hotCocoa.getImage(), hotCocoa.getxCoord(), hotCocoa.getyCoord(),null);
                }
                if (!strawberryJam.isCollected()) {
                    g.drawImage(strawberryJam.getImage(), strawberryJam.getxCoord(), strawberryJam.getyCoord(),null);
                }
                if (!potatoChips.isCollected()) {
                    g.drawImage(potatoChips.getImage(), potatoChips.getxCoord(), potatoChips.getyCoord(),null);
                }
                if (player.playerRect().intersects(cloudHorizontal1S.enemyRect(cloud1XS))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(cloudHorizontal2S.enemyRect(cloud2XS))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(cloudHorizontal3S.enemyRect(cloud3XS))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(cloud1S.enemyRect2(cloudYS))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(cloud2S.enemyRect2(cloudY2S))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(cloud3S.enemyRect2(cloudY3S))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(teleport1.PortalRect())) {
                    map = 0;
                    background = b.setBack(1);
                    player.spawnPoint(300,220);
                    player.respawn();
                    area = "Store";
                }
                if (player.playerRect().intersects(hotCocoa.box())) {
                    hotCocoa.setCollected(true);
                }
                if (player.playerRect().intersects(strawberryJam.box())) {
                    strawberryJam.setCollected(true);
                }
                if (player.playerRect().intersects(potatoChips.box())) {
                    potatoChips.setCollected(true);
                }
            } else if (map == 2) {
                g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                g.setColor(Color.white);
                g.drawString(area,510,50);
                g.drawRect(145,300, 340,130);
                g.drawRect(0,100, 100,130);
                g.drawRect(510,100, 100,130);
                g.drawRect(160,0, 300,130);

                g.drawImage(teleport2.getPortalImage(), teleport2.getxCoord(), teleport2.getyCoord(), null);
                g.drawImage(cloud1P.getPlayerImage(), cloud1XP,cloud1P.getyCoord(),null);
                g.drawImage(cloud2P.getPlayerImage(), cloud2XP, cloud2P.getyCoord(),null);
                if (!cabbage.isCollected()) {
                    g.drawImage(cabbage.getImage(), cabbage.getxCoord(), cabbage.getyCoord(),null);
                }
                if (!bellPepper.isCollected()) {
                    g.drawImage(bellPepper.getImage(), bellPepper.getxCoord(), bellPepper.getyCoord(), null);
                }
                if (!grapes.isCollected()) {
                    g.drawImage(grapes.getImage(), grapes.getxCoord(),grapes.getyCoord(),null);
                }

                if (player.playerRect().intersects(cabbage.box())) {
                    cabbage.setCollected(true);
                }
                if (player.playerRect().intersects(bellPepper.box())) {
                    bellPepper.setCollected(true);
                }
                if (player.playerRect().intersects(grapes.box())) {
                    grapes.setCollected(true);
                }
                if (player.playerRect().intersects(teleport2.PortalRect())) {
                    map = 0;
                    background = b.setBack(1);
                    player.spawnPoint(300,220);
                    player.respawn();
                    area = "Store";
                }
                if (player.playerRect().intersects(cloud1P.enemyRect(cloud1XP))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(cloud2P.enemyRect(cloud2XP))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(new Rectangle(145,300, 340,130)) || player.playerRect().intersects(new Rectangle(0,100, 100,130))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(new Rectangle(510,100, 100,130)) || player.playerRect().intersects(new Rectangle(160,0, 300,130))) {
                    player.respawn();
                }

            } else if (map == 3) {
                g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                g.setColor(Color.white);
                g.drawString(area,520,50);
                g.drawImage(teleport3.getPortalImage(), teleport3.getxCoord(), teleport3.getyCoord(), null);
                g.drawImage(cloud1F.getPlayerImage(),cloud1F.getxCoord(),cloud1YF,null);
                g.drawImage(cloud2F.getPlayerImage(),cloud2F.getxCoord(),cloud2YF,null);
                g.drawImage(cloud3F.getPlayerImage(),cloud3F.getxCoord(),cloud3YF,null);
                g.drawImage(cloud4F.getPlayerImage(),cloud4F.getxCoord(),cloud4YF,null);
                g.drawRect(420,100,30,200);
                g.drawRect(150,100,30,200);

                if (!beef.isCollected()) {
                    g.drawImage(beef.getImage(), beef.getxCoord(), beef.getyCoord(), null);
                }
                if (!strawberryIceCream.isCollected()) {
                    g.drawImage(strawberryIceCream.getImage(), strawberryIceCream.getxCoord(),strawberryIceCream.getyCoord(),null);
                }
                if (!eggs.isCollected()) {
                    g.drawImage(eggs.getImage(), eggs.getxCoord(), eggs.getyCoord(), null);
                }
                if (!milk.isCollected()) {
                    g.drawImage(milk.getImage(), milk.getxCoord(), milk.getyCoord(), null);
                }

                if (player.playerRect().intersects(beef.box())) {
                    beef.setCollected(true);
                }
                if (player.playerRect().intersects(strawberryIceCream.box())) {
                    strawberryIceCream.setCollected(true);
                }
                if (player.playerRect().intersects(milk.box())) {
                    milk.setCollected(true);
                }
                if (player.playerRect().intersects(eggs.box())) {
                    eggs.setCollected(true);
                }
                if (player.playerRect().intersects(cloud1F.enemyRect2(cloud1YF)) || player.playerRect().intersects(cloud2F.enemyRect2(cloud2YF))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(cloud3F.enemyRect2(cloud3YF)) || player.playerRect().intersects(cloud4F.enemyRect2(cloud4YF))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(new Rectangle(420,100,30,200)) || player.playerRect().intersects(new Rectangle(150,100,30,200))) {
                    player.respawn();
                }
                if (player.playerRect().intersects(teleport3.PortalRect())) {
                    map = 0;
                    background = b.setBack(1);
                    player.spawnPoint(300,220);
                    player.respawn();
                    area = "Store";
                }
            }

            g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);
            if (pressedKeys[81]) {
                g.drawImage(cover,380,90,null);
                g.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 12));
                g.setColor(Color.white);
                int a = 0;
                for (String s: player.getGroceries()) {
                    g.drawString(s, 400,110+a);
                    a+=15;
                }
            }

            if (!showButton) {
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
            done = true;
            for (GroceryItem item : items) {
                if (!item.isCollected()) {
                    done = false;
                }
            }
        } else {
            background = b.setBack(5);
            g.drawImage(background, 0, 0, null);
            g.setColor(Color.yellow);
            g.setFont(new Font("Times New Roman", Font.BOLD, 30));
            g.drawString("You're done shopping", 170,130);
            g.setFont(new Font("Times New Roman", Font.BOLD, 30));
            g.drawString("YOU WIN", 250,160);
            g.drawImage(trophy, 220,0,null);
            g.drawImage(trophy, -120,0,null);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == button) {
            background = b.setBack(1);
            map = 0;
            showButton = false;
        }
        if (o == timer) {
            cloud1XS+=2;
            cloud2XS+=2;
            cloud3XS+=2;
            if (cloud1XS > 520) {
                cloud1XS = 0;
            }
            if (cloud3XS > 520) {
                cloud3XS = 0;
            }
            if (cloud2XS > 300) {
                cloud2XS = 0;
            }
            cloudYS+=2;
            cloudY2S+=2;
            cloudY3S+=2;
            if (cloudYS > 390) {
                cloudYS = 0;
            }
            if (cloudY2S > 390) {
                cloudY2S = 0;
            }
            if (cloudY3S > 390) {
                cloudY3S = 0;
            }

            cloud1XP+=2;
            if (cloud1XP > 520) {
                cloud1XP = 0;
            }
            cloud2XP+=2;
            if (cloud2XP > 520) {
                cloud2XP = 0;
            }

            cloud1YF+=4;
            if (cloud1YF > 520) {
                cloud1YF = 0;
            }
            cloud2YF+=2;
            if (cloud2YF > 520) {
                cloud2YF = 0;
            }
            cloud3YF+=2;
            if (cloud3YF > 520) {
                cloud3YF = 0;
            }
            cloud4YF+=2;
            if (cloud4YF > 520) {
                cloud4YF = 0;
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
