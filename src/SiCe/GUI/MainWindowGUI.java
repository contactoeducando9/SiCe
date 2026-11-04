package SiCe.GUI;
import javax.swing.*;

import SiCe.GUI.authentication.LoginGUI;
import SiCe.GUI.mainPanel.MainPanelGUI;

import java.awt.*;

public class MainWindowGUI extends JFrame {

    MainPanelGUI mainPanelGUI = new MainPanelGUI(this);
    LoginGUI loginGUI = new LoginGUI(this);

    private JPanel contenedor;
    private CardLayout layout;

    //Constructor de la ventana principal
    public MainWindowGUI () {
        setSize(800,600);
        setMinimumSize(new Dimension(800,600));
        setTitle("SiCe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layout = new CardLayout();
        contenedor = new JPanel(layout);

        contenedor.add(loginGUI, "LOGIN");
        contenedor.add(mainPanelGUI, "PANEL");
        
        add(contenedor);

        layout.show(contenedor, "LOGIN");
    }

    //es el método que se utiliza en los ActionListener de los botones para mostrar el respectivo JPanel.
    public void changePanel (String n){
        layout.show(contenedor, n);
    }

        //El método main que inicia el programa creando un objeto de la clase de MainWindowGUI, sigo sin entender el 
        //SwingUtilities.invokeLater
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindowGUI ventana = new MainWindowGUI();
            ventana.setVisible(true);
        });
    }
}

