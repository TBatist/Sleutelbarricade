import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class VasteMuur extends JComponent {
    private BufferedImage imageMuur;

    /**
     * initialiseerd het plaatje van de muur
     */
    public VasteMuur(){
        URL resource = getClass().getResource("muur.png");
        try {
            imageMuur = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * dit maakt het plaatje van de muur
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageMuur, -101, -93, 300,300,this);
    }

}
