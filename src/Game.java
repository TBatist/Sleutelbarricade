import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class Game extends JPanel {
    private static JPanel grid;
    private static JPanel buttonGroup;
    private static JPanel instructions = new JPanel();
    private static JPanel button = new JPanel();
    private static JLabel regel1 = new JLabel("Het doel van dit spel is om Patrick door het doolhof naar de uitgang te leiden.");
    private static JLabel regel2 = new JLabel("Patrick kan niet zelf door de kazen heen. Hiervoor heeft hij een rasp nodig met dezelde waarde als de kaas.");
    private static JLabel regel3 = new JLabel("Hij kan elke rasp maar 1x gebruiken. Wanneer hij een andere rasp oppakt, is hij de rasp die hij had kwijt.");
    private static JButton startGame;
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
        startGame = new JButton("Start spel");
        ActionListener actionListener = new addActionListener();
        startGame.addActionListener(actionListener);
        frame = new JFrame();
        grid.setLayout(new GridLayout(10, 10));
        KeyListener keyListener = new addKeyListener();
        frame.addKeyListener(keyListener);

        frame.setTitle("Sleutelbarricade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(Uitgang.getLevelCompleted() == -1){
            instructions.setLayout(new GridLayout(3,1));
            Font font = new Font("Serif", Font.BOLD, 20);
            regel1.setFont(font);
            regel2.setFont(font);
            regel3.setFont(font);
            regel1.setHorizontalAlignment(JLabel.CENTER);
            regel2.setHorizontalAlignment(JLabel.CENTER);
            regel3.setHorizontalAlignment(JLabel.CENTER);
            instructions.add(regel1);
            instructions.add(regel2);
            instructions.add(regel3);
            button.add(startGame);
            playMusic("src\\\\Age-of-War-_Online-Game_-Theme.wav");
        }else if(Uitgang.getLevelCompleted() == 0) {
            speelveld = Level.level1();
        }else if(Uitgang.getLevelCompleted() == 1){
            speelveld = Level.level2();
        }else if(Uitgang.getLevelCompleted() == 2){
            speelveld = Level.level3();
        }else if(Uitgang.getLevelCompleted() == 3){
            speelveld = Level.level4();
        }else{
            speelveld = Level.level5();
        }

        if(Uitgang.getLevelCompleted() >= 0) {
            for (int rij = 0; rij < 10; rij++) {
                for (int kolom = 0; kolom < 10; kolom++) {
                    grid.add(speelveld[rij][kolom]);
                    speelveld[rij][kolom].setBorder(border);
                }
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

        if(Uitgang.getLevelCompleted() < 0){
            frame.add(instructions, BorderLayout.NORTH);
            URL url = getClass().getResource("patrickGif.gif");
            ImageIcon imageIcon = new ImageIcon(url);
            JLabel gif = new JLabel(imageIcon);
            frame.add(gif);
            frame.add(button, BorderLayout.SOUTH);
            Uitgang.setLevelCompleted(0);
        }
        else {
            frame.add(grid, BorderLayout.CENTER);
            frame.add(buttonGroup, BorderLayout.SOUTH);
        }
        frame.setSize(1000, 1000);

        frame.setVisible(true);
    }

    /**
     * Methode om een achtergrond muziekje te laten afspelen
     * @param filepath
     */
    public static void playMusic(String filepath) {
        InputStream music;
        try {
            music = new FileInputStream(new File(filepath));
            AudioStream audios= new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
        }
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

    private class addActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Uitgang.restartLevel();
        }
    }
}

/** Deze bron hebben wij gebruikt voor de gif op het start scherm:
 * https://gifer.com/en/40OU
 * Deze bron gebruikt voor een achtergrond muziekje
 * https://www.youtube.com/watch?v=bupXb1Cby2U
 */