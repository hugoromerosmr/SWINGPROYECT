package org.example.views;

import org.example.model.Copias;

import javax.swing.*;
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
        PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal, BoxLayout.Y_AXIS));

        setContentPane(PanelPrincipal);
        setSize(600, 600);
        setTitle("Info de copia " + copiaSeleccionada.getPelicula().getTitulo());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar los detalles de la película y la copia seleccionada
        titulodetails.setText("Título --> " + copiaSeleccionada.getPelicula().getTitulo());
        estadodetails.setText("Estado --> " + copiaSeleccionada.getEstado());
        soportedetails.setText("Soporte --> " + copiaSeleccionada.getSoporte());
        descriptiondetails.setText("Descripción --> " + copiaSeleccionada.getPelicula().getDescripcion());
        directordetails.setText("Director --> " + copiaSeleccionada.getPelicula().getDirector());
        anodetails.setText("Año --> " + String.valueOf(copiaSeleccionada.getPelicula().getAno()));

        PanelPrincipal.revalidate();
        PanelPrincipal.repaint();

        // Acción para cerrar la ventana cuando se presiona el botón
        button1.addActionListener(e -> dispose());

        setVisible(true);
    }
}
