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
    public static JFrame frame;
    private static Hoofdpersoon hoofdPersoon = new Hoofdpersoon();
    private static JComponent[][] speelveld = new JComponent[10][10];

    public static JComponent[][] getSpeelveld() {
        return speelveld;
    }

    public static Hoofdpersoon getHoofdPersoon(){
        return hoofdPersoon;
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
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            panel.removeAll();
            JComponent surrounding;
            switch(keyCode) {
                case KeyEvent.VK_RIGHT:
                    surrounding = Hoofdpersoon.surrounding('r');
                    Hoofdpersoon.moveHoofdpersoon(surrounding, 'r');
                    break;
                case KeyEvent.VK_LEFT:
                    surrounding = Hoofdpersoon.surrounding('l');
                    Hoofdpersoon.moveHoofdpersoon(surrounding, 'l');
                    break;
                case KeyEvent.VK_UP:
                    surrounding = Hoofdpersoon.surrounding('u');
                    Hoofdpersoon.moveHoofdpersoon(surrounding, 'u');
                    break;
                case KeyEvent.VK_DOWN:
                    surrounding = Hoofdpersoon.surrounding('d');
                    Hoofdpersoon.moveHoofdpersoon(surrounding, 'd');
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
        public void keyReleased(KeyEvent e) {}
    }
}