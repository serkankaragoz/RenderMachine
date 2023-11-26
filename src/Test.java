import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            new RenderFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
