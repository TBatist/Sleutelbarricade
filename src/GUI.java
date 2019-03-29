import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JPanel {
    private static JPanel panel;
    private static Border border;
    private static JFrame frame;
    private JTextField keyText;
    private Hoofdpersoon h = new Hoofdpersoon();
    private Vakje v = new Vakje();
    private VasteMuur m = new VasteMuur();
    private Uitgang u = new Uitgang();



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

    public static int getHoofdpersoon(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (speelveld[i][j].equals(new Hoofdpersoon())) {
                    return i & j;
                }
            }
        }
        return 0;
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
                if(keyCode == KeyEvent.VK_RIGHT){
                    System.out.println("Rechts doet iets");
                    JComponent[][] speelveld = GUI.getSpeelveld();
                    System.out.println(getHoofdpersoon());

                    panel.removeAll();
                    speelveld[1][1]= h;
                    speelveld[2][2]=m;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            speelveld[i][j].setBorder(border);
                            panel.add(speelveld[i][j]);
                        }
                    }
                    frame.repaint();
                    frame.revalidate();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        frame.addKeyListener(listener);

        frame.setTitle("Sleutelbarricade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Hoofdpersoon h = new Hoofdpersoon();
        Vakje v = new Vakje();
        VasteMuur m = new VasteMuur();
        Uitgang u = new Uitgang();


        speelveld[0][0] = new Hoofdpersoon();
        speelveld[0][1] = new Vakje();
        speelveld[0][2] = new Vakje();
        speelveld[0][3] = new Vakje();
        speelveld[1][0] = new Vakje();
        speelveld[1][1] = new Vakje();
        speelveld[1][2] = new VasteMuur();
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
