import javax.swing.*;
import java.util.ArrayList;

public class Vakje extends JComponent {
    private static int[] vakje;
    private static ArrayList<int[]> grid = new ArrayList<>();
    private int x;
    private int y;

    public Vakje(){

    }


    public static ArrayList<int[]> getVakjes(){
        return grid;
    }

    public void reset(){

    }
}
