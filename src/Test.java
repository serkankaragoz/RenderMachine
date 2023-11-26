import java.io.IOException;

public class Test {
    public static void main(String[] args) {



        RenderFrame renderFrame;
        try {
            renderFrame = new RenderFrame();
            renderFrame.rotateTest1();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
