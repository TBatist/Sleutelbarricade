
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Hoofdpersoon extends JComponent {
    private static int raspWaarde;
    private BufferedImage imagePatrick;

    /**
     * Hierin wordt de startwaarde van rasp en een plaatje geinitialiseerd
     */
    public Hoofdpersoon() {
        raspWaarde = 0;
        URL resource = getClass().getResource("Patrick.png");
        try {
            imagePatrick = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hier wordt gecheckt of de raspwaarde gelijk is aan de kaaswaarde
     * @param kaas
     * @return boolean
     */
    public static boolean checkWaarde(Kaas kaas) {
        if(raspWaarde == kaas.getKaasWaarde()){
            return true;
        }
        return false;
    }

    /**
     * Setter voor raspwaarde
     * @param rasp
     */
    public static void setRaspWaarde(Rasp rasp){
        raspWaarde = rasp.getRaspWaarde();
    }

    /**
     * getter voor raspwaarde
     * @return raspwaarde
     */
    public int getRaspWaarde(){
        return this.raspWaarde;
    }

    /**
     * getter voor de locatie van hoofdpersoon
     * @return coordinaten van hoofdpersoon
     */
    public static int[] getHoofdpersoonLocation(){
        JComponent[][] speelveld = Game.getSpeelveld();
        int[] coordinaten = new int[2];
        for (int rij = 0; rij < 10; rij++) {
            for (int kolom = 0; kolom < 10; kolom++) {
                if (speelveld[rij][kolom] instanceof Hoofdpersoon) {
                    coordinaten[0] = rij;
                    coordinaten[1] = kolom;
                    return coordinaten;
                }
            }
        }
        return null;
    }

    /**
     * Methode om te kijken wat er naast je zit aan een bepaalde kant en of je niet uit de map loopt
     * @param direction
     * @return Object in het speelveld
     */
    public static JComponent surrounding(char direction){
        JComponent[][] speelveld = Game.getSpeelveld();
        int[] coordinaten = getHoofdpersoonLocation();
        int y = coordinaten[0];
        int x = coordinaten[1];
        switch (direction){
            case 'r':
                if(x + 1 <= 9) {
                    return speelveld[y][x + 1];
                }
                break;
            case 'l':
                if(x - 1 >= 0) {
                    return speelveld[y][x - 1];
                }
                break;
            case 'u':
                if(y - 1 >= 0){
                    return speelveld[y - 1][x];
                }
                break;
            case 'd':
                if(y + 1 <= 9) {
                    return speelveld[y + 1][x];
                }
                break;
        }
        return null;
    }

    /**
     * Methode die het hoofdpersoon een bepaalde kant op laten lopen mits dit kan volgens het spel
     * @param surrounding
     * @param direction
     */
    public static void moveHoofdpersoon(JComponent surrounding, char direction) {
        int[] coordinaten = getHoofdpersoonLocation();
        int y = coordinaten[0];
        int x = coordinaten[1];
        Hoofdpersoon hoofdPersoon = Game.getHoofdPersoon();
        JComponent[][] speelveld = Game.getSpeelveld();
        if(!(surrounding instanceof VasteMuur || surrounding == null)) {
            if (surrounding instanceof Rasp) {
                hoofdPersoon.setRaspWaarde((Rasp) surrounding);
            }
            if (!(surrounding instanceof Kaas) || (Hoofdpersoon.checkWaarde((Kaas) surrounding))) {
                switch (direction) {
                    case 'r':
                        speelveld[y][x + 1] = hoofdPersoon;
                        break;
                    case 'l':
                        speelveld[y][x - 1] = hoofdPersoon;
                        break;
                    case 'u':
                        speelveld[y - 1][x] = hoofdPersoon;
                        break;
                    case 'd':
                        speelveld[y + 1][x] = hoofdPersoon;
                        break;
                }
                speelveld[y][x] = new Vakje();
                if (surrounding instanceof Kaas) {
                    if (Hoofdpersoon.checkWaarde((Kaas) surrounding)) {
                        raspWaarde = 0;
                    }
                }
                if (surrounding instanceof Uitgang) {
                    Uitgang.setLevelCompleted(Uitgang.getLevelCompleted() + 1);
                    Uitgang.restartLevel();
                }
            }
        }
    }

    /**
     * Dit maakt van het hoofdpersonage het plaatje
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagePatrick, 0, 0, 100,100,this);


    }


}