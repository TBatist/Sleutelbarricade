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
    /**
     * Dit is een getter van het speelveld, zodat deze gebruikt kan worden in andere classes
     * @return speelveld
     */
    public static JComponent[][] getSpeelveld() {
        return speelveld;
    }

    /**
     *Dit is een setter van het speelveld, zodat dit gebruikt kan worden in andere classes
     * @param nieuwVeld
     */
    public static void setSpeelveld(JComponent[][] nieuwVeld){
        speelveld = nieuwVeld;
    }

    /**
     * Dit is een getter van het hoofdpersoon, zodat in andere classes het hoofdpersoon opgevraagd kan worden
     * @return hoofdPersoon
     */
    public static Hoofdpersoon getHoofdPersoon(){
        return hoofdPersoon;
    }

    /**
     * Dit is een setter van het hoofdpersoon, zodat het in andere classes gebruikt kan worden
     * @param nieuwPersoon
     */
    public static void setHoofdPersoon(Hoofdpersoon nieuwPersoon){
        hoofdPersoon = nieuwPersoon;
    }

    /**
     * de main method die het spel start.
     * @param args wordt niet gebruikt
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.startProgram();
    }

    /**
     * De method die ervoor zorgt dat het frame opgestart wordt en alles daarbij wordt toegevoegd
     * Ook kijkt dit naar welk level the speler is en maakt de grid en de borders van de levels
     */
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

        JButton reset = new JButton("Reset");
        ActionListener actionListener = new addActionListener();
        reset.addActionListener(actionListener);
        buttonGroup.add(reset, BorderLayout.SOUTH);

        frame.add(grid, BorderLayout.CENTER);
        //frame.add(buttonGroup, BorderLayout.SOUTH);
        frame.setSize(1000, 1000);

        frame.setVisible(true);
    }

    /**
     * Dit is de class die ervoor zorgt dat er iets gebeurt als je op een pijltje drukt
     */
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

    public class addActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Uitgang.restartLevel();
        }
    }
}