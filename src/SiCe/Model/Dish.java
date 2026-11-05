package SiCe.Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Dish {
    ArrayList<Ingredient> ingrs = new ArrayList<Ingredient>();
    public String nombreDelPlatillo;
    String[] tiemposlot = {"Desayuno", "1er Colación", "Comida", "2da Colación", "Cena"};
    ArrayList<String> tiempos = new ArrayList<>(Arrays.asList(tiemposlot));
    String[] diasemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    ArrayList<String> diasSema = new ArrayList<>(Arrays.asList(diasemana));

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

    public String getLabel () {
        StringBuilder texto = new StringBuilder();

        texto.append(nombreDelPlatillo).append("\n\n");

        for (Ingredient ingrediente : ingrs) {

        texto.append("- ")
             .append(ingrediente.name)
             .append("\n");
        }

        return texto.toString();
    }

    public int getSlotMeal (String n) {
        int tiempo = tiempos.indexOf(n);
        return tiempo;
    }

    public int getDay (String n) {
        int dia = diasSema.indexOf(n)+1;
        return dia;
    }
}
