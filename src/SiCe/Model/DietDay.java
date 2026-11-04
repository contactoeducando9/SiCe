package SiCe.Model;

import java.util.ArrayList;

public class DietDay {
    ArrayList<MealSlot> tiempos = new ArrayList<MealSlot>();
    String diaDeLaSemana;

    public DietDay (String n) {
        this.diaDeLaSemana = n;
    }

    public void addMealSlot (MealSlot n) {
        this.tiempos.add(n);
    }

    public MealSlot searchMealSlot (String n) {
        for (MealSlot m : tiempos){
            if (m.nombre == n) {
                return m;
            }
        }
        return null;
    }
    
}
