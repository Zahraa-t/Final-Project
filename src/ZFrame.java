import javax.swing.JFrame;


public class ZFrame {
    public ZFrame() {
        JFrame frame = new JFrame("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);

        DisplayPanel panel = new DisplayPanel();
        frame.add(panel);
        frame.setVisible(true);
    }

}
