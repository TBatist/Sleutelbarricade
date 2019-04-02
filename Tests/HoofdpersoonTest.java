import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class HoofdpersoonTest {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();

    @Test
    public void moveHoofdpersoonRightBorder() {
        Vakje before [][] = new Vakje[1][10];
        Vakje after [][] = new Vakje[1][10];
        before[0][9] = hoofdpersoon;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        after[0][9] = hoofdpersoon;
        assertEquals("Het speelveld blijft gelijk als de Hoofdpersoon tegen de muur staat", after, before);
    }

    @Test
    public void moveHoofdpersoonRightVakje(){
        Vakje before [][] = new Vakje[1][2];
        Vakje after [][] = new Vakje[1][2];
        before[0][0] = hoofdpersoon;
        after[0][1] = hoofdpersoon;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'),'r');
        assertEquals("De hoofdpersoon kan naar rechts worden verplaatst als dat vak niks bevat", after, before);
    }
}