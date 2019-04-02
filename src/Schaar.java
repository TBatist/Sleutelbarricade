import javax.swing.*;
import java.awt.*;

public class Schaar extends JComponent {
    private int waarde;
    private String waardeString;

    public Schaar(int waarde){
        this.waarde = waarde;
    }

    public int getWaarde(){
        return waarde;
    }

    public void setWaarde(int waarde){
        this.waarde = waarde;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 80, 80);
        getWaarde();
        waardeString = Integer.toString(waarde);
        g.setColor(Color.BLACK);
        g.drawString(waardeString, 10, 90);
    }
}
