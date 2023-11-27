//import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.MouseAdapter;
//import java.io.File;
//import java.io.IOException;

public class RenderPanel extends JPanel {
    public final int PIXEL_SIZE;
    public final int HALF_SCREEN_PIXEL_AMOUNT;
    public final int SCREEN_PIXEL_AMOUNT;
    public final int SCREEN_SIZE;
    //private final boolean[][] screenArray;
    //private final Image blackPixel;
    //private final Image whitePixel;
    private final JButton[][] pseudoPixels;
    //private MouseAdapter squareListener = new MouseAdapter(){};

    public RenderPanel() //throws IOException
    {
        this(10, 45);
    }

    public RenderPanel(int pixelSize, int halfPixelRowAmount) //throws IOException
    {

        PIXEL_SIZE = pixelSize;
        HALF_SCREEN_PIXEL_AMOUNT = halfPixelRowAmount;
        SCREEN_PIXEL_AMOUNT = 2 * HALF_SCREEN_PIXEL_AMOUNT + 1;


        SCREEN_SIZE = PIXEL_SIZE * SCREEN_PIXEL_AMOUNT;
        //screenArray = new boolean[SCREEN_PIXEL_AMOUNT][SCREEN_PIXEL_AMOUNT];
        pseudoPixels = new JButton[SCREEN_PIXEL_AMOUNT][SCREEN_PIXEL_AMOUNT];



        // blackPixel = ImageIO.read(new File("assets/black.png")).getScaledInstance(PIXEL_SIZE, PIXEL_SIZE, Image.SCALE_SMOOTH);
        // whitePixel = ImageIO.read(new File("assets/white.png")).getScaledInstance(PIXEL_SIZE, PIXEL_SIZE, Image.SCALE_SMOOTH);


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


    public void resetScreen(){
        for (int i = 0; i < pseudoPixels.length; i++) {
            for (int j = 0; j < pseudoPixels[i].length; j++) {
                setPixelStatus(false, i, j);
            }
        }
    }

    private int yToArrayIndex(int y){
        return y + HALF_SCREEN_PIXEL_AMOUNT;
    }

    private int zToArrayIndex(int z){
        return HALF_SCREEN_PIXEL_AMOUNT - z;
    }


    private void setPixelStatus(boolean status, int i, int j){
        if((i < 0 || i >= pseudoPixels.length) || (j < 0 || j >= pseudoPixels[i].length)){
            return;
        }
        /*
        try{
            screenArray[i][j] = status;
        }catch (ArrayIndexOutOfBoundsException e){
            return;
        }
        */

        if(status){
            pseudoPixels[i][j].setBackground(Color.BLACK);
            return;
        }
        pseudoPixels[i][j].setBackground(Color.LIGHT_GRAY);

    }

    public void setPixelStatusCoordinate(boolean status, int y, int z){
        setPixelStatus(status, zToArrayIndex(z), yToArrayIndex(y));
    }

}
