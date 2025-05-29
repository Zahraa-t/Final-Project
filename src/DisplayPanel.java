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

public class DisplayPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    private BufferedImage background;
    private Player player;
    private Shelf shelves;
    private Fridge fridge;
    private boolean[] pressedKeys;
    private Timer timer;
    private String area;
    private Background b;


    public DisplayPanel() {
        b = new Background();
        b.setBack(1);
        background = b.getBack();
        player = new Player();
        pressedKeys = new boolean[128];
        timer = new Timer(60, this);
        timer.start();
        area = "Store";
        shelves = new Shelf(30,45);
        fridge = new Fridge(180,90);

        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0,0, null);
        g.drawImage(shelves.getImage(), 30,45,null);
        g.drawImage(fridge.getImage(), 180,90,null);
        g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);
        g.setFont(new Font("Times New Roman", Font.BOLD, 25));
        g.drawString(area,540,50);

        player.setJump(false);

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
        if (pressedKeys[32]) {
            player.setJump(true);
            int up = 5;
            while (up >= 0) {
                player.moveUp();
                up--;
            }
        }
        if (!pressedKeys[65] && !pressedKeys[68] && !pressedKeys[87] && !pressedKeys[83] && !pressedKeys[32]) {
            player.setIdle(true);
        }

        if (player.playerRect().intersects(shelves.shelfRect())) {
            b.setBack(2);
            background = b.getBack();
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
