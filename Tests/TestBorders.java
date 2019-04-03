import org.junit.Test;

import javax.swing.*;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestBorders {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();
    JComponent[][] before = new JComponent[10][10];
    JComponent[][] after = new JComponent[10][10];

    @Test
    public void moveHoofdpersoonRightBorder () {
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
    public void moveHoofdpersoonLeftBorder () {
        before[0][0] = hoofdpersoon;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        after[0][0] = hoofdpersoon;
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!Arrays.equals(before[i], after[i])) {
                result = false;
            }
        }
        assertTrue("Het speelveld blijft gelijk als de Hoofdpersoon tegen de muur staat", result);
    }

    @Test
    public void moveHoofdpersoonUpBorder () {
        before[0][0] = hoofdpersoon;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        after[0][0] = hoofdpersoon;
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!Arrays.equals(before[i], after[i])) {
                result = false;
            }
        }
        assertTrue("Het speelveld blijft gelijk als de Hoofdpersoon tegen de muur staat", result);
    }

    @Test
    public void moveHoofdpersoonDownBorder () {
        before[9][0] = hoofdpersoon;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        after[9][0] = hoofdpersoon;
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!Arrays.equals(before[i], after[i])) {
                result = false;
            }
        }
        assertTrue("Het speelveld blijft gelijk als de Hoofdpersoon tegen de muur staat", result);
    }
}