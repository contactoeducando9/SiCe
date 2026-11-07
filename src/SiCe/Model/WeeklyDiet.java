package SiCe.Model;

import java.util.ArrayList;

public class WeeklyDiet {
    public String id;
    public String name;
    public ArrayList<DietDay> diasDeLaSemana = new ArrayList<DietDay>();

    public void dietDayAdder (DietDay n) {
        diasDeLaSemana.add(n);        
    }

    public DietDay searchDay (String n) {
        for (DietDay m : diasDeLaSemana){
            if (m.diaDeLaSemana.equals(n)) {
                return m;
            }
        }
        return null;
    }

    public int getDaysAmount() {
        return diasDeLaSemana.size();
    }
}
