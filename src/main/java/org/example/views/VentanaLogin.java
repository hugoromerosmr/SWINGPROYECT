package org.example.views;

import org.example.dao.LoginDAO;
import org.example.dao.CopiasDAO;
import org.example.model.Login;
import org.example.dao.JDBC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * La clase VentanaLogin extiende JFrame y proporciona una interfaz gráfica para que los usuarios
 * inicien sesión. Al ingresar el nombre de usuario y la contraseña, se verifica la autenticación
 * con la base de datos y, si es correcto, permite el acceso a la ventana principal del sistema.
 */
public class VentanaLogin extends JFrame {
    private JTextField textuser;
    private JPasswordField textcon;
    private JPanel principal;
    private JLabel titulo;
    private JPanel panellogin;
    private JLabel labeltextuser;
    private JLabel labeltexcon;
    private JLabel img;
    private JButton buttonlogin;
    private JPanel panelboton;
    private JPanel panelcabecera;
    private JButton botonsalir;
    private JLabel textccon;

    /**
     * Constructor de VentanaLogin.
     * Inicializa la interfaz de inicio de sesión y maneja las acciones para autenticar a los usuarios.
     * Al autenticar correctamente, redirige a la ventana principal del sistema.
     */
    public VentanaLogin() {
        setContentPane(principal);
        setTitle("Login");
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Acción del botón 'Salir' que cierra la ventana
        botonsalir.addActionListener((ActionEvent e) -> {
            dispose();
        });

        // Acción del botón 'Login' que intenta autenticar al usuario
        buttonlogin.addActionListener((ActionEvent e) -> {
            String user = textuser.getText();  // Obtener el nombre de usuario ingresado
            String con = new String(textcon.getPassword());  // Obtener la contraseña ingresada

            // Establecer la conexión a la base de datos
            Connection connection = JDBC.getConnection();
            LoginDAO loginDAO = new LoginDAO(connection);

            // Intentar obtener el usuario de la base de datos
            Login login = loginDAO.obtenerUsuario(user, con);

            // Crear una instancia de CopiasDAO
            CopiasDAO copiasDAO = new CopiasDAO();

            if (login != null) {
                // Usuario autenticado correctamente
                JOptionPane.showMessageDialog(null, "Bienvenid@ de nuevo " + user);
                new VentanaPrincipal(copiasDAO, login.getId()).setVisible(true);
                pack();
                dispose();
            } else {
                // Fallo en la autenticación
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
            }
        });
    }
}
