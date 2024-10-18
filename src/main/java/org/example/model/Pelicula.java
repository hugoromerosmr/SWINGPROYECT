package org.example.model;

import lombok.Data;

/**
 * La clase Pelicula representa una película almacenada en el sistema.
 * Contiene información básica sobre la película, como el título, descripción, año de estreno, director y soporte.
 */
@Data
public class Pelicula {
    private int id;
    private String titulo;
    private String descripcion;
    private int ano;
    private String director;
    private String soporte;

    /**
     * Constructor completo para la clase Pelicula.
     *
     * @param id El ID único de la película.
     * @param titulo El título de la película.
     * @param descripcion Una breve descripción de la película.
     * @param ano El año de estreno de la película.
     * @param director El director de la película.
     * @param soporte El tipo de soporte en el que está disponible la película (por ejemplo, DVD, Blu-ray).
     */
    public Pelicula(int id, String titulo, String descripcion, int ano, String director, String soporte) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ano = ano;
        this.director = director;
        this.soporte = soporte;
    }

    /**
     * Constructor vacío para la clase Pelicula.
     * Permite crear una instancia de Pelicula sin parámetros, útil cuando se requiere llenar
     * los datos después de su creación.
     */
    public Pelicula() {}

}
