package SiCe.GUI.authentication;
import javax.swing.*;

import SiCe.GUI.MainWindowGUI;



public class LoginGUI extends JPanel {

    public LoginGUI (MainWindowGUI n) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel log = new JLabel("Login");
        JButton main = new JButton("ingresar");

        log
        .setAlignmentX(CENTER_ALIGNMENT);
        main
        .setAlignmentX(CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(log);
        add(Box.createVerticalStrut(10));
        add(main);
        add(Box.createVerticalGlue());
        
        main.addActionListener(e -> {
          n.changePanel("PANEL");
        });
    }
}
