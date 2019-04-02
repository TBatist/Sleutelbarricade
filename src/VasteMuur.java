import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class VasteMuur extends JComponent {
    private BufferedImage imageMuur;

    public VasteMuur(){
        URL resource = getClass().getResource("muur.png");
        try {
            imageMuur = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imageMuur, -101, -93, 300,300,this);
    }

}
