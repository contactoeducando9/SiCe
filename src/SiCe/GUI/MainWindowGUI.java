package SiCe.GUI;
import javax.swing.*;

import SiCe.GUI.authentication.LoginGUI;
import SiCe.GUI.mainPanel.MainPanelGUI;
import SiCe.GUI.authentication.AccountGUI;

import java.awt.*;


public class MainWindowGUI extends JFrame {

    AccountGUI okey =new AccountGUI(this);

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

        //se crean los JPanel correspondientes "llamando" (new) a un constructor (el único) que tiene de paramétro un objeto de la clase que 
        //que construye, y requiere ingresar esta misma instancia (this), para que muestra estos mismos paneles agregados 
        //a este objeto (ventana principal).
        contenedor.add(new LoginGUI(this), "LOGIN");
        contenedor.add(new MainPanelGUI(this), "PANEL");
        contenedor.add(new AccountGUI(this),"ACCOUNT");
        
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

