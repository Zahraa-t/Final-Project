import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class DisplayPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    private BufferedImage background;
    private Player player;
    private boolean[] pressedKeys;
    private Timer timer;
    private String area;
    private Background b;
    private Furniture shelves;
    private Furniture fruits;
    private Furniture fruits2;
    private Furniture fridge;
    private Furniture register;
    private Furniture sideShelf;
    private Furniture sideShelf2;
    private Furniture books;
//    private ArrayList<Rectangle> boxes;
//    private boolean canMove;

    public DisplayPanel() {
        b = new Background();
        b.setBack(1);
        background = b.getBack();
        player = new Player();
        pressedKeys = new boolean[128];
        timer = new Timer(20, this);
        timer.start();
        area = "Store";
        shelves = new Furniture(0,45,1);
        fruits = new Furniture(20, 300, 2);
        fruits2 = new Furniture(100,300,2);
        fridge = new Furniture(430,60,3);
        register = new Furniture(400, 300, 4);
        sideShelf = new Furniture(155, 70,5);
        sideShelf2 = new Furniture(155, 120,5);
        books = new Furniture(390, 305,6);
//        boxes = new ArrayList<>(Arrays.asList(shelves.box(), fruits.box(),fruits2.box(), fridge.box(), register.box(),sideShelf.box(), sideShelf2.box(),books.box()));
//        canMove = true;

        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);

        if (!player.isTeleported()) {
            g.drawImage(shelves.getImage(), shelves.getxCoord(), shelves.getyCoord(), null);
            g.drawImage(shelves.getImage(), 145, shelves.getyCoord(), null);
            g.drawImage(shelves.getImage(), 274, shelves.getyCoord(), null);
            g.drawImage(fruits.getImage(), 20, 300, null);
            g.drawImage(fruits2.getImage(), 100, 300, null);
            g.drawImage(fridge.getImage(), 430, 60, null);
            g.drawImage(fridge.getImage(), 485, 60, null);
            g.drawImage(register.getImage(), 520, 200, null);
            g.drawImage(books.getImage(), 390, 305, null);
            g.drawImage(sideShelf.getImage(), 125, 60, null);
            g.drawImage(sideShelf2.getImage(), 125, 110, null);
            //fix the rectangle boxes to match this^^^^^

            g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            g.drawString(area,540,50);

//            if (player.playerRect().intersects(shelves.box())) {
//                b.setBack(3);
//                background = b.getBack();
//                player.teleported(true);
//                area = "\"Produce\"";
//                //fix sign placement ^
//            }
//            if (player.playerRect().intersects(fruits2.box())) {
//                b.setBack(2);
//                background = b.getBack();
//                player.teleported(true);
//            }
//            if (player.playerRect().intersects(fridge.box())) {
//                b.setBack(4);
//                background = b.getBack();
//                player.teleported(true);
//            }
        } else {
            g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            g.drawString(area,540,50);
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
