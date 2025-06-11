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
    private Furniture register;
    private Furniture sideShelf;
    private Furniture sideShelf2;
    private Furniture books;
    private Furniture couch;
    private Furniture plant;
    private Enemy cat1;
    private Enemy cat2;
    private Enemy cloud1;
    private int cat1X;
    private int cat2X;
    private int cloud1Y;
    private int map;
    private BufferedImage cover;
    private BufferedImage cabbage;
    private BufferedImage bellPepper;
    private BufferedImage grapes;
    private BufferedImage beef;
    private BufferedImage strawberryIceCream;
    private BufferedImage eggs;
    private BufferedImage milk;
    private BufferedImage hotCocoa;
    private BufferedImage strawberryJam;
    private BufferedImage potatoChips;


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
        cat1 = new Enemy(1,100,100);
        cat2 = new Enemy(1,100,200);
        cloud1 = new Enemy(2,100, 0);
        cat1X = cat1.getxCoord();
        cat2X = cat2.getxCoord();
        cloud1Y = cat1.getyCoord();

        shelves = new Furniture(0,45,1);
        shelves2 = new Furniture(145, shelves.getyCoord(),1);
        fruits = new Furniture(20, 300, 2);
        fruits2 = new Furniture(100,300,2);
        fridge = new Furniture(430,60,3);
        register = new Furniture(400, 300, 4);
        sideShelf = new Furniture(155, 70,5);
        sideShelf2 = new Furniture(155, 120,5);
        books = new Furniture(390, 305,6);
        couch = new Furniture(545,145,7);
        plant = new Furniture(545,130,8);

        player.formList();
        try {
            cabbage = ImageIO.read(new File("src/cabbage_p.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            bellPepper = ImageIO.read(new File("src/bell_pepper_p.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            grapes = ImageIO.read(new File("src/Grapes.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            beef = ImageIO.read(new File("src/beef.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            cover = ImageIO.read(new File("src/StartCover.png"));
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
            g.drawImage(plant.getImage(), 555,110, null);
            g.drawImage(couch.getImage(), 545,145,null);
            g.drawImage(register.getImage(), 520, 200, null);
            g.drawImage(books.getImage(), 390, 305, null);
            g.drawImage(sideShelf.getImage(), 125, 60, null);
            g.drawImage(sideShelf2.getImage(), 125, 110, null);

            g.drawString(area,540,50);

            if (player.playerRect().intersects(shelves.box())) {
                b.setBack(3);
                background = b.getBack();
                player.teleported(true);
                area = "Produce";
                //fix sign placement ^
                map = 1;
                player.spawnPoint(500,170);
            }
            if (player.playerRect().intersects(fruits2.box())) {
                b.setBack(2);
                background = b.getBack();
                player.teleported(true);
                map = 2;
            }
            if (player.playerRect().intersects(fridge.box())) {
                b.setBack(4);
                background = b.getBack();
                player.teleported(true);
                map = 3;
            }
        } else if (map == 1){
            g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            g.setColor(Color.white);
            g.drawString(area,520,50);
            g.drawImage(cat1.getPlayerImage(), cat1X, cat1.getyCoord(), null);
            g.drawImage(cat2.getPlayerImage(), cat2X, cat2.getyCoord(), null);
            g.drawImage(cloud1.getPlayerImage(), cloud1.getxCoord(), cloud1Y, null);
            if (player.playerRect().intersects(cat1.enemyRect(cat1X))) {
                    player.respawn();
            }
            if (player.playerRect().intersects(cat2.enemyRect(cat1X))) {
                player.respawn();
            }
            if (player.playerRect().intersects(cloud1.enemyRect2(cloud1Y))) {
                player.respawn();
            }

        }

        g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);
        if (pressedKeys[76]) {
            g.drawImage(cover,380,90,null);
            g.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 13));
            g.setColor(Color.white);
            int a = 0;
            for (String s: player.getGroceries()) {
                g.drawString(s, 400,110+a);
                a+=20;
            }
            //when collected, they should be crossed out
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
            cat1X++;
            cat2X++;
            if (cat1X > 580) {
                cat1X = 0;
                cat2X = 0;
            }
            cloud1Y++;
            if (cloud1Y > 300) {
                cloud1Y = 0;
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
