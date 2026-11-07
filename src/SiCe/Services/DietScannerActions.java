package SiCe.Services;

import SiCe.Model.*;
import SiCe.GUI.dietScanner.*;

//**********************estructura recomendada por chatGPT********************************************************* */
public class DietScannerActions {

    public WeeklyDiet dietaActual = new WeeklyDiet();
    Dish borrador;

    public void agregarIngrediente (ManuallyGUI gui) {

        String nombre = gui.ingrNtxt.getText();
        double cantidad = Double.parseDouble(gui.amounttxt.getText());
        String unidad = gui.unit.getSelectedItem().toString();
 
        Ingredient nuevo = new Ingredient(nombre, cantidad, unidad);

        if (borrador == null) {
        borrador = new Dish(gui.comboPlatillos.getSelectedItem().toString());
        }

        borrador.dishIngrAdder(nuevo);

        gui.ingrNtxt.setText("");
        gui.amounttxt.setText("");
    }
    
    public void agregarPlatillo (ManuallyGUI gui) {
        DietDay day;
        MealSlot meal;

        if (borrador != null) {
            String dia = gui.dy.getSelectedItem().toString();
            String tiempo = gui.mealtime.getSelectedItem().toString();

            day = dietaActual.searchDay(dia);
            if (day == null) {
                day = new DietDay(dia);
                dietaActual.dietDayAdder(day);
            }
            
            meal = day.searchMealSlot(tiempo);
            if (meal == null) {
                meal = new MealSlot(tiempo);
                day.addMealSlot(meal);
            }

            meal.setDish(borrador);

            String nombre = borrador.nombreDelPlatillo;

                if (gui.platillos.getIndexOf(nombre) == -1) {
                    gui.platillos.addElement(nombre);
                }

            gui.modelo.setValueAt(borrador.getLabel(), borrador.getSlotMeal(tiempo), borrador.getDay(dia));

            borrador = null;

        }
    }
}