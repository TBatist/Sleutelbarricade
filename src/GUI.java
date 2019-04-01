import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JPanel {
    private static int i;
    private static int j;
    private static JPanel panel;
    private static Border border;
    private static JFrame frame;
    private Hoofdpersoon hoofdPersoon = new Hoofdpersoon();



    private static JComponent[][] speelveld = new JComponent[10][10];

    public static JComponent[][] getSpeelveld() {
        return speelveld;
    }

    public static int[] getHoofdpersoon(){
        int[] temp = new int[2];
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (speelveld[i][j] instanceof Hoofdpersoon) {
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        GUI game = new GUI();
        game.startProgram();
    }


    public void startProgram() {
        border = BorderFactory.createLineBorder(Color.black);
        panel = new JPanel();
        frame = new JFrame();
        panel.setLayout(new GridLayout(10, 10));
        KeyListener listener = new addKeyListener();
        frame.addKeyListener(listener);

        frame.setTitle("Sleutelbarricade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        speelveld[0][0] = hoofdPersoon;
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



        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(!(speelveld[i][j] instanceof JComponent)){
                    speelveld[i][j] = new Vakje();
                }
                panel.add(speelveld[i][j]);
                speelveld[i][j].setBorder(border);
            }
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1000, 1000);

        frame.setVisible(true);
    }

    public class addKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            JComponent[][] speelveld = GUI.getSpeelveld();
            panel.removeAll();
            int[] temp = getHoofdpersoon();
            JComponent surrouding;
            switch(keyCode) {
                case KeyEvent.VK_RIGHT:
                    surrouding = Hoofdpersoon.surrounding('r');
                    if (temp[1] + 1 <= 9 && (surrouding instanceof Vakje) || (surrouding instanceof Obstakel && Hoofdpersoon.checkWaarde((Obstakel) surrouding)) || (surrouding instanceof Schaar) || surrouding instanceof Uitgang) {
                        if(surrouding instanceof Schaar){
                            hoofdPersoon.addSchaar((Schaar) surrouding);
                        }
                        speelveld[temp[0]][temp[1] + 1] = hoofdPersoon;
                        speelveld[temp[0]][temp[1]] = new Vakje();
                        if(surrouding instanceof Uitgang) {
                            frame.dispose();
                            Uitgang.restartLevel();
                        }
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    surrouding = Hoofdpersoon.surrounding('l');
                    if (temp[1] - 1 >= 0 && (surrouding instanceof Vakje)|| (surrouding instanceof Obstakel && Hoofdpersoon.checkWaarde((Obstakel) surrouding)) || (surrouding instanceof Schaar) || surrouding instanceof Uitgang) {
                        if(surrouding instanceof Schaar){
                            hoofdPersoon.addSchaar((Schaar) surrouding);
                        }
                        speelveld[temp[0]][temp[1] - 1] = hoofdPersoon;
                        speelveld[temp[0]][temp[1]] = new Vakje();
                        if(surrouding instanceof Uitgang) {
                            frame.dispose();
                            Uitgang.restartLevel();
                        }
                    }
                    break;
                case KeyEvent.VK_UP:
                    surrouding = Hoofdpersoon.surrounding('u');
                    if (temp[0] - 1 >= 0 && (surrouding instanceof Vakje) || (surrouding instanceof Obstakel && Hoofdpersoon.checkWaarde((Obstakel) surrouding)) || (surrouding instanceof Schaar) || surrouding instanceof Uitgang) {
                        if(surrouding instanceof Schaar){
                            hoofdPersoon.addSchaar((Schaar) surrouding);
                        }
                        speelveld[temp[0] - 1][temp[1]] = hoofdPersoon;
                        speelveld[temp[0]][temp[1]] = new Vakje();
                        if(surrouding instanceof Uitgang) {
                            frame.dispose();
                            Uitgang.restartLevel();
                        }
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    surrouding = Hoofdpersoon.surrounding('d');
                    if (temp[0] + 1 <= 9 && (surrouding instanceof Vakje)|| (surrouding instanceof Obstakel && Hoofdpersoon.checkWaarde((Obstakel) surrouding)) || (surrouding instanceof Schaar) || surrouding instanceof Uitgang) {
                        if(surrouding instanceof Schaar){
                            hoofdPersoon.addSchaar((Schaar) surrouding);
                        }
                        speelveld[temp[0] + 1][temp[1]] = hoofdPersoon;
                        speelveld[temp[0]][temp[1]] = new Vakje();
                        if(surrouding instanceof Uitgang) {
                            frame.dispose();
                            Uitgang.restartLevel();
                        }
                    }
                    break;
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    speelveld[i][j].setBorder(border);
                    panel.add(speelveld[i][j]);
                }
            }
            frame.repaint();
            frame.revalidate();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
}
