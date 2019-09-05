import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Level extends JPanel {
    private static int rij;
    private static int kolom;
    private static Random intNummer = new Random();
    private static int nummer;

    public static JComponent[][] fillSpeelveld(JComponent[][] speelveld) {
        for (rij = 0; rij < 10; rij++) {
            for (kolom = 0; kolom < 10; kolom++) {
                if (speelveld[rij][kolom] == null) {
                    speelveld[rij][kolom] = new Vakje();
                }
            }
        }
        return speelveld;
    }

    /**
     * een makkelijke methode voor het maken van levels
     * @return speelveld
     */
    public static JComponent[][] level1() {
        double[][] coordinaten = {
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
        return generateLevel(coordinaten);
    }

    /**
     * een makkelijke methode voor het maken van levels
     * @return speelveld
     */
    public static JComponent[][] level2(){
        double[][] coordinaten = {
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
        return generateLevel(coordinaten);
    }

    /**
     * een makkelijke methode voor het maken van levels
     * @return speelveld
     */
    public static JComponent[][] level3(){
        double[][] coordinaten = {
                {4,1,1,1,1,1,0,0,0,0},
                {0,1,0,3.2,2.3,1,0,1,0,0},
                {0,3.1,0,1,3.2,1,0,1,1,0},
                {0,1,0,1,0,1,0,1,0,0},
                {2.1,1,0,3.3,0,1,0,1,2.2,1},
                {2.2,1,1,1,0,1,0,1,3.3,1},
                {3.2,1,0,0,0,1,3.1,1,0,0},
                {2.3,1,0,1,1,1,0,1,0,0},
                {1,0,0,0,3.1,0,0,1,0,0},
                {2.1,2.1,0,0,1,1,1,1,0,5},
        };
        return generateLevel(coordinaten);
    }

    /**
     * een methode voor het maken van random levels
     * @return speelveld
     */
    public static JComponent[][] level4(){
        ArrayList<Integer> randomList=new ArrayList<>();
        for(int teller = 0; teller < 100; teller++){
            nummer = intNummer.nextInt(4);
            randomList.add(nummer);
        }
        double[][] coordinaten = {
                {4,0,randomList.get(0),randomList.get(10),randomList.get(20),randomList.get(30),randomList.get(40),randomList.get(50),randomList.get(60),randomList.get(70)},
                {randomList.get(1),randomList.get(11),randomList.get(21),randomList.get(31),randomList.get(41),randomList.get(51),randomList.get(61),randomList.get(71),randomList.get(80),randomList.get(89)},
                {randomList.get(2),randomList.get(12),randomList.get(22),randomList.get(32),randomList.get(42),randomList.get(52),randomList.get(62),randomList.get(72),randomList.get(81),randomList.get(90)},
                {randomList.get(3),randomList.get(13),randomList.get(23),randomList.get(33),randomList.get(43),randomList.get(53),randomList.get(63),randomList.get(73),randomList.get(82),randomList.get(91)},
                {randomList.get(4),randomList.get(14),randomList.get(24),randomList.get(34),randomList.get(44),randomList.get(54),randomList.get(64),randomList.get(74),randomList.get(83),randomList.get(92)},
                {randomList.get(5),randomList.get(15),randomList.get(25),randomList.get(35),randomList.get(45),randomList.get(55),randomList.get(65),randomList.get(75),randomList.get(84),randomList.get(93)},
                {randomList.get(6),randomList.get(16),randomList.get(26),randomList.get(36),randomList.get(46),randomList.get(56),randomList.get(66),randomList.get(76),randomList.get(85),randomList.get(94)},
                {randomList.get(7),randomList.get(17),randomList.get(27),randomList.get(37),randomList.get(47),randomList.get(57),randomList.get(67),randomList.get(77),randomList.get(86),randomList.get(95)},
                {randomList.get(8),randomList.get(18),randomList.get(28),randomList.get(38),randomList.get(48),randomList.get(58),randomList.get(68),randomList.get(78),randomList.get(87),randomList.get(96)},
                {randomList.get(9),randomList.get(19),randomList.get(29),randomList.get(39),randomList.get(49),randomList.get(59),randomList.get(69),randomList.get(79),randomList.get(88),5},
        };
        return generateLevel(coordinaten);

    }

    /**
     * Methode die van een double array een speelveld maakt van een bepaald level
     * @param coordinaten
     * @return speelveld
     */
    public static JComponent[][] generateLevel(double[][] coordinaten) {
        JComponent [][] speelveld = Game.getSpeelveld();
        for (rij = 0; rij < 10; rij++) {
            for (kolom = 0; kolom < 10; kolom++) {
                if (coordinaten[rij][kolom] ==0) {
                    speelveld[rij][kolom] = new Vakje();
                }
                if (coordinaten[rij][kolom]==1) {
                    speelveld[rij][kolom] = new VasteMuur();
                }
                if (coordinaten[rij][kolom]>=2 && coordinaten[rij][kolom]<3) {
                    if (coordinaten[rij][kolom] == 2.1) {
                        speelveld[rij][kolom] = new Rasp(100);
                    }
                    if (coordinaten[rij][kolom] == 2.2) {
                        speelveld[rij][kolom] = new Rasp(200);
                    }
                    if (coordinaten[rij][kolom] == 2.3) {
                        speelveld[rij][kolom] = new Rasp(300);
                    }
                    if (coordinaten[rij][kolom] == 2) {
                        speelveld[rij][kolom] = new Rasp(300);
                    }
                }
                if (coordinaten[rij][kolom] >= 3 && coordinaten[rij][kolom] <4) {
                    if (coordinaten[rij][kolom] == 3.1) {
                        speelveld[rij][kolom] = new Kaas(100);
                    }
                    if (coordinaten[rij][kolom] == 3.2) {
                        speelveld[rij][kolom] = new Kaas(200);
                    }
                    if (coordinaten[rij][kolom] == 3.3){
                        speelveld[rij][kolom] = new Kaas(300);
                    }
                    if (coordinaten[rij][kolom] == 3){
                        speelveld[rij][kolom] = new Kaas(300);
                    }

                }
                if (coordinaten[rij][kolom] == 4){
                    speelveld[rij][kolom] = Game.getHoofdPersoon();
                }
                if (coordinaten[rij][kolom] == 5) {
                    speelveld[rij][kolom] = new Uitgang();
                }
            }
        }
        return speelveld;
    }

}