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
    public static JFrame frame;
    private static Hoofdpersoon hoofdPersoon = new Hoofdpersoon();
    private static Vakje[][] speelveld = new Vakje[10][10];

    public static Vakje[][] getSpeelveld() {
        return speelveld;
    }

    public static void setSpeelveld(Vakje[][] nieuwVeld){
        speelveld = nieuwVeld;
    }

    public static Hoofdpersoon getHoofdPersoon(){
        return hoofdPersoon;
    }

    public static void setHoofdPersoon(Hoofdpersoon nieuwPersoon){
        hoofdPersoon = nieuwPersoon;
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

        if(Uitgang.getLevelCompleted() == 0) {
            speelveld = Levels.level1();
        }else if(Uitgang.getLevelCompleted() == 1){
            speelveld = Levels.level2();
        }else if(Uitgang.getLevelCompleted() == 2){
            speelveld = Levels.level3();
        }else if(Uitgang.getLevelCompleted() == 3){
            speelveld = Levels.level4();
        }else{
            speelveld = Levels.level5();
        }

        for (int rij = 0; rij < 10; rij++) {
            for (int kolom = 0; kolom < 10; kolom++) {
                if(speelveld[rij][kolom] == null){
                    speelveld[rij][kolom] = new Vakje();
                }
                panel.add(speelveld[rij][kolom]);
                speelveld[rij][kolom].setBorder(border);
            }
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1000, 1000);

        frame.setVisible(true);
    }

    public class addKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            panel.removeAll();
            switch(keyCode) {
                case KeyEvent.VK_RIGHT:
                    Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
                    break;
                case KeyEvent.VK_LEFT:
                    Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
                    break;
                case KeyEvent.VK_UP:
                    Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
                    break;
                case KeyEvent.VK_DOWN:
                    Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
                    break;
            }

            for (int rij = 0; rij < 10; rij++) {
                for (int kolom = 0; kolom < 10; kolom++) {
                    speelveld[rij][kolom].setBorder(border);
                    panel.add(speelveld[rij][kolom]);
                }
            }
            frame.repaint();
            frame.revalidate();
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}