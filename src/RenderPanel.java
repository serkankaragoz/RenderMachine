import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;

public class RenderPanel extends JPanel {
    public final int PIXEL_SIZE;
    public final int HALF_SCREEN_PIXEL_AMOUNT;
    public final int SCREEN_PIXEL_AMOUNT;

    public final int SCREEN_SIZE;

    //private final Image blackPixel;

    //private final Image whitePixel;

    private boolean[][] screenArray;

    private JButton[][] pseudoPixels;

    private MouseAdapter squareListener = new MouseAdapter(){};

    public RenderPanel() throws IOException {
        this(32, 10);
    }

    public RenderPanel(int pixelSize, int halfPixelRowAmount) throws IOException {

        PIXEL_SIZE = pixelSize;
        HALF_SCREEN_PIXEL_AMOUNT = halfPixelRowAmount;
        SCREEN_PIXEL_AMOUNT = 2 * HALF_SCREEN_PIXEL_AMOUNT + 1;


        SCREEN_SIZE = PIXEL_SIZE * SCREEN_PIXEL_AMOUNT;
        screenArray = new boolean[SCREEN_PIXEL_AMOUNT][SCREEN_PIXEL_AMOUNT];
        pseudoPixels = new JButton[SCREEN_PIXEL_AMOUNT][SCREEN_PIXEL_AMOUNT];

        //blackPixel = ImageIO.read(new File("assets/black.png")).getScaledInstance(PIXEL_SIZE, PIXEL_SIZE, Image.SCALE_SMOOTH);
        //whitePixel = ImageIO.read(new File("assets/white.png")).getScaledInstance(PIXEL_SIZE, PIXEL_SIZE, Image.SCALE_SMOOTH);


        setLayout(new GridLayout(SCREEN_PIXEL_AMOUNT, SCREEN_PIXEL_AMOUNT));

        System.out.println("p.SCREEN_PIXEL_AMOUNT: " + SCREEN_PIXEL_AMOUNT);


        for(int i = 0; i < SCREEN_PIXEL_AMOUNT * SCREEN_PIXEL_AMOUNT;i++){

            //JButton b = new JButton(new ImageIcon(blackPixel));
            JButton b = new JButton();
            b.setBackground(Color.BLACK);
            b.setEnabled(false);

            add(pseudoPixels[i / SCREEN_PIXEL_AMOUNT][i % SCREEN_PIXEL_AMOUNT] = b);
        }

        //setBackground(Color.GREEN);

    }
}
