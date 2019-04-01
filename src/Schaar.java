import javax.swing.*;
import java.awt.*;

public class Schaar extends JComponent {
    private int waarde;

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
    }
}
