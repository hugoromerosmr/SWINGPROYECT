package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La clase JDBC proporciona una conexión a la base de datos utilizando el controlador MySQL.
 * Implementa un método estático para obtener una conexión a la base de datos con los
 * parámetros especificados en las constantes de clase.
 */
public class JDBC {

    // Constantes de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/retoconjunto";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    /**
     * Obtiene una conexión a la base de datos MySQL utilizando los parámetros de conexión
     * definidos en las constantes URL, USER y PASSWORD.
     *
     * @return Un objeto {@link Connection} para interactuar con la base de datos.
     * @throws RuntimeException Si ocurre un error al intentar establecer la conexión.
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
