import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class TestKaas {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();
    JComponent before [][] = new JComponent[10][10];
    JComponent after [][] = new JComponent[10][10];
    int raspWaarde = 100;
    int kaasWaardeTrue = 100;
    int kaasWaardeFalse = 150;

    @Test
    public void moveHoofdpersoonRightKaasTrue(){
        before[0][0] = hoofdpersoon;
        before[0][1] = new Rasp(raspWaarde);
        before[0][2] = new Kaas(kaasWaardeTrue);
        before = Levels.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        after[0][2] = hoofdpersoon;
        after = Levels.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }

    @Test
    public void moveHoofdpersoonLeftKaasTrue(){
        before[0][2] = hoofdpersoon;
        before[0][1] = new Rasp(raspWaarde);
        before[0][0] = new Kaas(kaasWaardeTrue);
        before = Levels.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        after[0][0] = hoofdpersoon;
        after = Levels.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }

    @Test
    public void moveHoofdpersoonUpKaasTrue(){
        before[2][0] = hoofdpersoon;
        before[1][0] = new Rasp(raspWaarde);
        before[0][0] = new Kaas(kaasWaardeTrue);
        before = Levels.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        after[0][0] = hoofdpersoon;
        after = Levels.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }

    @Test
    public void moveHoofdpersoonDownKaasTrue(){
        before[0][0] = hoofdpersoon;
        before[1][0] = new Rasp(raspWaarde);
        before[2][0] = new Kaas(kaasWaardeTrue);
        before = Levels.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        after[2][0] = hoofdpersoon;
        after = Levels.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }

    @Test
    public void moveHoofdpersoonRightKaasFalse(){
        before[0][0] = hoofdpersoon;
        before[0][1] = new Rasp(raspWaarde);
        before[0][2] = new Kaas(kaasWaardeFalse);
        before = Levels.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        after[0][1] = hoofdpersoon;
        after[0][2] = new Kaas(kaasWaardeFalse);
        after = Levels.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }

    @Test
    public void moveHoofdpersoonLeftKaasFalse(){
        before[0][2] = hoofdpersoon;
        before[0][1] = new Rasp(raspWaarde);
        before[0][0] = new Kaas(kaasWaardeFalse);
        before = Levels.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        after[0][1] = hoofdpersoon;
        after[0][0] = new Kaas(kaasWaardeFalse);
        after = Levels.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }

    @Test
    public void moveHoofdpersoonUpKaasFalse(){
        before[2][0] = hoofdpersoon;
        before[1][0] = new Rasp(raspWaarde);
        before[0][0] = new Kaas(kaasWaardeFalse);
        before = Levels.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        after[1][0] = hoofdpersoon;
        after[0][0] = new Kaas(kaasWaardeFalse);
        after = Levels.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }

    @Test
    public void moveHoofdpersoonDownKaasFalse(){
        before[0][0] = hoofdpersoon;
        before[1][0] = new Rasp(raspWaarde);
        before[2][0] = new Kaas(kaasWaardeFalse);
        before = Levels.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        after[1][0] = hoofdpersoon;
        after[2][0] = new Kaas(kaasWaardeFalse);
        after = Levels.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }
}
