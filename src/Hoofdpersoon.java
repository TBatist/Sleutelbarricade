import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Hoofdpersoon extends JComponent {
    private static ArrayList<Schaar> schaarLijst;

    public Hoofdpersoon() {
        schaarLijst = new ArrayList<>();
    }

    public static boolean checkWaarde(Obstakel obstakel) {
        for(Schaar schaar : schaarLijst){
            if(schaar.getWaarde() == obstakel.getWaarde()){
                return true;
            }
        }
        return false;
    }

    public static void addSchaar(Schaar schaar){
        schaarLijst.add(schaar);
    }

    public static ArrayList<Schaar> getSchaarLijst(){
        return schaarLijst;
    }

    public static String getString(){
        String temp = "";
        for(Schaar schaar : schaarLijst){
            temp += schaar.getWaarde();
        }
        return temp;
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
                if (temp[1] + 1 <= 9 && (surrounding instanceof Vakje) || (surrounding instanceof Obstakel && Hoofdpersoon.checkWaarde((Obstakel) surrounding)) || (surrounding instanceof Schaar) || surrounding instanceof Uitgang) {
                    if (surrounding instanceof Schaar) {
                        hoofdPersoon.addSchaar((Schaar) surrounding);
                    }
                    speelveld[temp[0]][temp[1] + 1] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();
                }
                break;
            case 'l':
                if (temp[1] + 1 >= 0 && (surrounding instanceof Vakje) || (surrounding instanceof Obstakel && Hoofdpersoon.checkWaarde((Obstakel) surrounding)) || (surrounding instanceof Schaar) || surrounding instanceof Uitgang) {
                    if (surrounding instanceof Schaar) {
                        hoofdPersoon.addSchaar((Schaar) surrounding);
                    }
                    speelveld[temp[0]][temp[1] - 1] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();
                }
                break;
            case 'u':
                if (temp[0] - 1 >= 0 && (surrounding instanceof Vakje) || (surrounding instanceof Obstakel && Hoofdpersoon.checkWaarde((Obstakel) surrounding)) || (surrounding instanceof Schaar) || surrounding instanceof Uitgang) {
                    if (surrounding instanceof Schaar) {
                        hoofdPersoon.addSchaar((Schaar) surrounding);
                    }
                    speelveld[temp[0] - 1][temp[1]] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();
                }
                break;
            case 'd':
                if (temp[0] + 1 <= 9 && (surrounding instanceof Vakje) || (surrounding instanceof Obstakel && Hoofdpersoon.checkWaarde((Obstakel) surrounding)) || (surrounding instanceof Schaar) || surrounding instanceof Uitgang) {
                    if (surrounding instanceof Schaar) {
                        hoofdPersoon.addSchaar((Schaar) surrounding);
                    }
                    speelveld[temp[0] + 1][temp[1]] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();

                }
                break;
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