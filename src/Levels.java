import javax.swing.*;

public class Levels extends JPanel {
    private static int i;
    private static int j;




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
                {4,0,0,0,0,0,0,0,0,0},
                {1,1,1,3.1,3.2,1,1,3.1,3.2},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
        };
        return generateLevel(temp);
    }

    public static JComponent[][] level4(){
        JComponent [][] speelveld = GUI.getSpeelveld();
        //Maak level hier
        return speelveld;
    }

    public static JComponent[][] level5(){
        JComponent [][] speelveld = GUI.getSpeelveld();
        //Maak level hier
        return speelveld;
    }

    public static JComponent[][] generateLevel(double[][] temp) {
        JComponent [][] speelveld = GUI.getSpeelveld();
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (temp[i][j] ==0) {
                    speelveld[i][j] = new Vakje();
                }
                if (temp[i][j]==1) {
                    speelveld[i][j] = new VasteMuur();
                }
                if (temp[i][j]>=2 && temp[i][j]<3) {
                    if (temp[i][j] == 2.1) {
                        speelveld[i][j] = new Rasp(100);
                    }
                    if (temp[i][j] == 2.2) {
                        speelveld[i][j] = new Rasp(200);
                    }
                    if (temp[i][j] == 2.3) {
                        speelveld[i][j] = new Rasp(300);
                    }
                }
                if (temp[i][j] >= 3 && temp[i][j] <4) {
                    if (temp[i][j] == 3.1) {
                        speelveld[i][j] = new Kaas(100);
                    }
                    if (temp[i][j] == 3.2) {
                        speelveld[i][j] = new Kaas(200);
                    }
                    if (temp[i][j] == 3.3){
                        speelveld[i][j] = new Kaas(300);
                    }
                }
                if (temp[i][j] == 4){
                    speelveld[i][j] = new Hoofdpersoon();
                }
                if (temp[i][j] == 5) {
                    speelveld[i][j] = new Uitgang();
                }
            }
        }
        return speelveld;
    }

}