package SiCe.GUI.dietScanner;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import SiCe.Services.*;

public class ManuallyGUI extends JPanel{

//-----------Crear la mayoría de objetos que ocuparemos en todo el panel------------------------------------

    DietScannerActions actions = new DietScannerActions();    

    JPanel scanner; JPanel combos; JPanel dishPanel; JPanel dishButton;

    String [] columnas = {"","Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    String[][] datos = {
            {"Desayuno", "", "", "", "", "", "", ""},
            {"Colación", "", "", "", "", "", "", ""},
            {"Comida", "", "", "", "", "", "", ""},
            {"Colación", "", "", "", "", "", "", ""},
            {"Cena", "", "", "", "", "", "", ""}
        };
    public DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
    JPanel displayDiet;

    String[] Dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    public JComboBox<String> dy = new JComboBox<String>(Dias);
    String[] Comida = {"Desayuno", "1er Colación", "Comida", "2da Colación", "Cena"};
    public JComboBox<String> mealtime = new JComboBox<String>(Comida);

    JLabel dish;
    public DefaultComboBoxModel<String> platillos = new DefaultComboBoxModel<>();
    public JComboBox<String> comboPlatillos = new JComboBox<String>(platillos);
    JButton agregarPlatillo = new JButton("Nuevo"); 
    JLabel ingrN; public JTextField ingrNtxt = new JTextField(15); 
    JLabel amount; public JTextField amounttxt = new JTextField(15);
    String[] units = {"kg","gr", "ltrs", "ml","pz"};
    public JComboBox<String> unit = new JComboBox<String>(units);
    
    JButton ingr = new JButton("Agregar");

    JButton dishB;

//----------Constructor que llamaremos para diseñar el lector Manual---------------------------------------------------------------
    public ManuallyGUI () {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        gbc.gridy = 0;
        gbc.weighty = 0;
        add(scannerCreator(), gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;
        add(displayDietCreator(), gbc);

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

        dish = new JLabel("Nombre del platillo: ");
        ingrN = new JLabel("Ingrediente: "); 
        amount = new JLabel("Cantidad: "); 

        ingr.addActionListener(e -> {
          actions.agregarIngrediente(this);
        });

        agregarPlatillo.addActionListener(e -> {
            platillos.addElement(comboPlatillos.getSelectedItem().toString());
        });

        pgbc.gridx = 0;
        pgbc.gridy = 0;
        pgbc.weightx = 0;
        pgbc.weighty = 0;
        pgbc.gridwidth = 1;
        pgbc.gridheight = 1;
        dishPanel.add(dish, pgbc);

        comboPlatillos.setEditable(true);
        pgbc.gridx = 1;
        pgbc.weightx = 1;
        dishPanel.add(comboPlatillos, pgbc);

        pgbc.gridx = 2;
        pgbc.weightx = 0;
        dishPanel.add(agregarPlatillo, pgbc);

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
          actions.agregarPlatillo(this);
        });
        dishButton.add(dishB, BorderLayout.EAST);
        dishButton.setBorder(BorderFactory.createEmptyBorder(4, 5, 4, 5));
            

        combos.setBackground(new Color(170,204,203));
        dishPanel.setBackground(new Color(230,230,230));
        dishButton.setBackground(new Color(170,204,203));

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

    public JPanel displayDietCreator () {

        displayDiet = new JPanel();
        displayDiet.setLayout(new BorderLayout());
        JTable tabla = new JTable(modelo);

        //*************************Renderizador hecho con chatgpt*********************************************************************************************** */
class MiRenderizador extends JTextArea
                implements TableCellRenderer {

            public MiRenderizador() {
                setLineWrap(true);
                setWrapStyleWord(true);
                setOpaque(true);
            }

            @Override
            public Component getTableCellRendererComponent(
                    JTable tabla,
                    Object valor,
                    boolean seleccionado,
                    boolean tieneFoco,
                    int fila,
                    int columna) {

                setText(valor == null ? "" : valor.toString());

                if (seleccionado) {
                    setBackground(tabla.getSelectionBackground());
                    setForeground(tabla.getSelectionForeground());
                } else {
                    setBackground(tabla.getBackground());
                    setForeground(tabla.getForeground());
                }

                return this;
            }
        }

        // 4. Asignamos el renderizador a la tabla
        tabla.setDefaultRenderer(
            Object.class,
            new MiRenderizador()
        );

        // 5. Ajustamos manualmente la altura de las filas
        tabla.setRowHeight(170

        );


        //***************************************************************************************************************** */




        JScrollPane scrollPane = new JScrollPane(tabla);
        displayDiet.add(scrollPane, BorderLayout.CENTER);

        return displayDiet;
    }
}
