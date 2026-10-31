package SiCe.GUI.dietScanner;
import javax.swing.*;
import java.awt.*;



public class DietScannerGUI extends JPanel {

    public DietScannerGUI() {
       setLayout(new BorderLayout());

        add(new ManuallyGUI(), BorderLayout.CENTER);
    }
}
