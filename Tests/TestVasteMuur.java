import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

/**
 * Deze tests kijken of de Hoofdpersoon niet verplaatst wordt wanneer het naast een VasteMuur staat.
 * Daarvoor wordt eerst een speelveld gemaakt met daarin een Hoofdpersoon en een VasteMuur op de plek waar de Hoofdpersoon heen wilt.
 * Dan wordt geprobeert de Hoofdpersoon naar de gewenste richting te verplaatsen. Omdat dat niet zou moeten, wordt het uiteindelijke
 * speelveld vergeleken met het speelveld wat ervoor gemaakt was.
 */
public class TestVasteMuur {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();
    JComponent before [][] = new JComponent[10][10];

    @Test
    public void moveHoofdpersoonRightMuur(){
        before[0][0] = hoofdpersoon;
        before[0][1] = new VasteMuur();
        before = Level.fillSpeelveld(before);
        JComponent after [][] = before;
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('r'),'r');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan niet naar rechts verplaatsen als er een muur staat", result);
    }

    @Test
    public void moveHoofdpersoonLeftMuur(){
        before[0][1] = hoofdpersoon;
        before[0][0] = new VasteMuur();
        before = Level.fillSpeelveld(before);
        JComponent after [][] = before;
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('l'),'l');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan niet naar links verplaatsen als er een muur staat", result);
    }

    @Test
    public void moveHoofdpersoonUpMuur(){
        before[1][0] = hoofdpersoon;
        before[0][0] = new VasteMuur();
        before = Level.fillSpeelveld(before);
        JComponent after [][] = before;
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('u'),'u');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan niet naar rechts verplaatsen als er een muur staat", result);
    }

    @Test
    public void moveHoofdpersoonDownMuur(){
        before[0][0] = hoofdpersoon;
        before[1][0] = new VasteMuur();
        before = Level.fillSpeelveld(before);
        JComponent after [][] = before;
        Game.setSpeelveld(before);
        Game.setHoofdPersoon(hoofdpersoon);
        Hoofdpersoon.moveHoofdpersoon(Hoofdpersoon.surrounding('d'),'d');
        boolean result = true;
        for (int i = 0; i < before.length; i++) {
            if (!(before[0][i].getClass() == after[0][i].getClass())) {
                result = false;
            }
        }
        assertTrue("De hoofdpersoon kan niet naar rechts verplaatsen als er een muur staat", result);
    }
}
