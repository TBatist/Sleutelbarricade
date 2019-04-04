import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Kaas extends JComponent {
    private int kaaswaarde;
    private String waardeString;
    private BufferedImage imageKaas;

    /**
     * Dit initialiseerd de waarde van de kaas en het plaatje
     * @param kaaswaarde
     */
    public Kaas(int kaaswaarde){
        this.kaaswaarde = kaaswaarde;

        URL resource = getClass().getResource("blokKaas.png");
        try {
            imageKaas = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * getter van de kaaswaarde
     * @return waarde
     */
    public int getKaasWaarde(){
        return kaaswaarde;
    }

    /**
     * dit maakt van het plaatje van de kaas en laat zien welke waarde de kaas heeft
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageKaas, 0, 0, 100,100,this);
        g.setColor(Color.BLACK);
        getKaasWaarde();
        waardeString = Integer.toString(kaaswaarde);
        g.drawString(waardeString,5,15);
    }

}

/**
 * Het Plaatje van onze obstakel komt van deze bron:
 * https://art4clip.com/explore/Macaroni%20clipart%20block%20cheese/#go_post_8359_mozzarella-clipart-french-cheese-15.png
 */