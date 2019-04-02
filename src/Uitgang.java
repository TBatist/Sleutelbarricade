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

    public static void setLevelCompleted(){
        levelCompleted++;
    }

    public static int getLevelCompleted(){
        return levelCompleted;
    }

    public static void restartLevel(){
        setLevelCompleted();
        GUI.frame.dispose();
        GUI level = new GUI();
        level.startProgram();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageUitgang, 0, 0, 100,100,this);
    }
}