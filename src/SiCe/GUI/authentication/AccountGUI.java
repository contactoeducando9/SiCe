package SiCe.GUI.authentication;

import javax.swing.*;
import java.awt.*;

import SiCe.GUI.MainWindowGUI;

public class AccountGUI extends JPanel {

    public AccountGUI (MainWindowGUI n) {
        JButton logout = new JButton("Log out");
        logout.setMaximumSize(new Dimension (100,40));

        logout.addActionListener(e -> {
          n.changePanel("LOGIN");
        });
        add(logout);
    }
    
}
