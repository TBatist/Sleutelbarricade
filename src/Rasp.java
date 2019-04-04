import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Rasp extends JComponent {
    private int raspwaarde;
    private String waardeString;
    private BufferedImage imageRasp;

    /**
     * dit initialiseerd de waarde van de rasp en het plaatje
     * @param raspwaarde
     */
    public Rasp(int raspwaarde){
        this.raspwaarde = raspwaarde;
        URL resource = getClass().getResource("kaasRasp.png");
        try {
            imageRasp = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * getter voor de raspwaarde
     * @return raspwaarde
     */
    public int getRaspWaarde(){
        return raspwaarde;
    }

    /**
     * dit maakt het plaatje van de rasp en laat zien welke waarde de rasp heeft
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageRasp, 15, 10, 75,85,this);
        getRaspWaarde();
        waardeString = Integer.toString(raspwaarde);
        g.setColor(Color.BLACK);
        g.drawString(waardeString, 5, 15);
    }
}

/** Het plaatje voor onze sleutel komt hier van daan:
 * http://cliparts101.com/free_clipart/92687/Cheese_Grater
 */
