import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Hoofdpersoon extends JComponent {
    private ArrayList<Schaar> aantalSleutels;

    public Hoofdpersoon() {
        aantalSleutels = new ArrayList<>();
    }

    public void knippen() {

    }

    public static void lopen(JComponent[] speelveld) {


        //GUI.setSpeelveld(speelveld);

    }

    public ArrayList<Schaar> getAantalSleutels() {
        return aantalSleutels;
    }

    public boolean hasKeys() {
        return (aantalSleutels.size() > 0);
    }

    public void paintComponent(Graphics g) {
        Border border = BorderFactory.createLineBorder(Color.black);
        //componentHoofdpersoon.setBorder(border);
        g.setColor(Color.RED);
        g.fillOval(0, 0, 80, 80);
    }


}