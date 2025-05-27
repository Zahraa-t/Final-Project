import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background {
    private BufferedImage back;

    public Background () {
        try {
            back = ImageIO.read(new File("src/store.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BufferedImage getBack() {
        return back;
    }

    public void setBack(int num) {
        if (num == 1) {
            try {
                back = ImageIO.read(new File("src/store.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (num == 2) {
            try {
                back = ImageIO.read(new File("src/produce.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (num == 3) {
            try {
                back = ImageIO.read(new File("src/snackIsle.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                back = ImageIO.read(new File("src/freezer.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
