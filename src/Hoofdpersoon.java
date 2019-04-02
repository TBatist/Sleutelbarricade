import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Hoofdpersoon extends JComponent {
    private static int raspWaarde;
    private BufferedImage imagePatrick;

    public Hoofdpersoon() {
        raspWaarde = 0;
        URL resource = getClass().getResource("patrick.png");
        try {
            imagePatrick = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkWaarde(Kaas kaas) {
        if(raspWaarde == kaas.getWaarde()){
            return true;
        }
        return false;
    }

    public void setRaspWaarde(Rasp rasp){
        this.raspWaarde = rasp.getWaarde();
    }

    public int getRaspWaarde(){
        return this.raspWaarde;
    }

    public static int[] getHoofdpersoonLocation(){
        JComponent[][] speelveld = GUI.getSpeelveld();
        int[] temp = new int[2];
        for (int rij = 0; rij < 10; rij++) {
            for (int kolom = 0; kolom < 10; kolom++) {
                if (speelveld[rij][kolom] instanceof Hoofdpersoon) {
                    temp[0] = rij;
                    temp[1] = kolom;
                    return temp;
                }
            }
        }
        return null;
    }

    public static JComponent surrounding(char direction){
        JComponent[][] speelveld = GUI.getSpeelveld();
        int[] temp = getHoofdpersoonLocation();
        JComponent vakje = null;
        switch (direction){
            case 'r':
                if(temp[1] + 1 <= 9) {
                    vakje = speelveld[temp[0]][temp[1] + 1];
                }
                break;
            case 'l':
                if(temp[1] - 1 >= 0) {
                    vakje = speelveld[temp[0]][temp[1] - 1];
                }
                break;
            case 'u':
                if(temp[0] - 1 >= 0){
                    vakje = speelveld[temp[0] - 1][temp[1]];
                }
                break;
            case 'd':
                if(temp[0] + 1 <= 9) {
                    vakje = speelveld[temp[0] + 1][temp[1]];
                }
                break;
        }
        return vakje;
    }

    public static void moveHoofdpersoon(JComponent surrounding, char direction) {
        int[] temp = getHoofdpersoonLocation();
        Hoofdpersoon hoofdPersoon = GUI.getHoofdPersoon();
        JComponent[][] speelveld = GUI.getSpeelveld();
        if(!(surrounding == null || surrounding instanceof VasteMuur)) {
            if (surrounding instanceof Rasp) {
                hoofdPersoon.setRaspWaarde((Rasp) surrounding);
            }
            if (!(surrounding instanceof Kaas) || (surrounding instanceof Kaas && Hoofdpersoon.checkWaarde((Kaas) surrounding))) {
                switch (direction) {
                    case 'r':
                        speelveld[temp[0]][temp[1] + 1] = hoofdPersoon;

                        break;
                    case 'l':
                        speelveld[temp[0]][temp[1] - 1] = hoofdPersoon;
                        break;
                    case 'u':
                        speelveld[temp[0] - 1][temp[1]] = hoofdPersoon;
                        break;
                    case 'd':
                        speelveld[temp[0] + 1][temp[1]] = hoofdPersoon;
                        break;
                }
                speelveld[temp[0]][temp[1]] = new Vakje();
                if (surrounding instanceof Kaas) {
                    if (Hoofdpersoon.checkWaarde((Kaas) surrounding)) {
                        raspWaarde = 0;
                    }
                }
                if (surrounding instanceof Uitgang) {
                    Uitgang.restartLevel();
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagePatrick, 0, 0, 100,100,this);


    }


}