package SiCe.Model;

public class MealSlot {

    String nombre;
    public Dish dish;

    public MealSlot (String n) {
        this.nombre = n;
    }

    public void setDish (Dish n) {
        this.dish = n;
    }

    public String getNombre() {
    return nombre;
    }

    public Dish getDish() {
    return dish;
    }

} 


