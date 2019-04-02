import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Kaas extends Vakje {
    private int waarde;
    private String waardeString;
    private BufferedImage imageKaas;

    public Kaas(int waarde){
        this.waarde = waarde;

        URL resource = getClass().getResource("blokKaas.png");
        try {
            imageKaas = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getWaarde(){
        return waarde;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageKaas, 0, 0, 100,100,this);
        g.setColor(Color.BLACK);
        getWaarde();
        waardeString = Integer.toString(waarde);
        g.drawString(waardeString,5,15);
    }

}
