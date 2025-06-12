import javax.swing.JFrame;


public class ZFrame {
    public ZFrame() {
        JFrame frame = new JFrame("Grocery Shopping");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(610,400);
        frame.setLocationRelativeTo(null);

        DisplayPanel panel = new DisplayPanel();
        frame.add(panel);
        frame.setVisible(true);
    }

}
