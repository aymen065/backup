import java.awt.*;
import java.util.Random;

public class cb {
    private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final Random rand = new Random();

    public static void main(String[] args) {
        while (true) {
            try {
                Robot robot = new Robot();
                int newX = rand.nextInt(SCREEN_WIDTH); // Génère une nouvelle position X aléatoire
                int newY = rand.nextInt(SCREEN_HEIGHT); // Génère une nouvelle position Y aléatoire
                robot.mouseMove(newX, newY); // Déplace la souris à la nouvelle position aléatoire
                Thread.sleep(1000); // Attend une seconde avant de déplacer à nouveau la souris
            } catch (AWTException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

