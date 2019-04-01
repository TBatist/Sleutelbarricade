import javax.swing.*;
import java.awt.*;

public class Obstakel extends JComponent {
    private int waarde;

    public Obstakel(int waarde){
        this.waarde = waarde;
    }

    public int getWaarde(){
        return waarde;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 80, 80);
    }

}
