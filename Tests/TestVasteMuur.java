import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

public class TestVasteMuur {
    Hoofdpersoon hoofdpersoon = new Hoofdpersoon();

    @Test
    public void moveHoofdpersoonRightMuur(){
        JComponent before [][] = new JComponent[10][10];
        before[0][0] = hoofdpersoon;
        before[0][1] = new VasteMuur();
        before = Levels.fillSpeelveld(before);
        JComponent after [][] = before;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
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
        JComponent before [][] = new JComponent[10][10];
        before[0][1] = hoofdpersoon;
        before[0][0] = new VasteMuur();
        before = Levels.fillSpeelveld(before);
        JComponent after [][] = before;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
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
        JComponent before [][] = new JComponent[10][10];
        before[1][0] = hoofdpersoon;
        before[0][0] = new VasteMuur();
        before = Levels.fillSpeelveld(before);
        JComponent after [][] = before;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
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
        JComponent before [][] = new JComponent[10][10];
        before[0][0] = hoofdpersoon;
        before[1][0] = new VasteMuur();
        before = Levels.fillSpeelveld(before);
        JComponent after [][] = before;
        GUI.setSpeelveld(before);
        GUI.setHoofdPersoon(hoofdpersoon);
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
