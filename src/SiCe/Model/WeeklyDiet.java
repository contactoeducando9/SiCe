package SiCe.Model;

import java.util.ArrayList;

public class WeeklyDiet {
    ArrayList<DietDay> diasDeLaSemana = new ArrayList<DietDay>();

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
}
