import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RenderFrame extends JFrame {
    public void setBoundsAtMiddle(JFrame frame, int width, int height){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = size.width;
        int screenHeight = size.height;
        frame.setBounds((screenWidth-width)/2, (screenHeight-height)/2, width, height);
    }

    public RenderFrame() throws IOException {



        RenderPanel p = new RenderPanel();
        this.setLayout(null);
        this.add(p);

        p.setBounds(p.PIXEL_SIZE,2*p.PIXEL_SIZE, p.SCREEN_SIZE,p.SCREEN_SIZE);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.setResizable(false);
        // The 17 and 40 numbers to make the minesweeper field symmetric since


        int width = p.SCREEN_SIZE + 2 * p.PIXEL_SIZE + 17;
        int height = p.SCREEN_SIZE + 3 * p.PIXEL_SIZE + 40;

        setBoundsAtMiddle(this, width, height);

        System.out.println("Width: " + this.getBounds() + " Height: " + this.getAlignmentY());


        this.setVisible(true);
    }

}
