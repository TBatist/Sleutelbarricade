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
    private JTextField keyText;
    private Hoofdpersoon hoofdPersoon = new Hoofdpersoon();
    private Vakje vakje = new Vakje();
    private VasteMuur muur = new VasteMuur();
    private Uitgang uitgang = new Uitgang();



    private static JComponent[][] speelveld = new JComponent[4][4];

    public static JComponent[][] getSpeelveld() {
        return speelveld;
    }

    public static void setSpeelveld(JComponent[][] speelveld) {

        panel = new JPanel();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                speelveld[i][j].setBorder(border);
                panel.add(speelveld[i][j]);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
    }

    public static int[] getHoofdpersoon(){
        int[] temp = new int[2];
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                if (speelveld[i][j] instanceof Hoofdpersoon) {
                    System.out.println("i is:" + i + " J is: " + j);
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
        keyText = new JTextField(200);
        panel.setLayout(new GridLayout(4, 4));
        KeyListener listener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                JComponent[][] speelveld = GUI.getSpeelveld();
                panel.removeAll();
                if(keyCode == KeyEvent.VK_RIGHT){
                    System.out.println("Rechts doet iets");

                    int[] temp = getHoofdpersoon();
                    speelveld[temp[0]][temp[1] + 1] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();

                }

                else if(keyCode == KeyEvent.VK_LEFT){
                    System.out.println("Rechts doet iets");

                    int[] temp = getHoofdpersoon();
                    speelveld[temp[0]][temp[1] - 1] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();

                }

                else if(keyCode == KeyEvent.VK_UP){
                    System.out.println("Rechts doet iets");

                    int[] temp = getHoofdpersoon();
                    speelveld[temp[0 - 1]][temp[1]] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();

                }

                else if(keyCode == KeyEvent.VK_DOWN){
                    System.out.println("Rechts doet iets");

                    int[] temp = getHoofdpersoon();
                    speelveld[temp[0 + 1]][temp[1]] = hoofdPersoon;
                    speelveld[temp[0]][temp[1]] = new Vakje();

                }

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
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
        frame.addKeyListener(listener);

        frame.setTitle("Sleutelbarricade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        speelveld[0][0] = hoofdPersoon;
        speelveld[0][1] = vakje;
        speelveld[0][2] = new Vakje();
        speelveld[0][3] = new Vakje();
        speelveld[1][0] = new Vakje();
        speelveld[1][1] = new Vakje();
        speelveld[1][2] = muur;
        speelveld[1][3] = new Vakje();
        speelveld[2][0] = new Vakje();
        speelveld[2][1] = new Vakje();
        speelveld[2][2] = new Vakje();
        speelveld[2][3] = new Vakje();
        speelveld[3][0] = new Vakje();
        speelveld[3][1] = new Vakje();
        speelveld[3][2] = new Vakje();
        speelveld[3][3] = new Uitgang();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                panel.add(speelveld[i][j]);
                speelveld[i][j].setBorder(border);
            }
        }

        frame.add(panel);
        frame.setSize(1000, 1000);

        frame.setVisible(true);
    }
}
