import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class TestRasp {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();
    JComponent before [][] = new JComponent[10][10];
    JComponent after [][] = new JComponent[10][10];
    int raspWaarde = 100;

    @Test
    public void moveHoofdpersoonRightRasp(){
        before[0][0] = hoofdpersoon;
        before[0][1] = new Rasp(raspWaarde);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'), 'r');
        assertEquals("De waarde is niet gelijk aan de waarde van de kaas", hoofdpersoon.getRaspWaarde(), raspWaarde);
    }

    @Test
    public void moveHoofdpersoonLeftRasp(){
        before[0][1] = hoofdpersoon;
        before[0][0] = new Rasp(raspWaarde);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'), 'l');
        assertEquals("De waarde is niet gelijk aan de waarde van de kaas", hoofdpersoon.getRaspWaarde(), raspWaarde);
    }

    @Test
    public void moveHoofdpersoonUpRasp(){
        before[1][0] = hoofdpersoon;
        before[0][0] = new Rasp(raspWaarde);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'), 'u');
        assertEquals("De waarde is niet gelijk aan de waarde van de kaas", hoofdpersoon.getRaspWaarde(), raspWaarde);
    }

    @Test
    public void moveHoofdpersoonDownRasp(){
        before[0][0] = hoofdpersoon;
        before[1][0] = new Rasp(raspWaarde);
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'), 'd');
        assertEquals("De waarde is niet gelijk aan de waarde van de kaas", hoofdpersoon.getRaspWaarde(), raspWaarde);
    }
}
