package org.example.dao;

import org.example.dao.DAO;
import org.example.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase PeliculaDAO es responsable de realizar operaciones CRUD sobre la base de datos
 * relacionadas con la entidad {@link Pelicula}.
 */
public class PeliculaDAO implements DAO<Pelicula> {

    private Connection connection;

    /**
     * Constructor de PeliculaDAO.
     * Inicializa el DAO con una conexión a la base de datos.
     *
     * @param connection La conexión a la base de datos.
     */
    public PeliculaDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Recupera todas las películas almacenadas en la base de datos.
     *
     * @return Una lista de objetos {@link Pelicula} con la información obtenida de la base de datos.
     */
    @Override
    public List<Pelicula> findAll() {
        List<Pelicula> peliculas = new ArrayList<>();
        String consulta = "SELECT * FROM Peliculas";
        try (PreparedStatement ps = connection.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getInt("año"),
                        rs.getString("descripcion"),
                        rs.getString("director")
                );
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    /**
     * Busca una película por su ID en la base de datos.
     *
     * @param id El ID de la película que se desea buscar.
     * @return Un objeto {@link Pelicula} con los datos si se encuentra, de lo contrario null.
     */
    @Override
    public Pelicula findById(Integer id) {
        Pelicula pelicula = null;
        String consulta = "SELECT * FROM Peliculas WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(consulta)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pelicula = new Pelicula(
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("genero"),
                            rs.getInt("año"),
                            rs.getString("descripcion"),
                            rs.getString("director")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pelicula;
    }

    /**
     * Busca una película por su ID. Este método está actualmente sin implementar.
     *
     * @param id El ID de la película que se desea buscar.
     * @return Siempre devuelve null en esta implementación.
     */
    @Override
    public Pelicula findById(int id) {
        return null;
    }

    /**
     * Guarda un nuevo registro de película en la base de datos.
     *
     * @param pelicula El objeto {@link Pelicula} que se desea guardar.
     */
    public void save(Pelicula pelicula) {
        // Implementación pendiente
    }

    /**
     * Actualiza un registro de película existente en la base de datos.
     *
     * @param pelicula El objeto {@link Pelicula} con la información actualizada.
     */
    @Override
    public void update(Pelicula pelicula) {
        // Implementación pendiente
    }

    /**
     * Elimina una película de la base de datos por su ID.
     *
     * @param id El ID de la película que se desea eliminar.
     */
    @Override
    public void delete(int id) {
        // Implementación pendiente
    }
}
