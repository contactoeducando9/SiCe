package SiCe.GUI.dietScanner;

import java.awt.*;
import javax.swing.*;

public class ManuallyGUI extends JPanel{

//-----------Crear la mayoría de objetos que ocuparemos en todo el panel------------------------------------

    JPanel scanner; JPanel combos; JPanel dishPanel; JPanel dishButton;
    JPanel displayDiet;

    JComboBox<String> dy; String[] Dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    JComboBox<String> mealtime; String[] Comida = {"Desayuno", "1er colación", "Comida", "2da colación", "Cena"};

    JLabel dish; JTextField disntxt;
    JLabel ingrN; JTextField ingrNtxt; 
    JLabel amount; JTextField amounttxt;
    JComboBox<String> unit; String[] units = {"kg","gr", "ltrs", "ml","pz"};
    JButton ingr;

    JButton dishB;

//----------Constructor que llamaremos para diseñar el lector Manual---------------------------------------------------------------
    public ManuallyGUI () {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        displayDiet = new JPanel();
        displayDiet.setBackground(Color.BLUE);
        displayDiet.setBorder(
           BorderFactory.createCompoundBorder(
         BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK),
        BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        displayDiet.setVisible(true);

        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        gbc.gridy = 0;
        gbc.weighty = 0;
        add(scannerCreator(), gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;
        add(displayDiet, gbc);

        setVisible(true);
        
    }

    public JPanel scannerCreator () {
        scanner = new JPanel(new GridBagLayout());
        GridBagConstraints sgbc = new GridBagConstraints();

    //---Definiendo los paneles que iran dentro de scanner--------------------------------------------------------

        combos = new JPanel();
        combos.setLayout(new GridBagLayout());
        GridBagConstraints pgbc = new GridBagConstraints();
        dy = new JComboBox<String>(Dias); 
        mealtime = new JComboBox<String>(Comida); 

        pgbc.fill = GridBagConstraints. HORIZONTAL;
        pgbc.weightx = 1.0;
        pgbc.insets = new Insets(4, 5, 4, 5);

        pgbc.gridx = 0;
        pgbc.gridy = 0;
        pgbc.weighty = 0;
        pgbc.gridwidth = 1;
        pgbc.gridheight = 1;
        combos.add(dy, pgbc);

        pgbc.gridx = 1;
        pgbc.gridy = 0;
        pgbc.weighty = 1.0;
        pgbc.gridwidth = 1;
        pgbc.gridheight = 1;
        combos.add(mealtime, pgbc);
        




        dishPanel = new JPanel();
        dishPanel.setLayout(new GridBagLayout());

        dish = new JLabel("Nombre del platillo: "); disntxt = new JTextField(15);
        ingrN = new JLabel("Ingrediente: "); ingrNtxt = new JTextField(15);
        amount = new JLabel("Cantidad: "); amounttxt = new JTextField(15);
        unit = new JComboBox<String>(units); ingr = new JButton("Agregar");

        ingr.addActionListener(e -> {
          //¿aquí debo de poner el enlace al mecanismo para que de alguna manera los datos puestos en nombre de platillo
          //ingrediente y cantidad (y demas secciones) se guarder en un objeto dish?  ¿como lo hago, es correcto el enfoque?
        });
        pgbc.gridx = 0;
        pgbc.gridy = 0;
        pgbc.weightx = 0;
        pgbc.weighty = 0;
        pgbc.gridwidth = 1;
        pgbc.gridheight = 1;
        dishPanel.add(dish, pgbc);

        pgbc.gridx = 1;
        pgbc.weightx = 1;
        dishPanel.add(disntxt, pgbc);

        pgbc.gridx = 0;
        pgbc.gridy = 1;
        pgbc.weightx = 0;
        dishPanel.add(ingrN, pgbc);

        pgbc.gridx = 1;
        pgbc.weightx = 1;
        dishPanel.add(ingrNtxt, pgbc);

        pgbc.gridx = 2;
        pgbc.weightx = 0;
        dishPanel.add(amount, pgbc);

        pgbc.gridx = 3;
        pgbc.weightx = 1;
        dishPanel.add(amounttxt, pgbc);
        
        pgbc.gridx = 4;
        pgbc.weightx = 0;
        dishPanel.add(unit, pgbc);

        pgbc.gridx = 5;
        pgbc.gridy = 2;
        pgbc.gridwidth=GridBagConstraints.REMAINDER;
        pgbc.anchor = GridBagConstraints.EAST;
        pgbc.fill = GridBagConstraints.NONE;
        dishPanel.add(ingr, pgbc);







        dishButton = new JPanel();
        dishButton.setLayout(new BorderLayout());
        dishB = new JButton("Agregar platillo");

        dishB.addActionListener(e -> {
          //¿aquí debo de poner el enlace al mecanismo para que al ingresar agregar platillo se aguerde todo el platillo,
          //en el dia y tiempo de comida selecciónado? ¿como lo hago, es correcto el enfoque?
        });
        dishButton.add(dishB, BorderLayout.EAST);
        dishButton.setBorder(BorderFactory.createEmptyBorder(4, 5, 4, 5));
            

        combos.setBackground(Color.GREEN);
        dishPanel.setBackground(Color.GRAY);
        dishButton.setBackground(Color.YELLOW);

    //----Acomodando la distribución de los paneles para agregarlos a Scanner-----------------------------
        sgbc.gridx = 0;
        sgbc.fill = GridBagConstraints.BOTH;
        sgbc.weightx = 1.0;
        sgbc.gridwidth = 1;
        sgbc.gridheight = 1;

        sgbc.gridy = 0;
        sgbc.weighty = 0;
        scanner.add(combos, sgbc);

        sgbc.gridy = 1;
        sgbc.weighty = 2.0;
        scanner.add(dishPanel, sgbc);

        sgbc.gridy = 2;
        sgbc.weighty = 0;
        scanner.add(dishButton, sgbc);
        scanner.setVisible(true);
        return scanner;
    }
}
