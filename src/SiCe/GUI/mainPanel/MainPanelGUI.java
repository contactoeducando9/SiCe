package SiCe.GUI.mainPanel;

import javax.swing.*;
import java.awt.*;

import SiCe.GUI.MainWindowGUI;
import SiCe.GUI.dietScanner.DietScannerGUI;
import SiCe.GUI.authentication.AccountGUI;

public class MainPanelGUI extends JPanel {

    private final JPanel sidebar;
    private final JPanel contentPanel;
    private final CardLayout cardLayout;
    JPanel topBar;


    public MainPanelGUI(MainWindowGUI n){
        setLayout(new BorderLayout());
        
        topBar = createTopBar();
        sidebar = createSidebar();

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(new HomeGUI(), "HOME");
        contentPanel.add(new DietScannerGUI(), "SCANNER");
        contentPanel.add(new AccountGUI(n), "ACCOUNT");

        JPanel mainArea = new JPanel(new BorderLayout());
        mainArea.add(sidebar, BorderLayout.WEST);
        mainArea.add(contentPanel, BorderLayout.CENTER);

        add(topBar, BorderLayout.NORTH);
        add(mainArea, BorderLayout.CENTER);
    }

    //Métodos auxiliares para darle el cuerpo al constructor del MainPanelGUI

    public JPanel createSidebar(){ 
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(new Color(200, 235, 235));
        panel.setPreferredSize(new Dimension(190, 0));
        panel.setBorder(
           BorderFactory.createCompoundBorder(
         BorderFactory.createMatteBorder(0, 0, 0, 2, Color.GRAY),
        BorderFactory.createEmptyBorder(10, 8, 10, 8)
        ));

        JButton homeButton = new JButton("Inicio");
        JButton dietButton = new JButton("Lector de dieta");
        JButton account = new JButton("Perfil");

        // Mantener los botones alineados y al ancho del menú
        homeButton.setAlignmentX(LEFT_ALIGNMENT);
        dietButton.setAlignmentX(LEFT_ALIGNMENT);
        account.setAlignmentX(LEFT_ALIGNMENT);

        homeButton.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 40)
        );
        dietButton.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 40)
        );
        account.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 40)
        );

        homeButton.addActionListener(e ->
            cardLayout.show(contentPanel, "HOME")
        );

        dietButton.addActionListener(e ->
            cardLayout.show(contentPanel, "SCANNER")
        );
        account.addActionListener(e ->
            cardLayout.show(contentPanel, "ACCOUNT")
        );

        panel.add(homeButton);
        panel.add(Box.createVerticalStrut(8));
        panel.add(dietButton);
        panel.add(Box.createVerticalGlue());
        panel.add(account);

        return panel;
    }

    public JPanel createTopBar () {
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton menuButton = new JButton("☰");
        JLabel title = new JLabel("SiCe");

        menuButton.addActionListener(e -> {
            sidebar.setVisible(!sidebar.isVisible());

            revalidate();
            repaint();
        });

        topBar.add(menuButton);
        topBar.add(title);

        return topBar;
    }

}

    
