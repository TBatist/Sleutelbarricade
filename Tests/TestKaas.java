import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * Deze tests zijn om te test of de Hoofdpersoon een bepaalde Rasp oppakt, en vervolgens of de Hoofdpersoon zowel wel als niet
 * door de naastgelegen Kaas met dezelfde of een andere waarde heen gaat.
 * Eerst wordt er een speelveld gemaakt met een Hoofdpersoon, een Rasp met een bepaalde waarde, en een Kaas met dezelfe waarde
 * de Rasp. Daarna wordt de Hoofdpersoon naar de gewenste richting verplaatst. In de eerste vier tests wordt getest of de Rasp en
 * de Kaas zijn verdwenen en de Hoofdpersoon op de plek van de Kaas staat. In de laatste vier wordt getest of de Rasp is verdwenen,
 * de Hoofdpersoon op de plaatst van de Rasp staat en de Kaas op dezelde plek staat.
 */
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
        before = Level.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        after[0][2] = hoofdpersoon;
        after = Level.fillSpeelveld(after);
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
        before = Level.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        after[0][0] = hoofdpersoon;
        after = Level.fillSpeelveld(after);
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
        before = Level.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        after[0][0] = hoofdpersoon;
        after = Level.fillSpeelveld(after);
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
        before = Level.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        after[2][0] = hoofdpersoon;
        after = Level.fillSpeelveld(after);
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
        before = Level.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        after[0][1] = hoofdpersoon;
        after[0][2] = new Kaas(kaasWaardeFalse);
        after = Level.fillSpeelveld(after);
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
        before = Level.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        after[0][1] = hoofdpersoon;
        after[0][0] = new Kaas(kaasWaardeFalse);
        after = Level.fillSpeelveld(after);
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
        before = Level.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        after[1][0] = hoofdpersoon;
        after[0][0] = new Kaas(kaasWaardeFalse);
        after = Level.fillSpeelveld(after);
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
        before = Level.fillSpeelveld(before);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        after[1][0] = hoofdpersoon;
        after[2][0] = new Kaas(kaasWaardeFalse);
        after = Level.fillSpeelveld(after);
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De speelvelden zijn niet gelijk aan elkaar", result);
    }
}
