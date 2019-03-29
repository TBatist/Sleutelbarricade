import javax.swing.*;
import java.awt.*;

public class VasteMuur extends JComponent {


    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(0,0,80,80);
    }

}
