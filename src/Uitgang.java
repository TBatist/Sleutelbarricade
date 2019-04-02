import javax.swing.*;
import java.awt.*;

public class Uitgang extends JComponent {
    private static int levelCompleted = 2;

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
        g.setColor(Color.GREEN);
        g.fillOval(0,0,80,80);
    }
}