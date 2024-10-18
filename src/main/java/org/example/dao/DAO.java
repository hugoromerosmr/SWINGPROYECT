package org.example.dao;

import org.example.model.Pelicula;

import java.util.List;

/**
 * La interfaz DAO define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * genéricas que pueden ser implementadas por cualquier clase que maneje el acceso a la base de datos.
 * Esta interfaz es genérica y puede utilizarse para manejar cualquier tipo de entidad.
 *
 * @param <T> El tipo de entidad que la clase que implemente esta interfaz manejará.
 */
public interface DAO<T> {

    /**
     * Obtiene una lista de todas las entidades almacenadas en la base de datos.
     *
     * @return Una lista de todas las entidades de tipo {@code T}.
     */
    public List<T> findAll();

    /**
     * Busca una entidad por su ID.
     *
     * @param id El ID de la entidad que se desea buscar.
     * @return La entidad de tipo {@code T} si se encuentra, de lo contrario null.
     */
    public T findById(Integer id);

    /**
     * Busca una película por su ID.
     * Este método está específico para la entidad {@link Pelicula}.
     *
     * @param id El ID de la película que se desea buscar.
     * @return Un objeto {@link Pelicula} si se encuentra, de lo contrario null.
     */
    Pelicula findById(int id);

    /**
     * Guarda una nueva entidad en la base de datos.
     *
     * @param t La entidad de tipo {@code T} que se desea guardar.
     */
    public void save(T t);

    /**
     * Actualiza una entidad existente en la base de datos.
     *
     * @param t La entidad de tipo {@code T} con la información actualizada.
     */
    public void update(T t);

    /**
     * Elimina una entidad de la base de datos por su ID.
     *
     * @param id El ID de la entidad que se desea eliminar.
     */
    public void delete(int id);
}
