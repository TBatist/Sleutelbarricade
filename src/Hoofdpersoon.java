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

    public boolean checkWaarde() {
        if(Schaar.getWaarde() < Obstakel.getWaarde()){
            return true;
        }
        else{return false;}
    }

    public ArrayList<Schaar> getAantalSleutels() {
        return aantalSleutels;
    }

    public boolean hasKeys() {
        return (aantalSleutels.size() > 0);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(0, 0, 80, 80);
    }

}