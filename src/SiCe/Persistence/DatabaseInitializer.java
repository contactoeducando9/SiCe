package SiCe.Persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() throws SQLException {

        String weeklyDiets = """
            CREATE TABLE IF NOT EXISTS WeeklyDiets (
                id TEXT PRIMARY KEY,
                name TEXT NOT NULL,
                created_at TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP
            );
            """;

        String dietDays = """
            CREATE TABLE IF NOT EXISTS DietDays (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                weekly_diet_id TEXT NOT NULL,
                day_name TEXT NOT NULL,

                FOREIGN KEY (weekly_diet_id)
                    REFERENCES WeeklyDiets(id)
                    ON DELETE CASCADE,

                UNIQUE (weekly_diet_id, day_name)
            );
            """;

        String mealSlots = """
            CREATE TABLE IF NOT EXISTS MealSlots (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                diet_day_id INTEGER NOT NULL,
                meal_name TEXT NOT NULL,

                FOREIGN KEY (diet_day_id)
                    REFERENCES DietDays(id)
                    ON DELETE CASCADE,

                UNIQUE (diet_day_id, meal_name)
            );
            """;

        String dishes = """
            CREATE TABLE IF NOT EXISTS Dishes (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                meal_slot_id INTEGER NOT NULL UNIQUE,
                name TEXT NOT NULL,

                FOREIGN KEY (meal_slot_id)
                    REFERENCES MealSlots(id)
                    ON DELETE CASCADE
            );
            """;

        String ingredients = """
            CREATE TABLE IF NOT EXISTS Ingredients (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                dish_id INTEGER NOT NULL,
                name TEXT NOT NULL,
                amount REAL NOT NULL CHECK (amount > 0),
                unit TEXT NOT NULL,

                FOREIGN KEY (dish_id)
                    REFERENCES Dishes(id)
                    ON DELETE CASCADE
            );
            """;

        try (Connection conexion = DatabaseConnection.getConnection();
             Statement instruccion = conexion.createStatement()) {

            instruccion.executeUpdate(weeklyDiets);
            instruccion.executeUpdate(dietDays);
            instruccion.executeUpdate(mealSlots);
            instruccion.executeUpdate(dishes);
            instruccion.executeUpdate(ingredients);
        }
    }
}