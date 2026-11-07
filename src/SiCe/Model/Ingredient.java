package SiCe.Model;

public class Ingredient {
    String name;
    double amount;
    String unit;

    public Ingredient () {
    }

    public Ingredient (String n, double a, String u) {
        this.name = n;
        this.amount = a;
        this.unit = u;
    }

    public String getName() {
    return name;
    }

    public double getAmount() {
    return amount;
    }

    public String getUnit() {
    return unit;
    }
}
