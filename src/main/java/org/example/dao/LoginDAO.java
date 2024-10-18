package org.example.dao;

import org.example.model.Login;
import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * La clase LoginDAO es responsable de realizar operaciones CRUD y autenticación de usuarios
 * en la base de datos, específicamente para la entidad {@link Login}.
 */
public class LoginDAO implements DAO<Login> {

    private Connection connection;

    /**
     * Constructor de LoginDAO.
     * Inicializa el DAO con una conexión a la base de datos.
     *
     * @param connection La conexión a la base de datos.
     */
    public LoginDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Busca un registro de login por su ID.
     *
     * @param id El ID del registro a buscar.
     * @return Siempre devuelve null en esta implementación.
     */
    @Override
    public Login findById(Integer id) {
        return null;
    }

    /**
     * Busca una película por su ID.
     *
     * @param id El ID de la película.
     * @return Siempre devuelve null en esta implementación.
     */
    @Override
    public Pelicula findById(int id) {
        return null;
    }

    /**
     * Recupera todos los registros de login de la base de datos.
     *
     * @return Siempre devuelve null en esta implementación.
     */
    @Override
    public List<Login> findAll() {
        return null;
    }

    /**
     * Guarda un nuevo registro de login en la base de datos.
     *
     * @param login El objeto {@link Login} que se desea guardar.
     */
    @Override
    public void save(Login login) {
        // Implementación pendiente
    }

    /**
     * Actualiza un registro de login existente en la base de datos.
     *
     * @param login El objeto {@link Login} con la información actualizada.
     */
    @Override
    public void update(Login login) {
        // Implementación pendiente
    }

    /**
     * Elimina un registro de login por su ID en la base de datos.
     *
     * @param id El ID del registro a eliminar.
     */
    @Override
    public void delete(int id) {
        // Implementación pendiente
    }

    /**
     * Autentica a un usuario en la base de datos verificando su nombre de usuario y contraseña.
     *
     * @param nombreUsuario El nombre de usuario ingresado.
     * @param contrasena La contraseña ingresada.
     * @return Un objeto {@link Login} si el nombre de usuario y la contraseña son correctos, de lo contrario null.
     */
    public Login obtenerUsuario(String nombreUsuario, String contrasena) {
        Login usuario = null;
        String consulta = "SELECT * FROM Usuarios WHERE nombre_usuario = ? AND contraseña = ?";
        try (PreparedStatement ps = connection.prepareStatement(consulta)) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Login(
                            rs.getInt("id"),
                            rs.getString("nombre_usuario"),
                            rs.getString("contraseña")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
