import javax.swing.*;
import java.awt.*;

public class Obstakel extends JComponent {
    private int waarde;
    private String waardeString;

    public Obstakel(int waarde){
        this.waarde = waarde;
    }

    public int getWaarde(){

        return waarde;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 80, 80);
        g.setColor(Color.BLACK);
        getWaarde();
        waardeString = Integer.toString(waarde);
        g.drawString(waardeString,10,90);
    }

}
