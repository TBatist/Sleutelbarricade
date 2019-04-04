import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Uitgang extends JComponent {
    private static int levelCompleted = -1;
    private BufferedImage imageUitgang;

    /**
     * initialiseerd het plaatje van de uitgang
     */
    public Uitgang(){
        URL resource = getClass().getResource("trapdoor.png");
        try {
            imageUitgang = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * setter voor het aantal levels die gehaald zijn
     * @param nieuwLevelCompleted
     */
    public static void setLevelCompleted(int nieuwLevelCompleted){
        levelCompleted = nieuwLevelCompleted;
    }

    /**
     * getter voor het aantal levels die gehaald zijn
     * @return levelCompleted
     */
    public static int getLevelCompleted(){
        return levelCompleted;
    }

    /**
     * methode die het level restart
     */
    public static void restartLevel(){
        Hoofdpersoon.setRaspWaarde(new Rasp(0));
        Game.frame.dispose();
        Game level = new Game();
        level.startProgram();
    }

    /**
     * methode die van uitgang een plaatje maakt
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageUitgang, 0, 0, 100,100,this);
    }
}