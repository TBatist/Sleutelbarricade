import javax.swing.*;

public class Levels extends JPanel {
    private static int rij;
    private static int kolom;




    public static Vakje[][] level1() {
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

    public static Vakje[][] level2(){
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

    public static Vakje[][] level3(){
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

    public static Vakje[][] level4(){
        Vakje [][] speelveld = GUI.getSpeelveld();
        //Maak level hier
        return speelveld;
    }

    public static Vakje[][] level5(){
        Vakje [][] speelveld = GUI.getSpeelveld();
        //Maak level hier
        return speelveld;
    }

    public static Vakje[][] generateLevel(double[][] temp) {
        Vakje [][] speelveld = GUI.getSpeelveld();
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
                    speelveld[rij][kolom] = new Hoofdpersoon();
                }
                if (temp[rij][kolom] == 5) {
                    speelveld[rij][kolom] = new Uitgang();
                }
            }
        }
        return speelveld;
    }

}