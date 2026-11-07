package SiCe.Repository;

import SiCe.Model.*;
import SiCe.Persistence.DatabaseConnection;

import java.sql.*;

public class WeeklyDietRepository {

    public void save(WeeklyDiet dieta) throws SQLException {

        if (dieta == null || dieta.name == null || dieta.name.isBlank()) {
            throw new IllegalArgumentException("La dieta necesita un nombre.");
        }

        if (dieta.id == null) {
            dieta.id = java.util.UUID.randomUUID().toString();
        }

        try (Connection conexion = DatabaseConnection.getConnection()) {

            conexion.setAutoCommit(false);

            try {
                // 1. Insertar dieta
                String sqlDieta = """
                    INSERT INTO WeeklyDiets (id, name)
                    VALUES (?, ?)
                    """;

                try (PreparedStatement ps = conexion.prepareStatement(sqlDieta)) {
                    ps.setString(1, dieta.id);
                    ps.setString(2, dieta.name);
                    ps.executeUpdate();
                }

                // 2. Recorrer días
                for (DietDay dia : dieta.diasDeLaSemana) {

                    long dayId = insertarDia(conexion, dia, dieta.id);

                    // 3. Recorrer tiempos de comida
                    for (MealSlot tiempo : dia.getTiempos()) {

                        Dish platillo = tiempo.getDish();

                        // No guardar tiempos sin platillo
                        if (platillo == null) {
                            continue;
                        }

                        long mealId = insertarTiempo(conexion, tiempo, dayId);

                        // 4. Insertar platillo
                        long dishId = insertarPlatillo(
                            conexion, platillo, mealId
                        );

                        // 5. Recorrer ingredientes
                        for (Ingredient ingrediente : platillo.getIngredientes()) {
                            insertarIngrediente(
                                conexion, ingrediente, dishId
                            );
                        }
                    }
                }

                // Confirmar todos los cambios
                conexion.commit();

            } catch (SQLException | RuntimeException e) {

                conexion.rollback();
                throw e;
            }
        }
    }


    private long insertarDia(
        Connection conexion, DietDay dia, String dietId
    ) throws SQLException {

        String sql = """
            INSERT INTO DietDays (weekly_diet_id, day_name)
            VALUES (?, ?)
            """;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, dietId);
            ps.setString(2, dia.getNombre());
            ps.executeUpdate();
        }

        return obtenerUltimoId(conexion);
    }


    private long insertarTiempo(
        Connection conexion, MealSlot tiempo, long dayId
    ) throws SQLException {

        String sql = """
            INSERT INTO MealSlots (diet_day_id, meal_name)
            VALUES (?, ?)
            """;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setLong(1, dayId);
            ps.setString(2, tiempo.getNombre());
            ps.executeUpdate();
        }

        return obtenerUltimoId(conexion);
    }


    private long insertarPlatillo(
        Connection conexion, Dish platillo, long mealId
    ) throws SQLException {

        String sql = """
            INSERT INTO Dishes (meal_slot_id, name)
            VALUES (?, ?)
            """;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setLong(1, mealId);
            ps.setString(2, platillo.getNombre());
            ps.executeUpdate();
        }

        return obtenerUltimoId(conexion);
    }


    private void insertarIngrediente(
        Connection conexion, Ingredient ingrediente, long dishId
    ) throws SQLException {

        String sql = """
            INSERT INTO Ingredients (dish_id, name, amount, unit)
            VALUES (?, ?, ?, ?)
            """;

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setLong(1, dishId);
            ps.setString(2, ingrediente.getName());
            ps.setDouble(3, ingrediente.getAmount());
            ps.setString(4, ingrediente.getUnit());
            ps.executeUpdate();
        }
    }


    private long obtenerUltimoId(Connection conexion) throws SQLException {

        String sql = "SELECT last_insert_rowid()";

        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getLong(1);
            }

            throw new SQLException("No se pudo obtener el ID generado.");
        }
    }
}