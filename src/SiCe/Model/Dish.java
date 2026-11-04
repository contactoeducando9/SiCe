package SiCe.Model;

import java.util.ArrayList;

public class Dish {
    ArrayList<Ingredient> ingrs = new ArrayList<Ingredient>();
    public String nombreDelPlatillo;

    public Dish () {
    }

    public Dish (String m) {
        this.nombreDelPlatillo = m;
        
    }

    public void dishIngrAdder (Ingredient n) {
        this.ingrs.add(n);
    }

    public void dishReload () {
        this.ingrs.clear();
    }
}
