import javax.swing.*;
import java.awt.*;

public class Hoofdpersoon extends JComponent {
    private static int raspWaarde;

    public Hoofdpersoon() {
        raspWaarde = 0;
    }

    public static boolean checkWaarde(Kaas kaas) {
        if(raspWaarde == kaas.getWaarde()){
            return true;
        }
        return false;
    }

    public void setSchaarWaarde(Rasp rasp){
        this.raspWaarde = rasp.getWaarde();
    }

    public int getSchaarWaarde(){
        return this.raspWaarde;
    }

    public static int[] getHoofdpersoonLocation(){
        JComponent[][] speelveld = GUI.getSpeelveld();
        int[] temp = new int[2];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (speelveld[i][j] instanceof Hoofdpersoon) {
                    temp[0] = i;
                    temp[1] = j;
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
        switch (direction) {
            case 'r':
                if (temp[1] + 1 <= 9 && (surrounding instanceof Vakje) || (surrounding instanceof Kaas && Hoofdpersoon.checkWaarde((Kaas) surrounding)) || (surrounding instanceof Rasp) || surrounding instanceof Uitgang) {
                    if (surrounding instanceof Rasp) {
                        hoofdPersoon.setSchaarWaarde((Rasp) surrounding);
                    }
                    speelveld[temp[0]][temp[1] + 1] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();
                }
                break;
            case 'l':
                if (temp[1] + 1 >= 0 && (surrounding instanceof Vakje) || (surrounding instanceof Kaas && Hoofdpersoon.checkWaarde((Kaas) surrounding)) || (surrounding instanceof Rasp) || surrounding instanceof Uitgang) {
                    if (surrounding instanceof Rasp) {
                        hoofdPersoon.setSchaarWaarde((Rasp) surrounding);
                    }
                    speelveld[temp[0]][temp[1] - 1] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();
                }
                break;
            case 'u':
                if (temp[0] - 1 >= 0 && (surrounding instanceof Vakje) || (surrounding instanceof Kaas && Hoofdpersoon.checkWaarde((Kaas) surrounding)) || (surrounding instanceof Rasp) || surrounding instanceof Uitgang) {
                    if (surrounding instanceof Rasp) {
                        hoofdPersoon.setSchaarWaarde((Rasp) surrounding);
                    }
                    speelveld[temp[0] - 1][temp[1]] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();
                }
                break;
            case 'd':
                if (temp[0] + 1 <= 9 && (surrounding instanceof Vakje) || (surrounding instanceof Kaas && Hoofdpersoon.checkWaarde((Kaas) surrounding)) || (surrounding instanceof Rasp) || surrounding instanceof Uitgang) {
                    if (surrounding instanceof Rasp) {
                        hoofdPersoon.setSchaarWaarde((Rasp) surrounding);
                    }
                    speelveld[temp[0] + 1][temp[1]] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();

                }
                break;
        }
        if(surrounding instanceof Kaas){
            raspWaarde = 0;
        }
        if (surrounding instanceof Uitgang) {
            Uitgang.restartLevel();
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(0, 0, 80, 80);

    }


}