import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * Deze tests kijken of de Hoofdpersoon een Rasp op kan pakken. Daarna wordt getest of de waarde van de Rasp die de Hoofdpersoon
 * opgepakt zou moeten hebben hetzelde is als de waarde van de Rasp. Dit wordt getest door eerst een speelveld te maken.
 * Daarna worden er een Hoofdpersoon en een Rasp met een bepaalde waarde in gezet. Dan wordt de Hoofdpersoon de gewenste richting
 * op verplaatst, en daarna wordt er getest of de waarde van de Rasp die de Hoofdpersoon heeft hetzelfde is als de waarde van de
 * Rasp die van te voren in het speelveld is geplaatst.
 */
public class TestRasp {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();
    JComponent before [][] = new JComponent[10][10];
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
