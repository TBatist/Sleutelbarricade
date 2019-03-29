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


    private static JComponent[] speelveld = new JComponent[16];

    public static JComponent[] getSpeelveld() {
        return speelveld;
    }

    public static void setSpeelveld(JComponent[] speelveld) {
        panel = new JPanel();
        for (int i = 0; i < speelveld.length; i++) {
            speelveld[i].setBorder(border);
            panel.add(speelveld[i]);
        }
        frame.add(panel, BorderLayout.CENTER);
    }

    public static int getHoofdpersoon(){
        for (int i = 0; i < speelveld.length; i++) {
            if(speelveld[i].equals(new Hoofdpersoon())){
                return i;
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
                    JComponent[] speelveld = GUI.getSpeelveld();
                    int hoofdpersoon = GUI.getHoofdpersoon();
                    speelveld[hoofdpersoon] = new Vakje();
                    speelveld[hoofdpersoon + 1] = new Hoofdpersoon();

                    panel.removeAll();
                    for (int i = 0; i < speelveld.length; i++) {
                        panel.add(speelveld[i]);
                        speelveld[i].setBorder(border);
                    }
                    frame.add(panel, BorderLayout.CENTER);
                    frame.revalidate();
                    frame.repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        frame.addKeyListener(listener);

        frame.setTitle("Sleutelbarricade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        speelveld[0] = new Hoofdpersoon();
        speelveld[1] = new Vakje();
        speelveld[2] = new Vakje();
        speelveld[3] = new Vakje();
        speelveld[4] = new Vakje();
        speelveld[5] = new Vakje();
        speelveld[6] = new VasteMuur();
        speelveld[7] = new Vakje();
        speelveld[8] = new Vakje();
        speelveld[9] = new Vakje();
        speelveld[10] = new Vakje();
        speelveld[11] = new Vakje();
        speelveld[12] = new Vakje();
        speelveld[13] = new Vakje();
        speelveld[14] = new Vakje();
        speelveld[15] = new Uitgang();

        for (int i = 0; i < speelveld.length; i++) {
            panel.add(speelveld[i]);
            speelveld[i].setBorder(border);
        }

        frame.add(panel);
        frame.setSize(1000, 1000);

        frame.setVisible(true);
    }
}
