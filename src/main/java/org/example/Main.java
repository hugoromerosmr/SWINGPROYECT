package org.example;

import org.example.views.VentanaLogin;

/**
 * La clase Main es el punto de entrada de la aplicación.
 * Inicia la interfaz de usuario mostrando la ventana de inicio de sesión {@link VentanaLogin}.
 */
public class Main {
    /**
     * Método principal (main) de la aplicación.
     * Crea e inicia la ventana de inicio de sesión.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Crear e iniciar la ventana de login
        VentanaLogin interfaz = new VentanaLogin();
        interfaz.setVisible(true);
    }
}
