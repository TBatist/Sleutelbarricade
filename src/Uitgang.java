import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Uitgang extends JComponent {
    private static int levelCompleted = 0;
    private BufferedImage imageUitgang;

    public Uitgang(){
        URL resource = getClass().getResource("trapdoor.png");
        try {
            imageUitgang = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setLevelCompleted(int nieuwLevelCompleted){
        levelCompleted = nieuwLevelCompleted;
    }

    public static int getLevelCompleted(){
        return levelCompleted;
    }

    public static void restartLevel(){
        Game.frame.dispose();
        Game level = new Game();
        level.startProgram();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageUitgang, 0, 0, 100,100,this);
    }
}

/** Het plaatje voor onze uitgang komt hier van daan:
 * http://www.minecraftopia.com/trapdoor.html
 */