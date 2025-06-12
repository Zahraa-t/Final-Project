import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background {
    private BufferedImage back;

    public Background () {
        try {
            back = ImageIO.read(new File("src/newStore.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public BufferedImage setBack(int num) {
        if (num == 1) {
            try {
                return ImageIO.read(new File("src/newStore.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (num == 2) {
            try {
                return ImageIO.read(new File("src/produceBackground.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (num == 3) {
            try {
                return ImageIO.read(new File("src/snackIsle.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (num == 4) {
            try {
                return ImageIO.read(new File("src/freezerBackground.png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (num == 5) {
            try {
                return ImageIO.read(new File("src/ending.jpg"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (num == 6) {
            try {
                return ImageIO.read(new File("src/startingTitleCover.jpg"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public BufferedImage getBack() {
        return back;
    }

}
