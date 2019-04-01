import javax.swing.*;

public class Levels extends JPanel {


    public static JComponent[][] level1() {
        JComponent [][] speelveld = GUI.getSpeelveld();
        speelveld[0][0] = new Hoofdpersoon();
        speelveld[1][0] = new VasteMuur();
        speelveld[1][1] = new VasteMuur();
        speelveld[1][2] = new VasteMuur();
        speelveld[1][3] = new VasteMuur();
        speelveld[1][5] = new VasteMuur();
        speelveld[1][6] = new VasteMuur();
        speelveld[1][7] = new VasteMuur();
        speelveld[1][8] = new VasteMuur();
        speelveld[3][8] = new VasteMuur();
        speelveld[3][7] = new VasteMuur();
        speelveld[3][6] = new VasteMuur();
        speelveld[2][5] = new VasteMuur();
        speelveld[3][5] = new VasteMuur();
        speelveld[3][4] = new VasteMuur();
        speelveld[3][3] = new VasteMuur();
        speelveld[3][2] = new VasteMuur();
        speelveld[3][1] = new VasteMuur();
        speelveld[3][3] = new VasteMuur();
        speelveld[4][0] = new VasteMuur();
        speelveld[5][1] = new VasteMuur();
        speelveld[5][2] = new VasteMuur();
        speelveld[5][3] = new VasteMuur();
        speelveld[5][4] = new VasteMuur();
        speelveld[5][5] = new VasteMuur();
        speelveld[5][6] = new VasteMuur();
        speelveld[5][7] = new VasteMuur();
        speelveld[5][8] = new VasteMuur();
        speelveld[7][1] = new VasteMuur();
        speelveld[7][2] = new VasteMuur();
        speelveld[7][3] = new VasteMuur();
        speelveld[7][4] = new VasteMuur();
        speelveld[7][5] = new VasteMuur();
        speelveld[7][6] = new VasteMuur();
        speelveld[7][7] = new VasteMuur();
        speelveld[7][8] = new VasteMuur();
        speelveld[8][1] = new VasteMuur();
        speelveld[8][2] = new VasteMuur();
        speelveld[8][3] = new VasteMuur();
        speelveld[8][4] = new VasteMuur();
        speelveld[8][5] = new VasteMuur();
        speelveld[8][6] = new VasteMuur();
        speelveld[8][7] = new VasteMuur();
        speelveld[8][8] = new VasteMuur();
        speelveld[9][9] = new Uitgang();
        speelveld[1][4] = new Obstakel(300);
        speelveld[3][9] = new Obstakel(150);
        speelveld[8][9] = new Obstakel(12);
        speelveld[9][8] = new Obstakel(30);
        speelveld[2][6] = new Schaar(300);
        speelveld[9][7] = new Schaar(12);
        speelveld[5][0] = new Schaar(60);
        speelveld[7][9] = new Schaar(30);
        speelveld[3][0] = new Schaar(150);
        return speelveld;
    }

}
