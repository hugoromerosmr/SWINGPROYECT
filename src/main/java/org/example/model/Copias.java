package org.example.model;

import lombok.Data;
import java.io.Serializable;

/**
 * La clase Copias representa una copia de una película asignada a un usuario.
 * Incluye información sobre la película, el usuario que tiene la copia, el estado de la copia y el soporte.
 */
@Data
public class Copias  {
    private int id;
    private Pelicula pelicula;
    private Login usuario;
    private String estado;
    private String soporte;

    /**
     * Constructor completo para la clase Copias.
     *
     * @param id El ID único de la copia.
     * @param pelicula La {@link Pelicula} asociada a la copia.
     * @param usuario El {@link Login} del usuario que tiene la copia.
     * @param estado El estado de la copia (por ejemplo, disponible, prestado, etc.).
     * @param soporte El tipo de soporte de la copia (por ejemplo, DVD, Blu-ray).
     */
    public Copias(int id, Pelicula pelicula, Login usuario, String estado, String soporte) {
        this.id = id;
        this.pelicula = pelicula;
        this.usuario = usuario;
        this.estado = estado;
        this.soporte = soporte;
    }

    /**
     * Constructor vacío para la clase Copias.
     * Permite crear una instancia vacía que luego se puede llenar con datos.
     */
    public Copias() {

    }
}
