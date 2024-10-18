package org.example.views;

import org.example.dao.CopiasDAO;
import org.example.model.Copias;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * La clase VentanaPrincipal extiende JFrame y muestra una lista de las copias (películas o juegos)
 * asociadas a un usuario específico. Proporciona una tabla con el título, estado y soporte de cada copia
 * y permite al usuario ver detalles adicionales al seleccionar una fila de la tabla.
 */
public class VentanaPrincipal extends JFrame {
    private JTable tablajuegos;
    private JPanel cabecerajuego;
    private JPanel paneltabla;
    private JLabel img;
    private JPanel pantallajuegos;
    private JButton botoncerrar;
    private JButton botonatras;

    /**
     * Constructor de VentanaPrincipal.
     * Inicializa la ventana principal que muestra las copias (juegos/películas) del usuario en una tabla.
     * Los detalles de una copia seleccionada se pueden ver en una ventana separada.
     *
     * @param copiasDAO El objeto {@link CopiasDAO} utilizado para obtener las copias del usuario.
     * @param idUsuario El ID del usuario cuyas copias se van a mostrar.
     */
    public VentanaPrincipal(CopiasDAO copiasDAO, int idUsuario) {
        setContentPane(pantallajuegos);
        setSize(500, 500);
        setTitle("Juegos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Obtener la lista de copias del usuario
        List<Copias> copias = copiasDAO.obtenerCopiasPorUsuario(idUsuario);

        // Definir la cabecera de la tabla y los datos
        String[] cabeceratabla = {"Titulo", "Estado", "Soporte"};
        String[][] data = new String[copias.size()][3];
        for (int i = 0; i < copias.size(); i++) {
            Copias copia = copias.get(i);
            data[i][0] = copia.getPelicula().getTitulo();
            data[i][1] = copia.getEstado();
            data[i][2] = copia.getSoporte();
        }

        // Configuración de la tabla
        tablajuegos.setModel(new DefaultTableModel(data, cabeceratabla));
        tablajuegos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablajuegos.getTableHeader().setReorderingAllowed(false);
        tablajuegos.getTableHeader().setResizingAllowed(false);

        // Añadir un evento para seleccionar una fila y mostrar los detalles de la copia seleccionada
        tablajuegos.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            if (!event.getValueIsAdjusting()) {
                int selectedRow = tablajuegos.getSelectedRow();
                if (selectedRow != -1) {
                    Copias copiaSeleccionada = copias.get(selectedRow);
                    new InfoCopia(copiaSeleccionada).setVisible(true);
                }
            }
        });

        // Botón para cerrar la aplicación
        botoncerrar.addActionListener(e -> System.exit(0));

        // Botón para volver a la ventana de inicio de sesión
        botonatras.addActionListener(e -> {
            dispose();
            new VentanaLogin().setVisible(true);
        });
    }
}

