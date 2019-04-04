import javax.swing.*;
import java.awt.*;

public class Uitgang extends JComponent {
    private static int levelCompleted = 0;

    /**
     * setter voor het aantal gehaalde levels
     * @param nieuwLevelCompleted
     */
    public static void setLevelCompleted(int nieuwLevelCompleted){
        levelCompleted = nieuwLevelCompleted;
    }

    /**
     * getter voor het aantal gehaalde levels
     * @return levelCompleted
     */
    public static int getLevelCompleted(){
        return levelCompleted;
    }

    /**
     * Methode die hetzelfde level opnieuw opstart
     */
    public static void restartLevel(){
        Game.frame.dispose();
        Game level = new Game();
        level.startProgram();
    }

    /**
     *
     * @param g
     */
    public void paintComponent(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(0,0,80,80);
    }
}