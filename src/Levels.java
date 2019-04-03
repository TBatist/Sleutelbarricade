import javax.swing.*;

public class Levels extends JPanel {
    private static int rij;
    private static int kolom;

    public static JComponent[][] fillSpeelveld(JComponent[][] speelveld){
        for (rij = 0; rij < 10; rij++) {
            for (kolom = 0; kolom < 10; kolom++) {
                if(speelveld[rij][kolom] == null){
                    speelveld[rij][kolom] = new Vakje();
                }
            }
        }
        return speelveld;
    }


    public static JComponent[][] level1() {
        double[][] temp = {
        {4,0,0,0,0,0,0,0,0,0},
        {1,1,1,1,3.1,1,1,1,1,0},
        {0,0,0,0,0,1,2.1,0,0,0},
        {2.2,1,1,1,1,1,1,1,1,3.2},
        {1,0,0,0,0,0,0,0,0,0},
        {2.2,1,1,1,1,1,1,1,1,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,1,1,1,1,1,1,1,1,2.1},
        {0,1,1,1,1,1,1,1,1,3.2},
        {0,0,0,0,0,0,0,2.3,3.3,5}
        };
        return generateLevel(temp);
    }

    public static JComponent[][] level2(){
        double[][] temp = {
                {4,0,0,0,0,2.1,2.2,0,0,0},
                {1,1,1,3.1,3.2,1,1,1,3.1,3.2},
                {2.2,0,0,0,0,1,2.1,0,0,0},
                {0,0,0,0,0,1,0,0,0,0},
                {1,1,1,1,3.2,1,3.1,1,1,1},
                {0,0,2.1,0,0,1,0,0,0,0},
                {3.1,1,1,1,1,1,1,1,1,3.2},
                {0,0,0,0,0,1,2.3,2.2,0,0},
                {0,2.2,2.3,0,0,1,1,1,1,3.1},
                {0,0,0,0,0,3.1,3.2,3.3,2.1,5}
                };
        return generateLevel(temp);
    }

    public static JComponent[][] level3(){
        double[][] temp = {
                {4,1,1,1,1,1,0,0,0,0},
                {0,1,0,3.2,2.3,1,0,1,0,0},
                {0,3.1,0,1,3.2,1,0,1,1,0},
                {0,1,0,1,0,1,0,1,0,0},
                {2.1,1,0,3.3,0,1,0,1,2.2,1},
                {2.2,1,1,1,0,1,0,1,3.3,1},
                {3.2,1,0,0,0,1,3.1,1,0,0},
                {2.3,1,0,1,1,1,0,1,0,0},
                {1,0,0,0,3.1,0,0,1,0,0},
                {2.1,2.1,0,0,1,1,1,1,0,5},
        };
        return generateLevel(temp);
    }

    public static JComponent[][] level4(){
        JComponent [][] speelveld = Game.getSpeelveld();
        //Maak level hier
        return speelveld;
    }

    public static JComponent[][] level5(){
        JComponent [][] speelveld = Game.getSpeelveld();
        //Maak level hier
        return speelveld;
    }

    public static JComponent[][] generateLevel(double[][] temp) {
        JComponent [][] speelveld = Game.getSpeelveld();
        for (rij = 0; rij < 10; rij++) {
            for (kolom = 0; kolom < 10; kolom++) {
                if (temp[rij][kolom] ==0) {
                    speelveld[rij][kolom] = new Vakje();
                }
                if (temp[rij][kolom]==1) {
                    speelveld[rij][kolom] = new VasteMuur();
                }
                if (temp[rij][kolom]>=2 && temp[rij][kolom]<3) {
                    if (temp[rij][kolom] == 2.1) {
                        speelveld[rij][kolom] = new Rasp(100);
                    }
                    if (temp[rij][kolom] == 2.2) {
                        speelveld[rij][kolom] = new Rasp(200);
                    }
                    if (temp[rij][kolom] == 2.3) {
                        speelveld[rij][kolom] = new Rasp(300);
                    }
                }
                if (temp[rij][kolom] >= 3 && temp[rij][kolom] <4) {
                    if (temp[rij][kolom] == 3.1) {
                        speelveld[rij][kolom] = new Kaas(100);
                    }
                    if (temp[rij][kolom] == 3.2) {
                        speelveld[rij][kolom] = new Kaas(200);
                    }
                    if (temp[rij][kolom] == 3.3){
                        speelveld[rij][kolom] = new Kaas(300);
                    }
                }
                if (temp[rij][kolom] == 4){
                    speelveld[rij][kolom] = Game.getHoofdPersoon();
                }
                if (temp[rij][kolom] == 5) {
                    speelveld[rij][kolom] = new Uitgang();
                }
            }
        }
        return speelveld;
    }

}