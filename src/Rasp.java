import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Rasp extends JComponent {
    private int waarde;
    private String waardeString;
    private BufferedImage imageRasp;

    public Rasp(int waarde){
        this.waarde = waarde;
        URL resource = getClass().getResource("kaasRasp.png");
        try {
            imageRasp = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWaarde(){
        return waarde;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageRasp, 15, 10, 75,85,this);
        getWaarde();
        waardeString = Integer.toString(waarde);
        g.setColor(Color.BLACK);
        g.drawString(waardeString, 5, 15);
    }
}

/** Het plaatje voor onze sleutel komt hier van daan:
 * http://cliparts101.com/free_clipart/92687/Cheese_Grater
 */
