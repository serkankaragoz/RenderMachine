import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class RenderFrame extends JFrame {

    private AtomicBoolean paused = new AtomicBoolean(false);

    private double screenLocation = 3.0;
    private double eyeLocation = 10.0;

    private RenderPanel panel;

    public void setBoundsAtMiddle(JFrame frame, int width, int height){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = size.width;
        int screenHeight = size.height;
        frame.setBounds((screenWidth-width)/2, (screenHeight-height)/2, width, height);
    }

    public RenderFrame() throws IOException {
        panel = new RenderPanel();
        this.setLayout(null);
        this.add(panel);

        panel.setBounds(panel.PIXEL_SIZE,2*panel.PIXEL_SIZE, panel.SCREEN_SIZE,panel.SCREEN_SIZE);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setResizable(false);
        // The 17 and 40 numbers to make the minesweeper field symmetric since

        int width = panel.SCREEN_SIZE + 2 * panel.PIXEL_SIZE + 17;
        int height = panel.SCREEN_SIZE + 3 * panel.PIXEL_SIZE + 40;

        setBoundsAtMiddle(this, width, height);

        System.out.println("Width: " + this.getBounds() + " Height: " + this.getAlignmentY());
        this.setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("Key pressed: " + e.getKeyChar());
                if(e.getKeyChar() == 'S' || e.getKeyChar() == 's'){
                    eyeLocation++;
                    screenLocation++;
                }
                else if(e.getKeyChar() == 'W' || e.getKeyChar() == 'w'){
                    eyeLocation--;
                    screenLocation--;
                }
                else if(e.getKeyChar() == '\u001B'){
                    paused.set(!paused.get());
                }
            }
        });

    }


    public void rotateTest1(){

        Point[] vertexList = {
                new Point(2, 2, 2),
                new Point(-2, 2, 2),
                new Point(-2, -2, 2),
                new Point(2, -2, 2),
                new Point(2, 2, -2),
                new Point(-2, 2, -2),
                new Point(-2, -2, -2),
                new Point(2, -2, -2),
        };

        Pair<Double, Double>[] edgeList = new Pair[]{
                new Pair<>(0.0, 1.0),
                new Pair<>(1.0, 2.0),
                new Pair<>(2.0, 3.0),
                new Pair<>(3.0, 0.0),
                new Pair<>(0.0, 4.0),
                new Pair<>(1.0, 5.0),
                new Pair<>(2.0, 6.0),
                new Pair<>(3.0, 7.0),
                new Pair<>(4.0, 5.0),
                new Pair<>(5.0, 6.0),
                new Pair<>(6.0, 7.0),
                new Pair<>(7.0, 4.0),
        };


        while(true){
            for (double angle = 0.0; /*angle <= 4 * Math.PI + 0.05*/; angle += 0.05){
                panel.resetScreen();
                for (Point value : vertexList) {
                    Pair<Double, Double> point = Main.projection(value, screenLocation, eyeLocation);
                    point = new Pair<>(point.getKey(), point.getValue());
                    panel.setPixelStatusCoordinate(true, (int) (point.getKey() * 10), (int) (point.getValue() * 10));
                }
                Main.rotateAllOnZAxis(vertexList, 0.05);


                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                while (paused.get()){
                }
            }
        }


    }



}
