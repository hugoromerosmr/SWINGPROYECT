package org.example.dao;

import org.example.model.Copias;
import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase CopiasDAO es responsable de realizar operaciones CRUD sobre la base de datos
 * relacionadas con la entidad {@link Copias}.
 */
public class CopiasDAO implements DAO<Copias> {

    private Connection connection;

    /**
     * Constructor de CopiasDAO.
     * Inicializa la conexión a la base de datos.
     */
    public CopiasDAO() {
        this.connection = connection;
    }

    /**
     * Obtiene una lista de copias asociadas a un usuario específico.
     *
     * @param idUsuario El ID del usuario para el cual se quieren obtener las copias.
     * @return Una lista de objetos {@link Copias} con la información obtenida de la base de datos.
     */
    public List<Copias> obtenerCopiasPorUsuario(int idUsuario) {
        List<Copias> copias = new ArrayList<>();
        String consulta = "SELECT Peliculas.titulo, Copias.estado, Copias.soporte, Peliculas.descripcion, Peliculas.director, Peliculas.ano " +  // Cambia 'año' por 'ano'
                "FROM Copias " +
                "JOIN Peliculas ON Copias.id_pelicula = Peliculas.id " +
                "WHERE Copias.id_usuario = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement ps = connection.prepareStatement(consulta)) {

            ps.setInt(1, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Copias copia = new Copias();
                    copia.setEstado(rs.getString("estado"));
                    copia.setSoporte(rs.getString("soporte"));

                    Pelicula pelicula = new Pelicula();
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDescripcion(rs.getString("descripcion"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAno(rs.getInt("ano"));

                    copia.setPelicula(pelicula);
                    copias.add(copia);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return copias;
    }

    /**
     * Recupera todas las copias almacenadas en la base de datos.
     *
     * @return Una lista vacía en esta implementación.
     */
    @Override
    public List<Copias> findAll() {
        return List.of();
    }

    /**
     * Busca una copia por su ID en la base de datos.
     *
     * @param id El ID de la copia que se desea buscar.
     * @return Un objeto {@link Copias} con los datos si se encuentra, de lo contrario null.
     */
    @Override
    public Copias findById(Integer id) {
        return null;
    }

    /**
     * Busca una película por su ID.
     *
     * @param id El ID de la película.
     * @return Un objeto {@link Pelicula} si se encuentra, de lo contrario null.
     */
    @Override
    public Pelicula findById(int id) {
        return null;
    }

    /**
     * Guarda un nuevo registro de una copia en la base de datos.
     *
     * @param copias El objeto {@link Copias} que se desea guardar.
     */
    @Override
    public void save(Copias copias) {
        // Implementación pendiente
    }

    /**
     * Actualiza un registro existente de una copia en la base de datos.
     *
     * @param copias El objeto {@link Copias} con la información actualizada.
     */
    @Override
    public void update(Copias copias) {
        // Implementación pendiente
    }

    /**
     * Elimina una copia de la base de datos por su ID.
     *
     * @param id El ID de la copia que se desea eliminar.
     */
    @Override
    public void delete(int id) {
        // Implementación pendiente
    }
}
