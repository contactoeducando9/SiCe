package SiCe.Model;

import java.util.ArrayList;

public class Dish {
    ArrayList<Ingredient> ingrs;
    String mealtime;

    public Dish () {
    }

    public Dish (ArrayList<Ingredient> n, String m) {
        this.ingrs = n;
        this.mealtime = m;
    }

    public void dishIngrAdder (Ingredient n) {
        this.ingrs.add(n);
    }
}
