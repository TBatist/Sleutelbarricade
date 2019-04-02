import org.junit.Test;

import javax.swing.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HoofdpersoonTest {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();

    @Test
    public void moveHoofdpersoonRightBorder() {
        JComponent[][] before = new JComponent[1][10];
        JComponent[][] after = new JComponent[1][10];
        before[0][9] = hoofdpersoon;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        after[0][9] = hoofdpersoon;
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!Arrays.equals(before[i], after[i])) {
                result = false;
            }
        }
        assertTrue("Het speelveld blijft gelijk als de Hoofdpersoon tegen de muur staat", result);

    }

    @Test
    public void moveHoofdpersoonRightVakje(){
        JComponent before [][] = new JComponent[1][2];
        JComponent after [][] = new JComponent[1][2];
        before[0][0] = hoofdpersoon;
        before[0][1] = new Vakje();
        after[0][1] = new Hoofdpersoon();
        after[0][0] = new Vakje();
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'),'r');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan naar rechts worden verplaatst als dat vak niks bevat", result);
        //assertEquals("De hoofdpersoon kan naar rechts worden verplaatst als dat vak niks bevat", true, result);
    }
}