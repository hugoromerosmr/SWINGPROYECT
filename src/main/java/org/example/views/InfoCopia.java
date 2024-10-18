package org.example.views;

import org.example.model.Copias;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * La clase InfoCopia extiende JFrame y se utiliza para mostrar la información detallada
 * sobre una copia específica de una película, incluyendo el título, estado, soporte,
 * descripción, director y año de la película.
 */
public class InfoCopia extends JFrame {
    private JPanel PanelPrincipal;
    private JButton button1;
    private JLabel titulodetails;
    private JLabel estadodetails;
    private JLabel soportedetails;
    private JLabel descriptiondetails;
    private JLabel directordetails;
    private JLabel anodetails;
    private JPanel panel;

    /**
     * Constructor de InfoCopia.
     * Inicializa la interfaz gráfica para mostrar la información de una copia seleccionada.
     *
     * @param copiaSeleccionada El objeto {@link Copias} que contiene la información
     *                          de la copia seleccionada para ser mostrada.
     */
    public InfoCopia(Copias copiaSeleccionada) {
        // Configuración básica de la ventana
        PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal, BoxLayout.Y_AXIS));
        setContentPane(PanelPrincipal);
        setSize(500, 660); // Ajustamos a 500x500 píxeles
        setTitle("Info de copia " + copiaSeleccionada.getPelicula().getTitulo());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centra la ventana en pantalla
        PanelPrincipal.setBackground(new Color(240, 240, 240)); // Color de fondo claro

        // Configurar margen para dar un buen espaciado
        PanelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));  // Ajustamos el margen

        // Estilo y configuración de etiquetas
        Font labelFont = new Font("Arial", Font.BOLD, 13); // Fuente ajustada para mejor escala

        titulodetails.setText("Título --> " + copiaSeleccionada.getPelicula().getTitulo());
        titulodetails.setFont(labelFont); // Aplicar la fuente
        estadodetails.setText("Estado --> " + copiaSeleccionada.getEstado());
        estadodetails.setFont(labelFont);
        soportedetails.setText("Soporte --> " + copiaSeleccionada.getSoporte());
        soportedetails.setFont(labelFont);
        descriptiondetails.setText("<html><body style='width: 200px'>" + "Descripción  --> " + copiaSeleccionada.getPelicula().getDescripcion() + "</body></html>");
        descriptiondetails.setFont(labelFont);
        directordetails.setText("Director --> " + copiaSeleccionada.getPelicula().getDirector());
        directordetails.setFont(labelFont);
        anodetails.setText("Año --> " + String.valueOf(copiaSeleccionada.getPelicula().getAno()));
        anodetails.setFont(labelFont);

        // Espaciado vertical entre componentes
        titulodetails.setBorder(new EmptyBorder(8, 0, 8, 0));  // Ajustar espaciado
        estadodetails.setBorder(new EmptyBorder(8, 0, 8, 0));
        soportedetails.setBorder(new EmptyBorder(8, 0, 8, 0));
        descriptiondetails.setBorder(new EmptyBorder(8, 0, 8, 0));
        directordetails.setBorder(new EmptyBorder(8, 0, 8, 0));
        anodetails.setBorder(new EmptyBorder(8, 0, 8, 0));

        // Añadir bordes con título para secciones
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "DETALLES DE LA COPIA",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 15),
                Color.BLACK));

        // Acción para cerrar la ventana cuando se presiona el botón
        button1.addActionListener(e -> dispose());

        setVisible(true);
    }
}
