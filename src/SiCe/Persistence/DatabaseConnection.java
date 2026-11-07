package SiCe.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:sice.db";

    public static Connection getConnection() throws SQLException {

    Connection conexion = DriverManager.getConnection(URL);

    try (var instruccion = conexion.createStatement()) {
        instruccion.execute("PRAGMA foreign_keys = ON");
    }

    return conexion;
    }

}




