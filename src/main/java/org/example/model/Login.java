package org.example.model;

import lombok.Data;

/**
 * La clase Login representa la información de inicio de sesión de un usuario.
 * Contiene el ID del usuario, su nombre de usuario y la contraseña.
 */
@Data
public class Login {
    private int id;
    private String nombreUsuario;
    private String contrasena;

    /**
     * Constructor completo para la clase Login.
     *
     * @param id El ID único del usuario.
     * @param nombreUsuario El nombre de usuario utilizado para el inicio de sesión.
     * @param contrasena La contraseña asociada al usuario.
     */
    public Login(int id, String nombreUsuario, String contrasena) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
}

