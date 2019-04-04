import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {
    private static JPanel grid;
    private static JPanel buttonGroup;
    private static Border border;
    public static JFrame frame;
    private static Hoofdpersoon hoofdPersoon = new Hoofdpersoon();
    private static JComponent[][] speelveld = new JComponent[10][10];

    public static JComponent[][] getSpeelveld() {
        return speelveld;
    }

    public static void setSpeelveld(JComponent[][] nieuwVeld){
        speelveld = nieuwVeld;
    }

    public static Hoofdpersoon getHoofdPersoon(){
        return hoofdPersoon;
    }

    public static void setHoofdPersoon(Hoofdpersoon nieuwPersoon){
        hoofdPersoon = nieuwPersoon;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startProgram();
    }

    public void startProgram() {
        border = BorderFactory.createLineBorder(Color.black);
        grid = new JPanel();
        buttonGroup = new JPanel();
        frame = new JFrame();
        grid.setLayout(new GridLayout(10, 10));
        KeyListener keyListener = new addKeyListener();
        frame.addKeyListener(keyListener);

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
                grid.add(speelveld[rij][kolom]);
                speelveld[rij][kolom].setBorder(border);
            }
        }
        JLabel reset = new JLabel("R = Reset level  |  ");
        reset.setFont(new Font("Serif", Font.BOLD, 15));

        JLabel up = new JLabel("Moving up = ↑  |  ");
        up.setFont(new Font("Serif", Font.BOLD, 15));

        JLabel down = new JLabel("Moving down = ↓  |  ");
        down.setFont(new Font("Serif", Font.BOLD, 15));

        JLabel left = new JLabel("Move left = ←  |  ");
        left.setFont(new Font("Serif", Font.BOLD, 15));

        JLabel right = new JLabel("Move right = →");
        right.setFont(new Font("Serif", Font.BOLD, 15));
        buttonGroup.add(reset, BorderLayout.SOUTH);
        buttonGroup.add(up, BorderLayout.SOUTH);
        buttonGroup.add(down, BorderLayout.SOUTH);
        buttonGroup.add(left, BorderLayout.SOUTH);
        buttonGroup.add(right, BorderLayout.SOUTH);

        frame.add(grid, BorderLayout.CENTER);
        frame.add(buttonGroup, BorderLayout.SOUTH);
        frame.setSize(1000, 1000);

        frame.setVisible(true);
    }

    public class addKeyListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            char direction = 'w';
            grid.removeAll();
            switch(keyCode) {
                case KeyEvent.VK_RIGHT:
                    direction = 'r';
                    break;
                case KeyEvent.VK_LEFT:
                    direction = 'l';
                    break;
                case KeyEvent.VK_UP:
                    direction = 'u';
                    break;
                case KeyEvent.VK_DOWN:
                    direction = 'd';
                    break;
                case KeyEvent.VK_R:
                    Uitgang.restartLevel();
                    break;
            }
            Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding(direction), direction);

            for (int rij = 0; rij < 10; rij++) {
                for (int kolom = 0; kolom < 10; kolom++) {
                    speelveld[rij][kolom].setBorder(border);
                    grid.add(speelveld[rij][kolom]);
                }
            }
            frame.repaint();
            frame.revalidate();
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}