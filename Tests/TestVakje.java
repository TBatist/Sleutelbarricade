import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

public class TestVakje {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();
    JComponent before [][] = new JComponent[10][10];
    JComponent after [][] = new JComponent[10][10];

    @Test
    public void moveHoofdpersoonRightVakje(){
        before[0][0] = hoofdpersoon;
        before = Levels.fillSpeelveld(before);
        after[0][1] = new Hoofdpersoon();
        after = Levels.fillSpeelveld(after);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'),'r');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan naar rechts worden verplaatst als dat vak niks bevat", result);
    }

    @Test
    public void moveHoofdpersoonLeftVakje(){
        before[0][1] = hoofdpersoon;
        before = Levels.fillSpeelveld(before);
        after[0][0] = new Hoofdpersoon();
        after = Levels.fillSpeelveld(after);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'),'l');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan naar links worden verplaatst als dat vak niks bevat", result);
    }

    @Test
    public void moveHoofdpersoonUpVakje(){
        before[1][0] = hoofdpersoon;
        before = Levels.fillSpeelveld(before);
        after[0][0] = new Hoofdpersoon();
        after = Levels.fillSpeelveld(after);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'),'u');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan naar boven worden verplaatst als dat vak niks bevat", result);
    }

    @Test
    public void moveHoofdpersoonDownVakje(){
        before[0][0] = hoofdpersoon;
        before = Levels.fillSpeelveld(before);
        after[1][0] = new Hoofdpersoon();
        after = Levels.fillSpeelveld(after);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'),'d');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan naar beneden worden verplaatst als dat vak niks bevat", result);
    }
}
