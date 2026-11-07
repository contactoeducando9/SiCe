package SiCe.Test;

import SiCe.Model.*;
import SiCe.Repository.WeeklyDietRepository;
import SiCe.Persistence.DatabaseInitializer;

public class DatabaseConnectionTest {

    public static void main(String[] args) throws Exception {

        // Preparar la base de datos
        DatabaseInitializer.initialize();

        // Crear dieta
        WeeklyDiet dieta = new WeeklyDiet();
        dieta.name = "Prueba de persistencia";

        // Crear día
        DietDay lunes = new DietDay("Lunes");
        dieta.dietDayAdder(lunes);

        // Crear tiempo de comida
        MealSlot desayuno = new MealSlot("Desayuno");
        lunes.addMealSlot(desayuno);

        // Crear platillo
        Dish huevos = new Dish("Huevos revueltos");
        desayuno.setDish(huevos);

        // Agregar ingredientes
        huevos.dishIngrAdder(new Ingredient("Huevo", 2, "pz"));
        huevos.dishIngrAdder(new Ingredient("Leche", 100, "ml"));

        // Guardar dieta
        WeeklyDietRepository repositorio = new WeeklyDietRepository();
        repositorio.save(dieta);

        System.out.println("Dieta guardada correctamente.");
        System.out.println("ID: " + dieta.id);
    }
}