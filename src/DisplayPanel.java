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
    private BufferedImage store;
    private BufferedImage shelves;
    private Player player;
    private boolean[] pressedKeys;
    private Timer timer;
    private String area;


    public DisplayPanel() {
        try {
            store = ImageIO.read(new File("src/store.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            shelves = ImageIO.read(new File("src/shelves.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        player = new Player();
        pressedKeys = new boolean[128];
        timer = new Timer(20, this);
        timer.start();
        //In the top left
        area = "Store Front";


        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(store, 0,0, null);
        g.drawImage(shelves, 30,45,null);
        g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);

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
        if (!pressedKeys[65] && !pressedKeys[68] && !pressedKeys[87] && !pressedKeys[83]) {
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
